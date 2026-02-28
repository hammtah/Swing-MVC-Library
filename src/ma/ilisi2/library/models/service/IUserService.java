package ma.ilisi2.library.models.service;

import ma.ilisi2.library.exception.UserServiceException;
import ma.ilisi2.library.models.bo.User;

import java.util.Collection;

public interface IUserService {
    void save(User u) throws UserServiceException;

    Collection<User> getAll() throws UserServiceException;

    User get(int id) throws UserServiceException;

    void update(User u) throws UserServiceException;

    void update(int id, User u) throws UserServiceException;

    void delete(int id) throws UserServiceException;
}

