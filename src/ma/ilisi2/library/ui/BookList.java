package ma.ilisi2.library.ui;

import ma.ilisi2.library.models.bo.Book;
import ma.ilisi2.library.models.dao.BookDao.BookDao;
import ma.ilisi2.library.models.dao.BookDao.IBookDao;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Collection;

public class BookList extends JFrame{
    private JTextField tprice;
    private JTextField tauthor;
    private JTextField tyear;
    private JTextField tisbn;
    private JTextField tdescription;
    private JLabel ttitle;
    private JPanel bookpanel;
    private JScrollPane booklistpanel;

    public BookList() {
        setTitle("1990's Library");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        booklistpanel = new JScrollPane();
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
        IBookDao bookDao = new BookDao();
        try {
            return bookDao.getAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
