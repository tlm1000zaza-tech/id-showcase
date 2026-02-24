import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JPanel actionBtn = new JPanel();
    private JPanel passBtn = new JPanel();
    private JButton button = new JButton();
    private ActionListener action = e -> {
        System.out.println();
    };
    private ActionListener pass = e -> {
        System.out.println();
    };

    ButtonPanel() {
        setLayout(null);

    }
}
