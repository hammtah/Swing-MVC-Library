package ma.ilisi2.library.models.dao.BookDao;

import ma.ilisi2.library.models.bo.Book;
import ma.ilisi2.library.utility.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class BookDao implements IBookDao{

    @Override
    public void save(Book b) throws SQLException {
        var conn = Connection.getConnection();
        var pst = conn.prepareStatement("INSERT INTO books (img, nb, year, isbn, genre, price, description, title, author) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");

        pst.setString(1, b.getImg());
        pst.setInt(2, b.getNb());
        pst.setInt(3, b.getYear());
        pst.setString(4, b.getIsbn());
        pst.setString(5, b.getGenre());
        pst.setFloat(6, b.getPrice());
        pst.setString(7, b.getDescription());
        pst.setString(8, b.getTitle());
        pst.setString(9, b.getAuthor());

        pst.executeUpdate();
        conn.close();
    }

    @Override
    public Collection<Book> getAll() throws SQLException {
        ArrayList<Book> books = new ArrayList<>();
        var conn = Connection.getConnection();
        var st = conn.createStatement();
        var res = st.executeQuery("SELECT * FROM BOOKS");
        while(res.next()){
            var book = new Book(
                    res.getInt("year"),
                    res.getString("isbn"),
                    res.getString("genre"),
                    res.getFloat("price"),
                    res.getString("description"),
                    res.getString("title"),
                    res.getString("author"),
                    res.getString("img")
            );
            books.add(book);
        }
        conn.close();

        return books;
    }
    public Book get(int id) throws SQLException{
        String getString = "SELECT * FROM book WHERE id = ?";
        var conn = Connection.getConnection();
        var pst = conn.prepareStatement(getString);
        pst.setInt(1, id);
        var res = pst.executeQuery();
        res.next();
        return new Book(
                res.getInt("year"),
                res.getString("isbn"),
                res.getString("genre"),
                res.getFloat("price"),
                res.getString("description"),
                res.getString("title"),
                res.getString("author"),
                res.getString("img")
        );

    }

    public void update(String id, Book b) throws SQLException {
        String updateString = "UPDATE BOOKS SET img=?, nb=?, year=?, genre=?, price=?, description=?, title=?, author=? WHERE isbn=?";
        var conn = Connection.getConnection();
        var pst = conn.prepareStatement(updateString);
        pst.setString(1, b.getImg());
        pst.setInt(2, b.getNb());
        pst.setInt(3, b.getYear());
        pst.setString(4, b.getGenre());
        pst.setFloat(5, b.getPrice());
        pst.setString(6, b.getDescription());
        pst.setString(7, b.getTitle());
        pst.setString(8, b.getAuthor());
        pst.setString(9, b.getIsbn());
        pst.executeUpdate();
        conn.close();
    }

}
