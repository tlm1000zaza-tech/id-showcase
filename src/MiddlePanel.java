import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MiddlePanel extends JPanel {
    private JPanel actionBtn = new JPanel();
    private JPanel passBtn = new JPanel();
    private boolean isUseable;
    private int index;
    private ActionTai action;
    private JButton button = new JButton("BUTTY");
    private ActionListener actoinAc = e -> {
        RemoteEvent.Event().fireEvent(Remote.TEMPMIDDLE_CHANNEL, index);
        System.out.println("["+ index +"] : "+ button.getText());
    };

    MiddlePanel() {
        setLayout(null);
        add(button);
        button.setFont(new Font("Arial",Font.BOLD,8));
        button.addActionListener(actoinAc);
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
    public void setText(String txt) {
        button.setText(txt);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void canUseable() {
        isUseable = true;
    }

    public boolean isUseable() {
        return isUseable;
    }
    public void soulbound(ActionTai action) {
        this.action = action;
    }
}
