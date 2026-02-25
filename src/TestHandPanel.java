//import javax.swing.*;
//
//public class TestHandPanel {
//
//    public static void main(String[] args) {
//
//        // สร้างหน้าต่าง
//        JFrame frame = new JFrame("Test Hand");
//
//        frame.setSize(800,600);
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        frame.setLayout(null);
//
//
//        // สร้าง Hand
//        Hand hand = new Hand();
//
//        for(Type t : Type.values()){
//
//            for(Rank r : Rank.values()){
//
//                hand.addCard(new Card(t,r));
//
//            }
//
//        }
//
//
//        // แสดงไพ่
//        int x = 50;
//
//        for(Card card : hand.getCards()){
//
//            CardLabel label = new CardLabel(card,this,x,y,80,120);
//
//            label.setBounds(x, 50, 100, 150);
//
//            frame.add(label);
//
//            x += 120;
//
//        }
//
//
//        frame.setVisible(true);
//
//    }
//
//}