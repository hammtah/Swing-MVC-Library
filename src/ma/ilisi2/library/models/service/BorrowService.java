package ma.ilisi2.library.models.service;

import ma.ilisi2.library.exception.BorrowServiceException;
import ma.ilisi2.library.exception.DaoException;
import ma.ilisi2.library.models.bo.Book;
import ma.ilisi2.library.models.bo.Borrow;
import ma.ilisi2.library.models.bo.User;
//import ma.ilisi2.library.models.dao.BorrowDao.IBorrowDao;
//import ma.ilisi2.library.models.dao.BookDao.BookDaoHibernate;
//import ma.ilisi2.library.models.dao.BookDao.IBookDao;
//import ma.ilisi2.library.models.dao.UserDao.IUserDao;
//import ma.ilisi2.library.models.dao.UserDao.UserDaoHibernate;
import ma.ilisi2.library.models.dao.BookDao.*;
import ma.ilisi2.library.models.dao.BorrowDao.*;
import ma.ilisi2.library.models.dao.UserDao.*;
import java.time.LocalDateTime;
import java.util.Collection;

public class BorrowService implements IBorrowService {
    private final IBorrowDao borrowDao;
    private final IBookDao bookDao;
    private final IUserDao userDao;

    public BorrowService(IBorrowDao borrowDao) {
        this.borrowDao = borrowDao;
        // keep things simple for now by instantiating DAOs here;
        // if needed later, this can be refactored to dependency injection.
        this.bookDao = new BookDaoHibernate();
        this.userDao = new UserDaoHibernate();
    }

    @Override
    public void save(Borrow b) throws BorrowServiceException {
        try {
            borrowDao.save(b);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BorrowServiceException("Cannot save borrow");
        }
    }

    @Override
    public Collection<Borrow> getAll() throws BorrowServiceException {
        try {
            return borrowDao.getAll();
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BorrowServiceException("Cannot retrieve borrows");
        }
    }

    @Override
    public Borrow get(int id) throws BorrowServiceException {
        try {
            return borrowDao.get(id);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BorrowServiceException("Cannot retrieve borrow");
        }
    }

    @Override
    public void update(Borrow b) throws BorrowServiceException {
        try {
            borrowDao.update(b);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BorrowServiceException("Cannot update borrow");
        }
    }

    @Override
    public void update(int id, Borrow b) throws BorrowServiceException {
        try {
            b.setId(id);
            borrowDao.update(b);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BorrowServiceException("Cannot update borrow");
        }
    }

    @Override
    public void delete(int id) throws BorrowServiceException {
        try {
            // Not implemented yet (consistent with BookService)
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BorrowServiceException("Cannot delete borrow");
        }
    }

    @Override
    public Borrow borrowBook(int bookId, int userId) throws BorrowServiceException {
        try {
            Book book = bookDao.get(bookId);
            User user = userDao.get(userId);

            if (book == null || user == null) {
                throw new BorrowServiceException("Book or user not found");
            }

            Borrow borrow = new Borrow();
            borrow.setBook(book);
            borrow.setUser(user);
            borrow.setBorrowDate(LocalDateTime.now());
            borrow.setStatus("BORROWED");
            borrow.setReturnDate(null);

            borrowDao.save(borrow);
            return borrow;
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BorrowServiceException("Cannot borrow book");
        }
    }

    @Override
    public Borrow returnBorrow(int borrowId) throws BorrowServiceException {
        try {
            Borrow borrow = borrowDao.get(borrowId);
            if (borrow == null) {
                throw new BorrowServiceException("Borrow not found");
            }
            borrow.setStatus("RETURNED");
            borrow.setReturnDate(LocalDateTime.now());
            borrowDao.update(borrow);
            return borrow;
        } catch (DaoException e) {
            System.out.println(e.getMessage());
            throw new BorrowServiceException("Cannot return borrow");
        }
    }
}

