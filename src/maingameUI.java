import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class maingameUI extends JPanel {
    private List<JLabel> listCard = new ArrayList<>();
    private List<ButtonPanel> Button = new ArrayList<>();
    private List<JLabel> odinaryButton = new ArrayList<>();
    private JLabel targetBlock = new JLabel();
    private JLabel levelBlock = new JLabel();
    private JLabel scoreBlock = new JLabel();
    private JLabel player = new JLabel();
    private JLabel deck = new JLabel();
    private Font font = new Font("Arial", Font.BOLD, 20);
    maingameUI() {
        odinaryButton.add(targetBlock);
        odinaryButton.add(scoreBlock);
        odinaryButton.add(levelBlock);
        odinaryButton.add(player);
        odinaryButton.add(deck);

        setLayout(null);
        setBackground(new Color(0, 255, 4));
        for (JLabel txt : odinaryButton) {
            txt.setFont(font);
            txt.setForeground(Color.BLACK);
        }

        RemoteEvent.Event().onEvent((Channel, data) -> {
            if (Channel==Remote.STAGE_CHANNEL) {
                System.out.println("[MAINUI] - RECEIVE DATA : " + data );
                if (data instanceof Integer) {
                    levelBlock.setText("Level : " + data);
                }
            }
        });
    }

    public void GenLowerRow() {

        // action
        for (int i = 0; i < 12; i++) {
            JLabel n = new JLabel();
            n.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            listCard.add(n);
            add(n);
            UIHelper.apply(n,0.06,0,0.12 + (i*0.07),0
                    ,0.15,0,0.9,0,
                    0.5,0.5);
        }
        //maddle
        for (int i = 0; i < 5; i++) {
            JLabel n = new JLabel();
            n.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            listCard.add(n);
            add(n);
            UIHelper.apply(n,0.06,0,0.40 + (i*0.07),0
                    ,0.15,0,0.40,0,
                    0.5,0.5);
        }

        for (int i = 0; i < 3; i++) {
            JLabel n = new JLabel();
            n.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            listCard.add(n);
            add(n);
            UIHelper.apply(n,0.06,0,0.95 - (i*0.07),0
                    ,0.15,0,0.1,0,
                    0.5,0.5);
        }

        for (int i = 0; i < 2; i++) {
            JLabel n = new JLabel();
            n.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            listCard.add(n);
            add(n);
            UIHelper.apply(n,0.06,0,0.45 + (i*0.10),0
                    ,0.15,0,0.60,0,
                    0.5,0.5);
        }

        for (int i = 0; i < 2; i++) {
            ButtonPanel n = new ButtonPanel();
            n.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            Button.add(n);
            add(n);
            UIHelper.apply(n,0.115,0,0.30 + (i*0.40),0
                    ,0.1,0,0.60,0,
                    0.5,0.5);
            n.Init();
            if (i==0) {
                n.setAc();
            } else {
                n.setPass();
            }
        }

        targetBlock .setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        add(targetBlock );
        UIHelper.apply(targetBlock ,0.25,0,0.5,0
                ,0.12,0,0.10,0,
                0.5,0.5);

        levelBlock.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        add(levelBlock);
        UIHelper.apply(levelBlock,0.10,0,0.10,0
                ,0.08,0,0.08,0,
                0.5,0.5);

        scoreBlock.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        add(scoreBlock);
        UIHelper.apply(scoreBlock,0.14,0,0.10,0
                ,0.08,0,0.20,0,
                0.5,0.5);

        player.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        add(player);
        UIHelper.apply(player,0.07,0,0.5,0
                ,0.1,0,0.75,0,
                0.5,0.5);

        deck.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        add(deck);
        UIHelper.apply(deck,0.06,0,0.30,0
                ,0.15,0,0.40,0,
                0.5,0.5);
    }
}
