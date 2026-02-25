import javax.swing.*;
import java.awt.event.ActionListener;

public class ActionPanel extends JPanel {
    private JPanel actionBtn = new JPanel();
    private JPanel passBtn = new JPanel();
    private boolean isUseable;
    private ActionTai soul;
    private JButton button = new JButton("BUTTY");
    private ActionListener pass = e -> {
        RemoteEvent.Event().fireEvent(Remote.ACTIONTEMP_CHANNEL , soul);
//        RemoteEvent.Event().fireEvent(Remote.DISABLE , null);
    };

    ActionPanel() {
        setLayout(null);
        add(button);
        button.addActionListener(pass);
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
        button.setText(txt);
    }

    public void canUseable() {
        isUseable = true;
    }

    public boolean isUseable() {
        return isUseable;
    }

    public void soulbound(ActionTai soul) {
        this.soul = soul;
    }
}
