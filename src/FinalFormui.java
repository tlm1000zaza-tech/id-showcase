import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FinalFormui extends JFrame {

    maingameUI mainGameUI = new maingameUI();
    EndScreen endScreen = new EndScreen();
    //    page Page = new page();
    List<JPanel> panelList = new ArrayList<>();
    FinalFormui() {
        panelList.add(mainGameUI);
        panelList.add(endScreen);
//        panelList.add(Page);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1280,720);
        setVisible(true);
        setLayout(null);
        Init();
        Enable(mainGameUI);

        RemoteEvent.Event().onEvent((Channel, data) -> {
            if (Channel == Remote.ENDSCREEN) {
                Enable(endScreen);
            }
        });
    }

    public void Init() {
        for (int i = 0; i < panelList.size(); i++) {
            add(panelList.get(i));
            UIHelper.apply(panelList.get(i), 1,0,0,0,1,0,0,0);
        }
//        Page.Init();
        mainGameUI.GenLowerRow();
        endScreen.Init();
    }
    public void Enable(JPanel panel) {
        Disableall();
        panel.setVisible(true);
        panel.setEnabled(true);
    }

    public void Disableall() {
        for (JPanel p : panelList) {
            p.setVisible(false);
            p.setEnabled(false);
        }
    }
}