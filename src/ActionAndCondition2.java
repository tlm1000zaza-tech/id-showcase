import javax.swing.*;
import java.awt.*;

public class ActionAndCondition2 extends JPanel {

    ActionAndCondition2() {
        setLayout(null);
        add(labelActionAndCondition2);
    }


    ImageIcon ActionAndCondition2 = new ImageIcon("skill2.png");
    JLabel labelActionAndCondition2 = new JLabel() {

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(ActionAndCondition2.getImage(),0,0,getWidth(),getHeight(),this);
        }
    };

    public void Init() {

        UIHelper.apply(labelActionAndCondition2,1,0,0,0,1,0,0,0,0,0);
    }
}
