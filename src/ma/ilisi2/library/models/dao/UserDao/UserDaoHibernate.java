package ma.ilisi2.library.models.dao.UserDao;

import ma.ilisi2.library.exception.DaoException;
import ma.ilisi2.library.models.bo.User;
import ma.ilisi2.library.utility.HibernateUtil;
import org.hibernate.HibernateException;

import java.util.Collection;

public class UserDaoHibernate implements IUserDao {

    @Override
    public void save(User u) throws DaoException {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(u);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("Erreur lors de la sauvegarde de l'utilisateur");
        }
    }

    @Override
    public Collection<User> getAll() throws DaoException {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM User";
            return session.createQuery(hql, User.class).list();
        } catch (Exception e) {
            throw new DaoException("Erreur lors retrieving des utilisateurs");
        }
    }

    @Override
    public User get(int id) throws DaoException {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        } catch (Exception e) {
            throw new DaoException("Erreur lors du retrieving de l'utilisateur");
        }
    }

    @Override
    public void update(User u) throws DaoException {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(u);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException("Erreur lors de mise à jour de l'utilisateur");
        }
    }
}

