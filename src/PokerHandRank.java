import javax.swing.*;
import java.awt.*;

public class PokerHandRank extends JPanel {

    PokerHandRank() {
        setLayout(null);
        add(labelPokerHandRank);
    }


    ImageIcon PokerHandRank = new ImageIcon("PokerHandRank.png");
    JLabel labelPokerHandRank = new JLabel() {

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(PokerHandRank.getImage(),0,0,getWidth(),getHeight(),this);
        }
    };

    public void Init() {

        UIHelper.apply(labelPokerHandRank,1,0,0,0,1,0,0,0,0,0);

    }
}
