import javax.swing.*;
import java.awt.*;

public class ActionAndCondition extends JPanel {

    ActionAndCondition() {
        setLayout(null);
        add(labelActionAndCondition);
    }


    ImageIcon ActionAndCondition = new ImageIcon("skill.png");
    JLabel labelActionAndCondition = new JLabel() {

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(ActionAndCondition.getImage(),0,0,getWidth(),getHeight(),this);
        }
    };

    public void Init() {

        UIHelper.apply(labelActionAndCondition,1,0,0,0,1,0,0,0,0,0);
    }
}
