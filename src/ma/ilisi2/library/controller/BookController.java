package ma.ilisi2.library.controller;

import ma.ilisi2.library.models.dao.BookDao.BookDaoHibernate;
import ma.ilisi2.library.models.bo.Book;
import ma.ilisi2.library.models.dao.BookDao.BookDao;
import ma.ilisi2.library.models.dao.BookDao.IBookDao;

import java.sql.SQLException;
import java.util.Collection;

public class BookController {
    IBookDao bookDao;
    public BookController(){
//        bookDao = new BookDao();
        bookDao = new BookDaoHibernate();
    }
    public void addBook(int year, String isbn, String genre, float price, String description, String title, String author, String img) throws SQLException {
        Book b = new Book(year, isbn, genre, price, description, title, author, img) ;
        new BookDao().save(b);
    }

    public Collection<Book> getAllBooks() throws SQLException {
        return bookDao.getAll();
    }
}
