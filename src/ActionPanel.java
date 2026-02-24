import javax.swing.*;
import java.awt.event.ActionListener;

public class ActionPanel extends JPanel {
    private JPanel actionBtn = new JPanel();
    private JPanel passBtn = new JPanel();
    private boolean isUseable;
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
        if (isUseable) {
            button.setEnabled(true);
        }
    }
    public void setText(String txt) {
        button.setText("Action : " + txt);
    }

    public void canUseable() {
        isUseable = true;
    }

    public boolean isUseable() {
        return isUseable;
    }
}
