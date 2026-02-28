package ma.ilisi2.library.models.service;
import ma.ilisi2.library.exception.BookServiceException;
import ma.ilisi2.library.models.bo.Book;

import java.util.Collection;

public interface IBookService {
    public void save(Book b) throws BookServiceException;
    public Collection<Book> getAll() throws BookServiceException;
    public Book get(int id) throws BookServiceException;
    public void update(Book b) throws BookServiceException;
    public void update(int id, Book b) throws BookServiceException;
    public void delete(int id) throws BookServiceException;
//    public boolean isDelayed(Borrow b);
}
