package ma.ilisi2.library.controller;

import ma.ilisi2.library.exception.UserServiceException;
import ma.ilisi2.library.models.bo.User;
import ma.ilisi2.library.models.dao.UserDao.IUserDao;
import ma.ilisi2.library.models.dao.UserDao.UserDaoHibernate;
import ma.ilisi2.library.models.service.IUserService;
import ma.ilisi2.library.models.service.UserService;

public class UserController {

    private final IUserService userService;

    public UserController() {
        IUserDao userDao = new UserDaoHibernate();
        this.userService = new UserService(userDao);
    }

    public void addUser(String name, String cin, String phone) {
        try {
            java.time.LocalDateTime now = java.time.LocalDateTime.now();
            User user = new User(name, cin, now, phone);
            userService.save(user);
        } catch (UserServiceException e) {
            System.out.println(e.getMessage());
        }
    }
}

