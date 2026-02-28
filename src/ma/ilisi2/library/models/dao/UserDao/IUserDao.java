package ma.ilisi2.library.models.dao.UserDao;

import ma.ilisi2.library.exception.DaoException;
import ma.ilisi2.library.models.bo.User;

import java.util.Collection;

public interface IUserDao {
    void save(User u) throws DaoException;

    Collection<User> getAll() throws DaoException;

    User get(int id) throws DaoException;

    void update(User u) throws DaoException;
}

