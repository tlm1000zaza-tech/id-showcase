import javax.swing.*;
import java.awt.*;

public class ActionAndCondition1 extends JPanel {

    ActionAndCondition1() {
        setLayout(null);
        add(labelActionAndCondition1);
    }


    ImageIcon ActionAndCondition1 = new ImageIcon("skill1.png");
    JLabel labelActionAndCondition1 = new JLabel() {

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(ActionAndCondition1.getImage(),0,0,getWidth(),getHeight(),this);
        }
    };

    public void Init() {

        UIHelper.apply(labelActionAndCondition1,1,0,0,0,1,0,0,0,0,0);
    }
}
