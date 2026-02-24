import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class maingameUI extends JPanel {
    private List<JLabel> listCard = new ArrayList<>();
    private List<ActionPanel> actionPanels = new ArrayList<>();
    private List<ButtonPanel> Button = new ArrayList<>();
    private List<JLabel> odinaryButton = new ArrayList<>();
    private List<JLabel> hand = new ArrayList<>();
    private JLabel targetBlock = new JLabel();
    private JLabel levelBlock = new JLabel();
    private JLabel scoreBlock = new JLabel();
    private JLabel player = new JLabel();
    private JLabel deck = new JLabel();
    private List<Card> tc =new ArrayList<>();
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Font font2 = new Font("Arial", Font.BOLD, 10);
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
                tc.clear();
                System.out.println("[MAINUI] - RECEIVE DATA : " + data );
                if (data instanceof Integer) {
                    levelBlock.setText("Level : " + data);
                    int ndata = (int) data;
                    if (ndata==1) {
                        for (int i = 0; i < 5; i++) {
                            actionPanels.get(i).canUseable();
                        }
                        targetBlock.setText("TARGET : ONE PAIR");
                    } else if (ndata==2) {
                        for (int i = 0; i < 6; i++) {
                            actionPanels.get(i).canUseable();
                        }
                        targetBlock.setText("TARGET : THREE OF A KIND");
                    } else if (ndata==3) {
                        for (int i = 0; i < 7; i++) {
                            actionPanels.get(i).canUseable();
                        }
                        targetBlock.setText("TARGET : FLUSH");
                    }else if (ndata==4) {
                        for (int i = 0; i < 9; i++) {
                            actionPanels.get(i).canUseable();
                        }
                        targetBlock.setText("TARGET : FOUR OF A KIND");
                    }else if (ndata==5) {
                        for (int i = 0; i < 12; i++) {
                            actionPanels.get(i).canUseable();
                        }
                        targetBlock.setText("TARGET : ROYAL FLUSH");
                    }
                }
            } else if (Channel == Remote.ACTION_CHANNEL) {
                for (ActionPanel ap : actionPanels) {
                    ap.setEnable();
                }
            } else if (Channel == Remote.SHOW_CHANNEL) {

                if (data instanceof Card) {
                    Card tempcard = (Card) data;
                    tc.add(tempcard);
                    for (Card cil : tc) {
                        hand.get(tc.indexOf(cil)).setText(cil.toString());
                    }
                }




            }
        });
    }

    public void GenLowerRow() {

        // action
        for (int i = 0; i < 12; i++) {
            ActionPanel n = new ActionPanel();
            n.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            actionPanels.add(n);
            add(n);
            UIHelper.apply(n,0.06,0,0.12 + (i*0.07),0
                    ,0.15,0,0.9,0,
                    0.5,0.5);
            n.Init();
            n.setDisable();
            n.setText(String.valueOf(i+1));
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
            hand.add(n);
            add(n);
            n.setFont(font2);
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
