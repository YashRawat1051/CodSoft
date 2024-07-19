import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM extends JFrame {
    private JTextField amountField;
    private JLabel balanceLabel, messageLabel;
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Amount:"));
        amountField = new JTextField();
        add(amountField);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new WithdrawButtonListener());
        add(withdrawButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new DepositButtonListener());
        add(depositButton);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(new CheckBalanceButtonListener());
        add(checkBalanceButton);

        balanceLabel = new JLabel("Balance: ");
        add(balanceLabel);

        messageLabel = new JLabel("");
        add(messageLabel);

        setVisible(true);
    }

    private class WithdrawButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (account.withdraw(amount)) {
                    messageLabel.setText("Withdraw successful.");
                } else {
                    messageLabel.setText("Insufficient funds.");
                }
                updateBalance();
            } catch (NumberFormatException ex) {
                messageLabel.setText("Please enter a valid amount.");
            }
        }
    }

    private class DepositButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                messageLabel.setText("Deposit successful.");
                updateBalance();
            } catch (NumberFormatException ex) {
                messageLabel.setText("Please enter a valid amount.");
            }
        }
    }

    private class CheckBalanceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateBalance();
        }
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: " + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance of 1000
        new ATM(account);
    }
}
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
