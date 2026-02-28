package ma.ilisi2.library.models.service;

import ma.ilisi2.library.exception.DaoException;
import ma.ilisi2.library.exception.UserServiceException;
import ma.ilisi2.library.models.bo.User;
import ma.ilisi2.library.models.dao.UserDao.IUserDao;

import java.util.Collection;

public class UserService implements IUserService {
    private final IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User u) throws UserServiceException {
        try {
            userDao.save(u);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new UserServiceException("Cannot save user");
        }
    }

    @Override
    public Collection<User> getAll() throws UserServiceException {
        try {
            return userDao.getAll();
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new UserServiceException("Cannot retrieve users");
        }
    }

    @Override
    public User get(int id) throws UserServiceException {
        try {
            return userDao.get(id);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new UserServiceException("Cannot retrieve user");
        }
    }

    @Override
    public void update(User u) throws UserServiceException {
        try {
            userDao.update(u);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new UserServiceException("Cannot update user");
        }
    }

    @Override
    public void update(int id, User u) throws UserServiceException {
        try {
            u.setId(id);
            userDao.update(u);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new UserServiceException("Cannot update user");
        }
    }

    @Override
    public void delete(int id) throws UserServiceException {
        try {
            // Not implemented yet (consistent with BookService)
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new UserServiceException("Cannot delete user");
        }
    }
}

