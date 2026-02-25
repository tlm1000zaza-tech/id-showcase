import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {

        System.out.println("GamePanel Loaded");

        setLayout(null);

        setBackground(Color.BLUE);

        JLabel text = new JLabel("THIS IS GAME PANEL");

        text.setForeground(Color.WHITE);

        text.setBounds(500,300,300,50);

        add(text);

    }

}