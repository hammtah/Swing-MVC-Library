package ma.ilisi2.library.controller;

import ma.ilisi2.library.exception.BorrowServiceException;
import ma.ilisi2.library.models.bo.Borrow;
import ma.ilisi2.library.models.dao.BorrowDao.BorrowDaoHibernate;
import ma.ilisi2.library.models.dao.BorrowDao.IBorrowDao;
import ma.ilisi2.library.models.service.BorrowService;
import ma.ilisi2.library.models.service.IBorrowService;

import java.util.Collection;

public class BorrowController {

    private final IBorrowService borrowService;

    public BorrowController() {
        IBorrowDao borrowDao = new BorrowDaoHibernate();
        this.borrowService = new BorrowService(borrowDao);
    }

    public Borrow borrowBook(int bookId, int userId) {
        try {
            return borrowService.borrowBook(bookId, userId);
        } catch (BorrowServiceException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Borrow returnBorrow(int borrowId) {
        try {
            return borrowService.returnBorrow(borrowId);
        } catch (BorrowServiceException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Collection<Borrow> getAllBorrows() {
        try {
            return borrowService.getAll();
        } catch (BorrowServiceException e) {
            System.out.println(e.getMessage());
            return java.util.Collections.emptyList();
        }
    }
}

