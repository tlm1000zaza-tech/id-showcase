import javax.swing.*;
import java.awt.event.ActionListener;

public class ActionPanel extends JPanel {
    private JPanel actionBtn = new JPanel();
    private JPanel passBtn = new JPanel();
    private JButton button = new JButton("BUTTY");
    private ActionListener pass = e -> {
        System.out.println("Pass");
    };

    ActionPanel() {
        setLayout(null);
        add(button);
    }
    public void Init() {

        UIHelper.apply(button,1,0,0,0,1,0,0,0);

    }

    public void setDisable() {
        button.setEnabled(false);
    }
    public void setEnable() {
        button.setEnabled(true);
    }
}
