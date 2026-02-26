import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private PlayerPoker player;
    private ArrayList<Card> tableCards = new ArrayList<>();
    private Card selectedCard = null;


    public GamePanel(PlayerPoker player) {

        this.player = player;

        setLayout(null);

        refreshAll();

    }

    private void showTable() {

        int x = 400;
        int y = 150;

        for(Card card : tableCards) {

            CardLabel label = new CardLabel(card,this,x,y,80,120);

            label.setBounds(x, y, 100, 145);

            add(label);

            x += 110;

        }

    }

    // ต้องมี method นี้อยู่ใน class
    private void showPlayerHand() {

        int startX = 300;
        int y = 500;

        int cardW = 100;
        int cardH = 145;

        int gap = 30;

        for(int i = 0; i < player.getHand().size(); i++)
        {

            Card card = player.getHand().getCard(i);

            CardLabel label =
                    new CardLabel(
                            card,
                            this,
                            startX + (i * (cardW + gap)),
                            y,
                            cardW,
                            cardH
                    );

            add(label);

        }

    }

    public void cardClicked(Card card) {

        // คลิกใบที่เลือกอยู่แล้ว = เล่น
        if(card == selectedCard) {

            playCard(card);

            selectedCard = null;

        }

        // คลิกใบใหม่ = highlight
        else {

            selectedCard = card;

        }

        refreshAll();

    }


    private void refreshAll() {

        removeAll();

        showTable();

        showPlayerHand();

        repaint();

        revalidate();

    }

    private void playCard(Card card) {

        player.getHand().removeCard(card);

        tableCards.add(card);

        refreshAll();

    }
}