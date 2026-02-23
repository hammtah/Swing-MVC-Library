package ma.ilisi2.library.ui;

import ma.ilisi2.library.models.bo.Book;
import ma.ilisi2.library.models.dao.BookDao.BookDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BookUpdate extends JFrame {
    private BookCreate contentPane;
    public BookUpdate(){
        setTitle("Update a Book");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = new BookCreate(null);
        contentPane.id.setVisible(true);
        contentPane.idLabel.setVisible(true);
        contentPane.createButton.setText("Update");
        contentPane.clearButton.setText("Cancel");
        clearListeners();
        setContentPane(contentPane);
        pack();
        // Set the frame location to the center of the screen
        setLocationRelativeTo(null);
        // Save button event listener

        // Set the frame visible
        setVisible(true);
    }
    Book getUiBook(){
        Book b = new Book(
                    Integer.parseInt(contentPane.tyear.getText()),
                    contentPane.tisbn.getText(),
                    "", // genre
                    Float.parseFloat(contentPane.tprice.getText()),
                    contentPane.tdescription.getText(),
                    contentPane.ttitle.getText(),
                    contentPane.tauthor.getText(),
                    "" // img
            );
        return b;
    }
    void close(){
        this.close();
    }
    void clearListeners(){
        ActionListener[] createListeners = contentPane.createButton.getActionListeners();
        for (ActionListener listener : createListeners) {
            contentPane.createButton.removeActionListener(listener);
        }
        ActionListener[] clearListeners = contentPane.clearButton.getActionListeners();
        for (ActionListener listener : clearListeners) {
            contentPane.clearButton.removeActionListener(listener);
        }

        contentPane.createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book b = getUiBook();
                try {
                    int id = Integer.parseInt(contentPane.id.getText());
                    new BookDao().update(id, b);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        // Clear button event listener
        contentPane.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });

    }
}
