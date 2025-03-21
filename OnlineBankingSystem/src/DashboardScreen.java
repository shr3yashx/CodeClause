import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardScreen extends JFrame {
    public DashboardScreen(String username) {
        setTitle("Online Banking - Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel, username);

        setVisible(true);
    }

    private void placeComponents(JPanel panel, String username) {
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        welcomeLabel.setBounds(50, 50, 300, 25);
        panel.add(welcomeLabel);

        JButton viewBalanceButton = new JButton("View Balance");
        viewBalanceButton.setBounds(50, 100, 150, 25);
        panel.add(viewBalanceButton);

        JButton transferFundsButton = new JButton("Transfer Funds");
        transferFundsButton.setBounds(50, 150, 150, 25);
        panel.add(transferFundsButton);

        JButton transactionHistoryButton = new JButton("Transaction History");
        transactionHistoryButton.setBounds(50, 200, 150, 25);
        panel.add(transactionHistoryButton);

        // Add action listeners for buttons
        viewBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement view balance functionality
            }
        });

        transferFundsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FundTransfer(username); // Open fund transfer screen
            }
        });

        transactionHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransactionHistory(username); // Open transaction history screen
            }
        });
    }
}