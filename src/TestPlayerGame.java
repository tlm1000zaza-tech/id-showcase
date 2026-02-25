//import javax.swing.*;
//
//public class TestPlayerGame {
//
//    public static void main(String[] args) {
//
//        // 1 สร้าง Deck
//        Deck deck = new Deck();
//
//        deck.shuffle();
//
//
//        // 2 สร้าง Player
//        PlayerPoker player = new PlayerPoker(5);
//
//
//        // 3 แจกไพ่ 2 ใบ
//        player.getHand().addCard(deck.drawCard());
//
//        player.getHand().addCard(deck.drawCard());
//
//
//        // 4 สร้าง JFrame
//        JFrame frame = new JFrame();
//
//        frame.setSize(1000,700);
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        frame.setLayout(null);
//
//
//        // 5 ดึงไพ่จาก Hand
//        Card card1 = player.getHand().getCard(0);
//
//        Card card2 = player.getHand().getCard(1);
//
//
//        // 6 สร้าง CardLabel
//        CardLabel label1 = new CardLabel(card1);
//
//        CardLabel label2 = new CardLabel(card2);
//
//
//        // 7 ตั้งตำแหน่ง
//        label1.setBounds(300,300,100,150);
//
//        label2.setBounds(420,300,100,150);
//
//
//        // 8 เพิ่มเข้า frame
//        frame.add(label1);
//
//        frame.add(label2);
//
//
//        // 9 แสดงผล
//        frame.setVisible(true);
//
//    }
//
//}