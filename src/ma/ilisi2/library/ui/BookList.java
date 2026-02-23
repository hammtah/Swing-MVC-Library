package ma.ilisi2.library.ui;

import ma.ilisi2.library.controller.BookController;
import ma.ilisi2.library.models.bo.Book;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class BookList extends JFrame{
    private JTextField tprice;
    private JTextField tauthor;
    private JTextField tyear;
    private JTextField tisbn;
    private JTextField tdescription;
    private JLabel ttitle;
    private JPanel bookpanel;
    private JPanel booklistpanel;
    private JTextField tid;

    public BookList() {
        setTitle("1990's Library");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        booklistpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        setContentPane(booklistpanel);

        Collection<Book> books = getBooks();
        for(Book b: books){
            System.out.println(b);
            booklistpanel.add(new BookPanel(b),BorderLayout.CENTER);
        }
        pack();
        // Set the frame location to the center of the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private Collection<Book> getBooks(){
        BookController bookController = new BookController();
        return bookController.getAllBooks();
    }
}
