package ma.ilisi2.library.models.service;

import ma.ilisi2.library.exception.BorrowServiceException;
import ma.ilisi2.library.exception.DaoException;
import ma.ilisi2.library.models.bo.Borrow;
import ma.ilisi2.library.models.dao.BorrowDao.IBorrowDao;

import java.util.Collection;

public class BorrowService implements IBorrowService {
    private final IBorrowDao borrowDao;

    public BorrowService(IBorrowDao borrowDao) {
        this.borrowDao = borrowDao;
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
}

