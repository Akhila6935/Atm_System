package AtmSystem.services;

import AtmSystem.DAO.transactionDAO;
import AtmSystem.Entity.transaction;
import java.util.List;

public class TransactionService {

    private transactionDAO transactionDAO;

    // Constructor to inject transactionDAO dependency
    public TransactionService(transactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }
    public void saveOrUpdateTransaction(transaction transactionEntity) {
        transactionDAO.saveOrUpdate(transactionEntity);
    }

    public transaction getTransactionById(int id) {
        return transactionDAO.getById(id);
    }

    public List<transaction> getAllTransactions() {
        return transactionDAO.getAll();
    }

    public void deleteTransactionById(int id) {
        transactionDAO.deleteById(id);
    }
}