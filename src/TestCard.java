import javax.swing.*;

public class TestCard {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setSize(300,400);

        frame.setLayout(null);

        Card card = new Card(Type.SPADE, Rank.ACE);

        CardLabel label = new CardLabel(card, null, 50, 50, 100, 150);

        frame.add(label);

        frame.setVisible(true);

    }

}