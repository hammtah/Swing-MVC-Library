package ma.ilisi2.library.models.dao.BookDao;

import ma.ilisi2.library.exception.DaoException;
import ma.ilisi2.library.models.bo.Book;
import ma.ilisi2.library.utility.HibernateUtil;
import org.hibernate.HibernateException;

import java.sql.SQLException;
import java.util.Collection;

public class BookDaoHibernate implements IBookDao{

    @Override
    public void save(Book b) throws DaoException{
        try {
            var sessionFactory = HibernateUtil.getSessionFactory();
            var session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(b);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw new DaoException("Erreur lors de la sauvegarde du livre");
        }
    }

    @Override
    public Collection<Book> getAll() throws DaoException {
        try {
            String hql = "FROM Book";
            var sessionFactory = HibernateUtil.getSessionFactory();
            var session = sessionFactory.openSession();
            var books = session.createQuery(hql, Book.class).list();
            session.close();
        return books;
        } catch (Exception e) {
            throw new DaoException("Erreur lors retrieving des livres");
        }
    }

    @Override
    public Book get(int id) throws DaoException{
        try {
            var sessionFactory = HibernateUtil.getSessionFactory();
            var session = sessionFactory.openSession();
            var book = session.get(Book.class, id);
            session.close();
            return book;
        } catch (Exception e) {
            throw new DaoException("Erreur lors du retrieving du livre");
        }
    }

    public void update(Book b) throws DaoException{
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(b);
//            session.update(b);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            throw new DaoException("Erreur lors de mise à jour du livre");
        }
    }

//    @Override
//    public void update(int id, Book b) throws DaoException {
//        try (var session = HibernateUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
//            b.setId(id);
//            session.merge(b);
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//            throw new DaoException("Erreur lors de mise à jour du livre");
//        }
//    }
}
