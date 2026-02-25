import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EndScreen extends JPanel {
    private JButton exit = new JButton("Exit");
    private JButton pa = new JButton("Play again");
    private JLabel score = new JLabel("N/A");
    private JLabel result = new JLabel("N/A");
    private List<JButton> list = new ArrayList<>();
    EndScreen() {
        setLayout(null);
        setBackground(new Color(53, 96, 73, 255));
        list.add(pa);
        list.add(exit);
        score.setHorizontalAlignment(JLabel.CENTER);
        score.setFont(new Font("Arial", Font.BOLD, 45));
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setFont(new Font("Arial", Font.BOLD, 45));
        RemoteEvent.Event().onEvent((Channel, data) -> {
            if (Channel == Remote.ENDSCREEN) {
                score.setText("Score : " + data);
                if ((int) data > 0) {
                    result.setText("YOU WIN");
                } else {
                    result.setText("YOU LOSE");

                }
            }
        });

        for (JButton n : list) {
            add(n);
            n.setHorizontalAlignment(JLabel.CENTER);
        }
        add(score);
        add(result);
    }
    public void Init() {
        UIHelper.apply(pa, 0.4, 0,0.5,0,0.1,0,0.3,0,0.5,0.5);
        UIHelper.apply(exit, 0.4, 0,0.5,0,0.1,0,0.6,0,0.5,0.5);
        UIHelper.apply(score, 0.4, 0,0.5,0,0.1,0,0.1,0,0.5,0.5);
        UIHelper.apply(result, 0.4, 0,0.5,0,0.1,0,0.2,0,0.5,0.5);
    }
}
