package ma.ilisi2.library.ui;

import ma.ilisi2.library.controller.BookController;
import ma.ilisi2.library.models.bo.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BookCreate extends JFrame{
    public JPanel contentPane;
    public JTextField ttitle;
    public JTextField tauthor;
    public JTextField tyear;
    public JTextField tisbn;
    public JTextField tprice;
    public JTextArea tdescription;
    public JButton createButton;
    public JButton clearButton;
    public JTextField id;
    public JLabel idLabel;

    public BookCreate(Book b){
        setTitle("1990's Library");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        // Set the frame location to the center of the screen
        setLocationRelativeTo(null);
        if (b != null) {
            fillFields(b);
        }
        // Save button event listener
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createBook();
            }
        });

        // Clear button event listener
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearBook();
            }
        });

        // Set the frame visible
        setVisible(true);
    }
    private void createBook() {
        BookController bookController = new BookController();
        try {
            bookController.addBook(
                    Integer.parseInt(tyear.getText()),
                    tisbn.getText(),
                    "", // genre 
                    Float.parseFloat(tprice.getText()),
                    tdescription.getText(),
                    ttitle.getText(),
                    tauthor.getText(),
                "" // img 
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void clearBook() {
        ttitle.setText("");
        tauthor.setText("");
        tyear.setText("");
        tisbn.setText("");
        tprice.setText("");
        tdescription.setText("");
    }

    public void fillFields(Book b) {
        ttitle.setText(b.getTitle());
        tauthor.setText(b.getAuthor());
        tyear.setText(String.valueOf(b.getYear()));
        tisbn.setText(b.getIsbn());
        tprice.setText(String.valueOf(b.getPrice()));
        tdescription.setText(b.getDescription());
    }
}
