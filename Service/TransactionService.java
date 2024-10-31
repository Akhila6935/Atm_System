package AtmSystem.Service;

import AtmSystem.DAO.TransactionDAO;
import AtmSystem.Entity.Transaction;
import org.hibernate.SessionFactory;

import java.util.List;

public class TransactionService {
    private TransactionDAO transactionDAO;

    public TransactionService(SessionFactory sessionFactory) {
        this.transactionDAO = new TransactionDAO(sessionFactory);
    }

    // Create Transaction
    public void createTransaction(Transaction transaction) {
        if (transaction != null) {
            transactionDAO.createTransaction(transaction);
            System.out.println("Transaction created successfully.");
        } else {
            System.out.println("Transaction cannot be null.");
        }
    }

    // Read Transaction by ID
    public Transaction getTransactionById(int transactionId) {
        Transaction transaction = transactionDAO.getTransactionById(transactionId);
        if (transaction != null) {
            System.out.println("Transaction found: " + transaction.getAmount());
        } else {
            System.out.println("Transaction not found with ID: " + transactionId);
        }
        return transaction;
    }

    // Update Transaction
    public void updateTransaction(Transaction transaction) {
        if (transaction != null) {
            transactionDAO.updateTransaction(transaction);
            System.out.println("Transaction updated successfully.");
        } else {
            System.out.println("Transaction cannot be null.");
        }
    }

    // Delete Transaction by ID
    public void deleteTransaction(int transactionId) {
        transactionDAO.deleteTransaction(transactionId);
    }

    // Get all Transactions
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = transactionDAO.getAllTransactions();
        if (transactions != null && !transactions.isEmpty()) {
            System.out.println("Retrieved " + transactions.size() + " transactions.");
        } else {
            System.out.println("No transactions found.");
        }
        return transactions;
    }

    // Close resources
    public void close() {
        transactionDAO.close();
    }
}
