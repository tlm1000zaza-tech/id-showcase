import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FinalFormui extends JFrame {

    RulePlay rulePlay = new RulePlay();
    PokerHandRank pokerHandRank = new PokerHandRank();
    ActionAndCondition actionAndCondition = new ActionAndCondition();
    ActionAndCondition1 actionAndCondition1 = new ActionAndCondition1();
    ActionAndCondition2 actionAndCondition2 = new ActionAndCondition2();
//    maingameUI mainGameUI = new maingameUI();
    List<JPanel> panelList = new ArrayList<>();
    FinalFormui() {
//        panelList.add(rulePlay);
//        panelList.add(pokerHandRank);
//        panelList.add(actionAndCondition);
//        panelList.add(actionAndCondition1);
        panelList.add(actionAndCondition2);

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

//        rulePlay.Init();
//        pokerHandRank.Init();
//        actionAndCondition.Init();
//        actionAndCondition1.Init();
        actionAndCondition2.Init();


//        mainGameUI.GenLowerRow();
    }
}
