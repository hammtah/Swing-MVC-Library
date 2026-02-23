package ma.ilisi2.library.models.dao.BookDao;

import ma.ilisi2.library.models.bo.Book;

import java.sql.SQLException;
import java.util.Collection;

public interface IBookDao {
    public void save(Book b) throws SQLException;

    public Collection<Book> getAll() throws SQLException;

    public Book get(int id) throws SQLException;

    public void update(int id, Book b) throws SQLException;

}
