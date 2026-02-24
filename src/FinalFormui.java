import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FinalFormui extends JFrame {

    maingameUI mainGameUI = new maingameUI();
    List<JPanel> panelList = new ArrayList<>();
    FinalFormui() {
        panelList.add(mainGameUI);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1280,720);
        setVisible(true);
        setLayout(null);
        Init();
    }

    public void Init() {
        for (int i = 0; i < panelList.size(); i++) {
            add(panelList.get(i));
            UIHelper.apply(panelList.get(i), 1,0,0,0,1,0,0,0);
        }
        mainGameUI.GenLowerRow();
    }
}
