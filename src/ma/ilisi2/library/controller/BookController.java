package ma.ilisi2.library.controller;

import ma.ilisi2.library.exception.BookServiceException;
import ma.ilisi2.library.models.dao.BookDao.BookDaoHibernate;
import ma.ilisi2.library.models.bo.Book;
import ma.ilisi2.library.models.dao.BookDao.BookDao;
import ma.ilisi2.library.models.dao.BookDao.IBookDao;
import ma.ilisi2.library.models.service.BookService;
import ma.ilisi2.library.models.service.IBookService;

import java.sql.SQLException;
import java.util.Collection;

public class BookController {
    IBookDao bookDao;
    IBookService bookService;
    public BookController(){
//        bookDao = new BookDao();
        bookDao = new BookDaoHibernate();
        bookService = new BookService(bookDao);
    }
    public void addBook(int year, String isbn, String genre, float price, String description, String title, String author, String img) {
        try {
            Book b = new Book(year, isbn, genre, price, description, title, author, img);
            bookService.save(b);
        } catch (BookServiceException e) {
            System.out.println(e.getMessage());
        }
    }

    public Collection<Book> getAllBooks() {
        Collection<Book> books = null;
        try {
            books =  bookService.getAll();
        } catch (BookServiceException e) {
            System.out.println(e.getMessage());

        }
        return books;
    }
    public Book getBook(int id) {
        Book book = null;
        try {
            book =  bookService.get(id);
        } catch (BookServiceException e) {
            System.out.println(e.getMessage());
        }
        return book;
    }
    public void updateBook(int id, int year, String isbn, String genre, float price, String description, String title, String author, String img) {
        try {
            Book b = new Book(id, year, isbn, genre, price, description, title, author, img);
            bookService.update(b);
        } catch (BookServiceException e) {
            System.out.println(e.getMessage());
        }
    }
}
