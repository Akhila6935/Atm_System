package AtmSystem.DAO;

import AtmSystem.Entity.customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class customerDAO {

    private SessionFactory sessionFactory;

    public customerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	// Create or Update customer
    @SuppressWarnings("deprecation")
	public void saveOrUpdate(customer customerEntity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(customerEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
            	transaction.rollback();
            }
            throw e;
        }
    }

    // Get customer by ID
    public customer getById(int Id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(customer.class, Id);
        }
    }

    // Get all customers
    public List<customer> getAllCustomers() {
        try (Session session = sessionFactory.openSession()) {
            Query<customer> query = session.createQuery("FROM customer", customer.class);
            return query.list();
        }
    }

    // Delete customer
    @SuppressWarnings("deprecation")
	public void deleteById(int custId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            customer customerEntity = session.get(customer.class,custId);
            if (customerEntity != null) {
                session.delete(customerEntity);
                transaction.commit();
            }
           
        } catch (Exception e) {
            if (transaction != null) {
            	transaction.rollback();
            }
            throw e;
        }
    }

	public List<customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
