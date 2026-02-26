import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MiddlePanel extends JPanel {
    private JLabel cardLabel;
    private JPanel actionBtn = new JPanel();
    private JPanel passBtn = new JPanel();
    private boolean isUseable;
    private int index;
    private Card card;
    private ActionTai soul;
    private JButton buttonselect = new JButton("");
    private List<JButton> bt = new ArrayList<>();
    private JButton buttonLock = new JButton("");
    private JButton buttonsource = new JButton("");
    private JButton buttondes = new JButton("");
    private ActionListener pass = e -> {
        RemoteEvent.Event().fireEvent(Remote.ACTIONEXEC_CHANNEL, index);
        System.out.println("E");
    };

    MiddlePanel() {
        setLayout(null);
        cardLabel = new JLabel();
        cardLabel.setBounds(0,0,80,120);
        add(cardLabel);
        buttonLock.setContentAreaFilled(false);
        buttondes.setContentAreaFilled(false);
        buttonsource.setContentAreaFilled(false);

        buttonsource.addActionListener(e -> {
            RemoteEvent.Event().fireEvent(Remote.KUYTOK, index);
        });

        buttondes.addActionListener(e -> {
            RemoteEvent.Event().fireEvent(Remote.SEARCHDES, index);
            System.out.println(index);

            RemoteEvent.Event().fireEvent(Remote.DISABLE, index);
        });
        bt.add(buttonselect);
        bt.add(buttonLock);
        bt.add(buttonsource);
        bt.add(buttondes);
        for (JButton b : bt) {
            add(b);
            b.addActionListener(pass);
        }
        buttondes.removeActionListener(pass);
        RemoteEvent.Event().onEvent((Channel, data) -> {
            if (Channel == Remote.REQUESTINDEX_CHANNEL) {
                if ((int) data == 1) {
                    setEnableSelect();
                } else if ((int) data ==2) {
                    setEnableLock();
                    System.out.println("K");
                }
            } else if (Channel == Remote.COPY_REQUEST) {
                setEnableSource();
                System.out.println("hllo");
            }
        });

    }


    public void setCardIcon(ImageIcon icon) {

        Image img = icon.getImage();

        Image newImg = img.getScaledInstance(
                cardLabel.getWidth(),
                cardLabel.getHeight(),
                Image.SCALE_SMOOTH
        );

        cardLabel.setBounds(0, 0, getWidth(), getHeight());

        cardLabel.setIcon(new ImageIcon(newImg));



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
        System.out.println("DISABLE");
        isUseable = false;
    }
    public void setEnableSelect() {
        for (JButton b : bt) {
            b.setEnabled(false);
        }
        if (isUseable) {
            System.out.println("USEABLE");
            buttonselect.setEnabled(true);
            setComponentZOrder(buttonselect,0);

        } else {
            System.out.println("PLS");
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
    public void setEnableSource() {
        for (JButton b : bt) {
            b.setEnabled(false);
        }
        if (isUseable) {
            buttonsource.setEnabled(true);
            setComponentZOrder(buttonsource,0);
        }
    }
    public void setEnableDes() {
        for (JButton b : bt) {
            b.setEnabled(false);
        }
        if (isUseable) {
            buttondes.setEnabled(true);
            setComponentZOrder(buttondes,0);
        }
    }

    public void setText(String txt) {
        buttonselect.setText(txt);
    }

    public void canUseable() {
        isUseable = true;
        System.out.println("TRUE");
    }

    public boolean isUseable() {
        return isUseable;
    }

    public void soulbound(Card card) {

        this.card = card;

        // ⭐ ถ้ามีไพ่
        if(card != null) {

            // โหลดรูปจาก path
            ImageIcon icon = new ImageIcon(card.getImagePath());

            // ใส่รูปลง label
            setCardIcon(icon);

        }

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Card getCard() {
        return card;
    }

     public void perish() {
        card = null;
     }

     public void resetCard() {

        cardLabel.setIcon(null);
     }
}
