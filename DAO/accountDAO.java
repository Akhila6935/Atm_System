package AtmSystem.DAO;

import AtmSystem.Entity.account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class accountDAO {

	private SessionFactory sessionFactory;

    public  accountDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("deprecation")
	public void saveOrUpdate(account acc) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(acc);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; // Re-throw the exception after rollback
        }
    }

    public account getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(account.class, id);
        }
    }

    public List<account> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<account> query = session.createQuery("from account", account.class);
            return query.list();
        }
    }

    @SuppressWarnings("deprecation")
	public void deleteById(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            account acc = session.get(account.class, id);
            if (acc != null) {
                session.delete(acc);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; // Re-throw the exception after rollback
        }
    }
}