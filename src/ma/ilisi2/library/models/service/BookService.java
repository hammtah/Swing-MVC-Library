package ma.ilisi2.library.models.service;

import ma.ilisi2.library.exception.BookServiceException;
import ma.ilisi2.library.exception.DaoException;
import ma.ilisi2.library.models.bo.Book;
import ma.ilisi2.library.models.dao.BookDao.IBookDao;
import ma.ilisi2.library.models.service.IBookService;

import java.util.Collection;

public class BookService implements IBookService {
    IBookDao bookDao;
    public BookService(IBookDao ibookDao){
        bookDao = ibookDao;
    }
    public void save(Book b) throws BookServiceException {
        try{
            bookDao.save(b);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BookServiceException("Cannot save book");
        }
    }
    public Collection<Book> getAll() throws BookServiceException{
        try{
            return bookDao.getAll();
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BookServiceException("Cannot retrieve books");
        }
    }
    public Book get(int id) throws BookServiceException{
        try{
            return bookDao.get(id);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BookServiceException("Cannot retrieve book");
        }
    }
    public void update(Book b) throws BookServiceException{
        try{
            bookDao.update(b);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BookServiceException("Cannot update book");
        }
    }
    public void update(int id, Book b) throws BookServiceException{
        try{
//            bookDao.update(id, b);
            b.setId(id);
            bookDao.update(b);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BookServiceException("Cannot update book");
        }
    }
    public void delete(int id) throws BookServiceException{
        try{
//            bookDao.delete(id);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BookServiceException("Cannot delete book");
        }
    }
//    public boolean isDelayed(Borrow b) {
//        if (b == null || b.getBorrowDate() == null) return false;
//        java.util.Calendar cal = java.util.Calendar.getInstance();
//        cal.setTime(b.getBorrowDate());
//        cal.add(java.util.Calendar.DAY_OF_YEAR, com.ilisi.jee.tp1.service.borrow.IBorrowService.maxBorrowDays);
//        java.util.Date due = cal.getTime();
//        if(b.getReturnDate() != null){
//            return b.getReturnDate().after(due);
//        } else {
//            java.util.Date now = new java.util.Date();
//            return now.after(due);
//        }
//    }
}
