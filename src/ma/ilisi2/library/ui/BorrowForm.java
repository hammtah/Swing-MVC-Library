package ma.ilisi2.library.ui;

import ma.ilisi2.library.controller.BorrowController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowForm extends JFrame {

    private final BorrowController borrowController;

    private JTextField bookIdField;
    private JTextField userIdField;
    private JTextField borrowIdField;

    public BorrowForm() {
        this.borrowController = new BorrowController();
        initUI();
    }

    private void initUI() {
        setTitle("Borrow / Return Book");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdField = new JTextField(10);
        JLabel userIdLabel = new JLabel("User ID:");
        userIdField = new JTextField(10);
        JButton borrowButton = new JButton("Borrow");

        JLabel borrowIdLabel = new JLabel("Borrow ID:");
        borrowIdField = new JTextField(10);
        JButton returnButton = new JButton("Return");

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(bookIdLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(bookIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(userIdLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(userIdField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(borrowButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(borrowIdLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(borrowIdField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(returnButton, gbc);

        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBorrow();
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onReturn();
            }
        });

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onBorrow() {
        try {
            int bookId = Integer.parseInt(bookIdField.getText().trim());
            int userId = Integer.parseInt(userIdField.getText().trim());
            var borrow = borrowController.borrowBook(bookId, userId);
            if (borrow != null) {
                JOptionPane.showMessageDialog(this,
                        "Borrow created with ID: " + borrow.getId(),
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Could not create borrow.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Book ID and User ID must be integers.",
                    "Validation error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void onReturn() {
        try {
            int borrowId = Integer.parseInt(borrowIdField.getText().trim());
            var borrow = borrowController.returnBorrow(borrowId);
            if (borrow != null) {
                JOptionPane.showMessageDialog(this,
                        "Borrow " + borrow.getId() + " marked as returned.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Could not return borrow.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Borrow ID must be an integer.",
                    "Validation error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}

