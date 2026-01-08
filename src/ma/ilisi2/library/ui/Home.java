package ma.ilisi2.library.ui;

import ma.ilisi2.library.models.dao.BookDao.BookDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame{
    private JButton addABookButton;
    private JPanel panel1;
    private JButton exploreBooksButton;

    public Home() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        addABookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookCreate();
            }
        });
        exploreBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookList();
            }
        });
        setVisible(true);
    }
}
