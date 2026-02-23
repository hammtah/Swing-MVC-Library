package ma.ilisi2.library.models.service;

import ma.ilisi2.library.exception.BorrowServiceException;
import ma.ilisi2.library.models.bo.Borrow;

import java.util.Collection;

public interface IBorrowService {
    void save(Borrow b) throws BorrowServiceException;

    Collection<Borrow> getAll() throws BorrowServiceException;

    Borrow get(int id) throws BorrowServiceException;

    void update(Borrow b) throws BorrowServiceException;

    void update(int id, Borrow b) throws BorrowServiceException;

    void delete(int id) throws BorrowServiceException;
}

