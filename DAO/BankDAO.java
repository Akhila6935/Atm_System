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

    // Create Bank
    @SuppressWarnings("deprecation")
	public void createBank(Bank bank) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(bank);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error creating bank: " + e.getMessage());
        }
    }

    // Read Bank by ID
    public Bank getBankById(int bankId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Bank.class, bankId);
        } catch (Exception e) {
            System.out.println("Error retrieving bank: " + e.getMessage());
            return null;
        }
    }

    // Update Bank
    @SuppressWarnings("deprecation")
	public void updateBank(Bank bank) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(bank);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error updating bank: " + e.getMessage());
        }
    }

    // Delete Bank by ID
    @SuppressWarnings("deprecation")
	public void deleteBank(int bankId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Bank bank = session.get(Bank.class, bankId);
            if (bank != null) {
                session.delete(bank);
                System.out.println("Bank deleted successfully.");
            } else {
                System.out.println("Bank not found with ID: " + bankId);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error deleting bank: " + e.getMessage());
        }
    }

    // Get all Banks
    public List<Bank> getAllBanks() {
        try (Session session = sessionFactory.openSession()) {
            Query<Bank> query = session.createQuery("FROM Bank", Bank.class);
            return query.list();
        } catch (Exception e) {
            System.out.println("Error retrieving banks: " + e.getMessage());
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
