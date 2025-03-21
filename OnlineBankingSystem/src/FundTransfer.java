import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FundTransfer extends JFrame {
    private JTextField toAccountField;
    private JTextField amountField;

    public FundTransfer(String username) {
        setTitle("Online Banking - Transfer Funds");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel toAccountLabel = new JLabel("To Account:");
        toAccountLabel.setBounds(50, 50, 80, 25);
        panel.add(toAccountLabel);

        toAccountField = new JTextField(20);
        toAccountField.setBounds(150, 50, 165, 25);
        panel.add(toAccountField);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 100, 80, 25);
        panel.add(amountLabel);

        amountField = new JTextField(20);
        amountField.setBounds(150, 100, 165, 25);
        panel.add(amountField);

        JButton transferButton = new JButton("Transfer");
        transferButton.setBounds(150, 150, 80, 25);
        panel.add(transferButton);

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String toAccount = toAccountField.getText();
                double amount = Double.parseDouble(amountField.getText());

                // Implement fund transfer logic here
                JOptionPane.showMessageDialog(FundTransfer.this, "Transfer Successful!");
            }
        });
    }
}