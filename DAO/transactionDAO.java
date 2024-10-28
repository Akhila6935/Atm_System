package AtmSystem.DAO;

import AtmSystem.Entity.transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class transactionDAO {

    private SessionFactory sessionFactory;

    public transactionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("deprecation")
	public void saveOrUpdate(transaction transactionEntity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(transactionEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; // Re-throw the exception after rollback
        }
    }

    public transaction getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(transaction.class, id);
        }
    }

    public List<transaction> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<transaction> query = session.createQuery("from transaction", transaction.class);
            return query.list();
        }
    }

    @SuppressWarnings("deprecation")
	public void deleteById(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            transaction transactionEntity = session.get(transaction.class, id);
            if (transactionEntity != null) {
                session.delete(transactionEntity);
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
    
	