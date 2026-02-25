import javax.swing.*;
import java.awt.*;

public class TestShowCard {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setSize(300,400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        Card card = new Card(Type.SPADE, Rank.ACE);

        ImageIcon icon = new ImageIcon(card.getImagePath());

        Image img = icon.getImage();

        Image scaled = img.getScaledInstance(
                200,
                300,
                Image.SCALE_SMOOTH
        );

        ImageIcon scaledIcon = new ImageIcon(scaled);

        JLabel label = new JLabel(scaledIcon);

        label.setBounds(50,50,200,300);

        frame.add(label);

        frame.setVisible(true);

    }

}