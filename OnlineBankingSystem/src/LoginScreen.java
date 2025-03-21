import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginScreen() {
        setTitle("Online Banking - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(150, 50, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 100, 165, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (UserAuthentication.authenticateUser(username, password)) {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Login Successful!");
                    new DashboardScreen(username); // Open the dashboard
                    dispose(); // Close the login screen
                } else {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Invalid username or password.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}