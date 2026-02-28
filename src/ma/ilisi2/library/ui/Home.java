package ma.ilisi2.library.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

    private JButton addABookButton;
    private JButton exploreBooksButton;
    private JButton updateBookButton;
    private JButton borrowBookButton;
    private JButton listBorrowsButton;
    private JButton addClientButton;
    private JPanel panel1;
    public Home() {
        setTitle("1990's Library");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContent());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel buildContent() {
        JPanel root = new JPanel(new BorderLayout(24, 24));
        root.setBorder(new EmptyBorder(24, 24, 24, 24));

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);

        JLabel title = new JLabel("1990's Library");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 32f));
        JLabel subtitle = new JLabel("Manage books, clients and borrows from one place.");
        subtitle.setFont(subtitle.getFont().deriveFont(Font.PLAIN, 18f));
        subtitle.setForeground(new Color(90, 90, 90));

        headerPanel.add(title, BorderLayout.NORTH);
        headerPanel.add(subtitle, BorderLayout.SOUTH);
        root.add(headerPanel, BorderLayout.NORTH);

        // Main actions grid
        JPanel grid = new JPanel(new GridLayout(2, 3, 18, 18));
        grid.setOpaque(false);

        addABookButton = createPrimaryButton("Add Book");
        exploreBooksButton = createPrimaryButton("Explore Books");
        updateBookButton = createPrimaryButton("Update Book");
        borrowBookButton = createPrimaryButton("Borrow / Return");
        listBorrowsButton = createPrimaryButton("Borrow History");
        addClientButton = createPrimaryButton("Add Client");

        grid.add(addABookButton);
        grid.add(exploreBooksButton);
        grid.add(updateBookButton);
        grid.add(borrowBookButton);
        grid.add(listBorrowsButton);
        grid.add(addClientButton);

        root.add(grid, BorderLayout.CENTER);

        wireActions();

        return root;
    }

    private JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(button.getFont().deriveFont(Font.BOLD, 18f));
        button.setPreferredSize(new Dimension(240, 90));
        return button;
    }

    private void wireActions() {
        addABookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookCreate(null);
            }
        });

        exploreBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookList();
            }
        });

        updateBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookUpdate();
            }
        });

        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BorrowForm();
            }
        });

        listBorrowsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BorrowList();
            }
        });

        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserCreate();
            }
        });
    }
}
