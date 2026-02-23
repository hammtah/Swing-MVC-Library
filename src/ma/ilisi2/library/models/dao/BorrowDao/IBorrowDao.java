package ma.ilisi2.library.models.dao.BorrowDao;

import ma.ilisi2.library.exception.DaoException;
import ma.ilisi2.library.models.bo.Borrow;

import java.util.Collection;

public interface IBorrowDao {
    void save(Borrow b) throws DaoException;

    Collection<Borrow> getAll() throws DaoException;

    Borrow get(int id) throws DaoException;

    void update(Borrow b) throws DaoException;
}

