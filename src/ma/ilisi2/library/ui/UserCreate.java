package ma.ilisi2.library.ui;

import ma.ilisi2.library.controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserCreate extends JFrame {

    private JTextField nameField;
    private JTextField cinField;
    private JTextField phoneField;
    private JButton createButton;
    private JButton clearButton;

    public UserCreate() {
        setTitle("Create Client");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(buildContent());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel buildContent() {
        JPanel root = new JPanel(new BorderLayout(16, 16));
        root.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel header = new JLabel("New Client");
        header.setFont(header.getFont().deriveFont(Font.BOLD, 20f));
        root.add(header, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel nameLabel = new JLabel("Name *");
        nameField = new JTextField(20);

        JLabel cinLabel = new JLabel("CIN *");
        cinField = new JTextField(20);

        JLabel phoneLabel = new JLabel("Phone");
        phoneField = new JTextField(20);

        // Name row
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // CIN row
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(cinLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(cinField, gbc);

        // Phone row
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(phoneField, gbc);

        root.add(formPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        createButton = new JButton("Create");
        clearButton = new JButton("Clear");
        buttonsPanel.add(clearButton);
        buttonsPanel.add(createButton);
        root.add(buttonsPanel, BorderLayout.SOUTH);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createUser();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        return root;
    }

    private void createUser() {
        String name = nameField.getText().trim();
        String cin = cinField.getText().trim();
        String phone = phoneField.getText().trim();

        if (name.isEmpty() || cin.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Name and CIN are required.",
                    "Validation error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        UserController controller = new UserController();
        controller.addUser(name, cin, phone);
        JOptionPane.showMessageDialog(this,
                "Client created successfully.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearForm() {
        nameField.setText("");
        cinField.setText("");
        phoneField.setText("");
    }
}

