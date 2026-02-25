import javax.swing.*;
        import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MiddlePanel extends JPanel {
    private JPanel actionBtn = new JPanel();
    private JPanel passBtn = new JPanel();
    private boolean isUseable;
    private int index;
    private ActionTai soul;
    private JButton buttonselect = new JButton("");
    private List<JButton> bt = new ArrayList<>();
    private JButton buttonLock = new JButton("");
    private ActionListener pass = e -> {
        RemoteEvent.Event().fireEvent(Remote.ACTIONEXEC_CHANNEL, index);
        System.out.println("E");
    };

    MiddlePanel() {
        setLayout(null);
        buttonLock.setContentAreaFilled(false);
        bt.add(buttonselect);
        bt.add(buttonLock);
        for (JButton b : bt) {
            add(b);
            b.addActionListener(pass);
        }

        RemoteEvent.Event().onEvent((Channel, data) -> {
            if (Channel == Remote.REQUESTINDEX_CHANNEL) {
                if ((int) data == 1) {
                    setEnableSelect();
                } else if ((int) data ==2) {
                    setEnableLock();
                    System.out.println("K");
                }
            }
        });

    }
    public void Init() {
        for (JButton b : bt) {
            UIHelper.apply(b,1,0,0,0,1,0,0,0);
        }

    }

    public void setDisable() {
        for (JButton b : bt) {
            b.setEnabled(false);
        }
    }
    public void setEnableSelect() {
        for (JButton b : bt) {
            b.setEnabled(false);
        }
        if (isUseable) {
            buttonselect.setEnabled(true);
            setComponentZOrder(buttonselect,0);

        }
    }

    public void setEnableLock() {
        for (JButton b : bt) {
            b.setEnabled(false);
        }
        if (isUseable) {
            buttonLock.setEnabled(true);
            setComponentZOrder(buttonLock,0);
        }
    }

    public void setText(String txt) {
        buttonselect.setText(txt);
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
