import javax.swing.*;

public class MainRunGame{

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");

        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new LoginFrame());

        frame.setVisible(true);

    }

}