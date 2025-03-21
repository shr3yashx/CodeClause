import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionHistory extends JFrame {
    public TransactionHistory(String username) {
        setTitle("Online Banking - Transaction History");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        displayTransactions(panel, username);

        setVisible(true);
    }

    private void displayTransactions(JPanel panel, String username) {
        String query = "SELECT * FROM transactions WHERE from_account = ? OR to_account = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, username);
            ResultSet rs = pstmt.executeQuery();

            StringBuilder transactions = new StringBuilder();
            while (rs.next()) {
                transactions.append("From: ").append(rs.getString("from_account"))
                        .append(", To: ").append(rs.getString("to_account"))
                        .append(", Amount: ").append(rs.getDouble("amount"))
                        .append(", Date: ").append(rs.getTimestamp("transaction_date"))
                        .append("\n");
            }

            JTextArea textArea = new JTextArea(transactions.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            panel.add(scrollPane);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}