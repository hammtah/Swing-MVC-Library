package ma.ilisi2.library.models.dao.BorrowDao;

import ma.ilisi2.library.exception.DaoException;
import ma.ilisi2.library.models.bo.Borrow;
import ma.ilisi2.library.utility.HibernateUtil;
import org.hibernate.HibernateException;

import java.util.Collection;

public class BorrowDaoHibernate implements IBorrowDao {

    @Override
    public void save(Borrow b) throws DaoException {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(b);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("Erreur lors de la sauvegarde de l'emprunt");
        }
    }

    @Override
    public Collection<Borrow> getAll() throws DaoException {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Borrow";
            return session.createQuery(hql, Borrow.class).list();
        } catch (Exception e) {
            throw new DaoException("Erreur lors retrieving des emprunts");
        }
    }

    @Override
    public Borrow get(int id) throws DaoException {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Borrow.class, id);
        } catch (Exception e) {
            throw new DaoException("Erreur lors du retrieving de l'emprunt");
        }
    }

    @Override
    public void update(Borrow b) throws DaoException {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(b);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException("Erreur lors de mise à jour de l'emprunt");
        }
    }
}

