import javax.swing.*;

public class TestGamePanel {

    public static void main(String[] args) {

        Deck deck = new Deck();

        deck.shuffle();


        PlayerPoker player = new PlayerPoker(5);


        player.getHand().addCard(deck.drawCard());

        player.getHand().addCard(deck.drawCard());

        player.getHand().addCard(deck.drawCard());


        JFrame frame = new JFrame();

        frame.setSize(1000,700);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        GamePanel panel = new GamePanel(player);

        frame.add(panel);

        frame.setVisible(true);

    }

}