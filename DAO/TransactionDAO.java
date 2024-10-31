package AtmSystem.DAO;

import AtmSystem.Entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionDAO {
    private SessionFactory sessionFactory;

    public TransactionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Create Transaction
    @SuppressWarnings("deprecation")
	public void createTransaction(Transaction transaction) {
        org.hibernate.Transaction hibernateTransaction = null;
        try (Session session = sessionFactory.openSession()) {
            hibernateTransaction = session.beginTransaction();
            session.save(transaction);
            hibernateTransaction.commit();
        } catch (Exception e) {
            if (hibernateTransaction != null) hibernateTransaction.rollback();
            System.out.println("Error creating transaction: " + e.getMessage());
        }
    }

    // Read Transaction by ID
    public Transaction getTransactionById(int transactionId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Transaction.class, transactionId);
        } catch (Exception e) {
            System.out.println("Error retrieving transaction: " + e.getMessage());
            return null;
        }
    }

    // Update Transaction
    @SuppressWarnings("deprecation")
	public void updateTransaction(Transaction transaction) {
        org.hibernate.Transaction hibernateTransaction = null;
        try (Session session = sessionFactory.openSession()) {
            hibernateTransaction = session.beginTransaction();
            session.update(transaction);
            hibernateTransaction.commit();
        } catch (Exception e) {
            if (hibernateTransaction != null) hibernateTransaction.rollback();
            System.out.println("Error updating transaction: " + e.getMessage());
        }
    }

    // Delete Transaction by ID
    @SuppressWarnings("deprecation")
	public void deleteTransaction(int transactionId) {
        org.hibernate.Transaction hibernateTransaction = null;
        try (Session session = sessionFactory.openSession()) {
            hibernateTransaction = session.beginTransaction();
            Transaction transaction = session.get(Transaction.class, transactionId);
            if (transaction != null) {
                session.delete(transaction);
                System.out.println("Transaction deleted successfully.");
            } else {
                System.out.println("Transaction not found with ID: " + transactionId);
            }
            hibernateTransaction.commit();
        } catch (Exception e) {
            if (hibernateTransaction != null) hibernateTransaction.rollback();
            System.out.println("Error deleting transaction: " + e.getMessage());
        }
    }

    // Get all Transactions
    public List<Transaction> getAllTransactions() {
        try (Session session = sessionFactory.openSession()) {
            Query<Transaction> query = session.createQuery("FROM Transaction", Transaction.class);
            return query.list();
        } catch (Exception e) {
            System.out.println("Error retrieving transactions: " + e.getMessage());
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
