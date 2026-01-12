package ma.ilisi2.library.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame{
    private JButton addABookButton;
    private JPanel panel1;
    private JButton exploreBooksButton;
    private JButton updateBookButton;

    public Home() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
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
        setVisible(true);
    }
}
