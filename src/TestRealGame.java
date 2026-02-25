import javax.swing.*;

public class TestRealGame {

    public static void main(String[] args) {


        // สร้าง Deck
        Deck deck = new Deck();

        deck.shuffle();


        // สร้าง Player
        PlayerPoker player = new PlayerPoker(5);


        // แจกไพ่ 2 ใบ
        player.getHand().addCard(deck.drawCard());

        player.getHand().addCard(deck.drawCard());



        JFrame frame = new JFrame();

        frame.setSize(1000,700);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);



        GamePanel panel = new GamePanel(player);

        panel.setBounds(0,0,1000,700);

        frame.add(panel);


        frame.setVisible(true);

    }

}