package AtmSystem.DAO;

import AtmSystem.Entity.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BankDAO {

    private SessionFactory sessionFactory;

    public BankDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("deprecation")
	public void saveOrUpdate(Bank bank) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(bank);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; // Re-throw the exception after rollback
        }
    }

    public Bank getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Bank.class, id);
        }
    }

    public List<Bank> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Bank> query = session.createQuery("from Bank", Bank.class);
            return query.list();
        }
    }

    @SuppressWarnings("deprecation")
	public void deleteById(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Bank bank = session.get(Bank.class, id);
            if (bank != null) {
                session.delete(bank);
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
