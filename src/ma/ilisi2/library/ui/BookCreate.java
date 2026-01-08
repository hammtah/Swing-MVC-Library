package ma.ilisi2.library.ui;

import ma.ilisi2.library.controller.BookController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class BookCreate extends JFrame{
    private JPanel contentPane;
    private JTextField ttitle;
    private JTextField tauthor;
    private JTextField tyear;
    private JTextField tisbn;
    private JTextField tprice;
    private JTextArea tdescription;
    private JButton createButton;
    private JButton clearButton;

    public BookCreate(){
        setTitle("1990's Library");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        // Set the frame location to the center of the screen
        setLocationRelativeTo(null);
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
}
