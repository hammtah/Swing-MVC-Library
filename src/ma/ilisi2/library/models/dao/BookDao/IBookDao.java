package ma.ilisi2.library.models.dao.BookDao;

import ma.ilisi2.library.exception.DaoException;
import ma.ilisi2.library.models.bo.Book;

import java.sql.SQLException;
import java.util.Collection;

public interface IBookDao {
    public void save(Book b) throws DaoException;

    public Collection<Book> getAll() throws DaoException;

    public Book get(int id) throws DaoException;

//    public void update(int id, Book b) throws DaoException;
    public void update(Book b) throws DaoException;

}
