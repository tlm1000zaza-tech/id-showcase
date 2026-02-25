import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JPanel {

    JTextField username;
    JPasswordField password;
    JButton login;
    JLabel result;

    public LoginFrame() {

        setLayout(null);

        username = new JTextField();
        username.setBounds(100,50,200,30);
        add(username);

        password = new JPasswordField();
        password.setBounds(100,100,200,30);
        add(password);

        login = new JButton("LOGIN");
        login.setBounds(150,150,100,30);
        add(login);

        result = new JLabel();
        result.setBounds(150,200,200,30);
        add(result);


        login.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String user = username.getText();

                String pass = new String(password.getPassword());

                boolean success = LoginService.login(user, pass);

                if(success){

                    result.setText("Login Success");
                    RemoteEvent.Event().fireEvent(Remote.CONNECT, null);

                }
                else{

                    result.setText("Login Failed");

                }

            }

        });

    }

}