import javax.swing.*;
import java.awt.*;

public class page extends JPanel {
    private JLabel n = new JLabel("HEllo");

    page() {
        setBackground(new Color(205, 166, 166));
        setLayout(null);
        add(n);
    }

    public void Init(){
        UIHelper.apply(n,0.5,0,0.5,0,0.5,0,0.5,0,0.5,0.5);
    };
}
