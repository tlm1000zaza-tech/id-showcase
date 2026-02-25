import javax.swing.*;
import java.awt.*;

public class RulePlay extends JPanel {

    RulePlay() {
        setLayout(null);
        add(labelRuleGale);

    }

    ImageIcon ruleGame = new ImageIcon("ruleGame.png");
    JLabel labelRuleGale = new JLabel() {

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(ruleGame.getImage(),0,0,getWidth(),getHeight(),this);
        }
    };

    public void Init() {

        UIHelper.apply(labelRuleGale,1,0,0,0,1,0,0,0,0,0);

    }

}
