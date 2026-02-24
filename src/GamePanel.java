import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    ImageLabel test;

    public GamePanel() {

        setLayout(null);

        setBorder(BorderFactory.createLineBorder(Color.RED));

        test = new ImageLabel("/background.png");

        add(test);

        UIHelper.apply(
                test,
                0.5,0,
                0.5,0,
                1,0,
                1,0,
                0.5,0.5
        );

    }

}