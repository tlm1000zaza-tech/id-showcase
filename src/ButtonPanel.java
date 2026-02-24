import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JPanel actionBtn = new JPanel();
    private JPanel passBtn = new JPanel();
    private JButton button = new JButton("BUTTY");
    private ActionListener action = e -> {
        RemoteEvent.Event().fireEvent(Remote.ACTION_CHANNEL, null);
    };
    private ActionListener pass = e -> {
        RemoteEvent.Event().fireEvent(Remote.PASS_CHANNEL, null);
    };

    ButtonPanel() {
        setLayout(null);
        add(button);

    }
    public void Init() {
        UIHelper.apply(button,1,0,0,0,1,0,0,0);
    }

    public void setAc() {
        button.removeActionListener(pass);
        button.addActionListener(action);
        button.setText("ACTION");


    }
    public void setPass() {
        button.removeActionListener(action);
        button.addActionListener(pass);
        button.setText("PASS");
    }
}
