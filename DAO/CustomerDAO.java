package AtmSystem.DAO;

import AtmSystem.Entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDAO {
    private SessionFactory sessionFactory;

    public CustomerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Create Customer
    @SuppressWarnings("deprecation")
	public void createCustomer(Customer customer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error creating customer: " + e.getMessage());
        }
    }

    // Read Customer by ID
    public Customer getCustomerById(int customerId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Customer.class, customerId);
        } catch (Exception e) {
            System.out.println("Error retrieving customer: " + e.getMessage());
            return null;
        }
    }

    // Update Customer
    @SuppressWarnings("deprecation")
	public void updateCustomer(Customer customer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error updating customer: " + e.getMessage());
        }
    }

    // Delete Customer by ID
    @SuppressWarnings("deprecation")
	public void deleteCustomer(int customerId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            if (customer != null) {
                session.delete(customer);
                System.out.println("Customer deleted successfully.");
            } else {
                System.out.println("Customer not found with ID: " + customerId);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error deleting customer: " + e.getMessage());
        }
    }

    // Get all Customers
    public List<Customer> getAllCustomers() {
        try (Session session = sessionFactory.openSession()) {
            Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
            return query.list();
        } catch (Exception e) {
            System.out.println("Error retrieving customers: " + e.getMessage());
            return null;
        }
    }

    // Close SessionFactory resources when done
    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
