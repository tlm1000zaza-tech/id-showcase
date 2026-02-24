import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainUI {

    public static void main(String[] args) {

        FinalFormui ui = new FinalFormui();

        List<JLabel> listCard = new ArrayList<>();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        UIHelper.apply(panel, 1,0,0,0,1,0,0,0);


        ImageIcon background = new ImageIcon("background.png");
        JLabel label = new JLabel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                g.drawImage(background.getImage(),0,0,getWidth(),getHeight(),this);
//            }
        };
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        ImageIcon player = new ImageIcon("Player.png");
        JLabel label1 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(player.getImage(),0,0,getWidth(),getHeight(),this);
            }
        };
        label1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));


        ImageIcon card = new ImageIcon("card.png");
        JLabel label2 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(card.getImage(),0,0,getWidth(),getHeight(),this);
            }
        };
        label2.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));

        JLabel label3 = new JLabel() {};
        label3.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        JLabel label4 = new JLabel() {};
        label4.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        JLabel label5 = new JLabel() {};
        label5.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        JLabel label6 = new JLabel() {};
        label6.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        JLabel label7 = new JLabel() {};
        label7.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));



        JLabel label8 = new JLabel() {};
        label8.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));

        JLabel label9 = new JLabel() {};
        label9.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));



        JLabel label10 = new JLabel() {};
        label10.setBorder(BorderFactory.createLineBorder(Color.RED,2));

        JLabel label11 = new JLabel() {};
        label11.setBorder(BorderFactory.createLineBorder(Color.RED,2));

        JLabel label12 = new JLabel() {};
        label12.setBorder(BorderFactory.createLineBorder(Color.RED,2));



        JLabel label13 = new JLabel() {};
        label13.setBorder(BorderFactory.createLineBorder(Color.ORANGE,15));

        JLabel label14 = new JLabel() {};
        label14.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

        JLabel label15 = new JLabel() {};
        label15.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

        JLabel label16 = new JLabel() {};
        label16.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

        JLabel label17 = new JLabel() {};
        label17.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

        JLabel label18 = new JLabel() {};
        label18.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

        JLabel label19 = new JLabel() {};
        label19.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

        JLabel label20 = new JLabel() {};
        label20.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

        JLabel label21 = new JLabel() {};
        label21.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

        JLabel label22 = new JLabel() {};
        label22.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

        JLabel label23 = new JLabel() {};
        label23.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

        JLabel label24 = new JLabel() {};
        label24.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));


        ImageIcon action = new ImageIcon("Action.png");
        JLabel label25 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(action.getImage(),0,0,getWidth(),getHeight(),this);
            }
        };
        label25.setBorder(BorderFactory.createLineBorder(Color.PINK,2));

        ImageIcon pass = new ImageIcon("pass.png");
        JLabel label26 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(pass.getImage(),0,0,getWidth(),getHeight(),this);
            }
        };
        label26.setBorder(BorderFactory.createLineBorder(Color.PINK,2));



        JLabel label27 = new JLabel() {};
        label27.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2));

        JLabel label28 = new JLabel() {};
        label28.setBorder(BorderFactory.createLineBorder(Color.YELLOW,2));

        JLabel label29 = new JLabel() {};
        label29.setBorder(BorderFactory.createLineBorder(Color.YELLOW,2));



        JLabel label30 = new JLabel() {};
        label30.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        JLabel label31 = new JLabel() {};
        label31.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        panel.add(label);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        panel.add(label10);
        panel.add(label11);
        panel.add(label12);


        panel.add(label25);
        panel.add(label26);

        panel.add(label27);
        panel.add(label28);
        panel.add(label29);


        panel.add(label30);
        panel.add(label31);


//        UIHelper.apply(label,0.99,0,0.5,0
//                ,0.99,0,0.5,0,
//                0.5,0.5);

    }

}