package AtmSystem.Service;

import AtmSystem.DAO.BankDAO;
import AtmSystem.Entity.Bank;

import org.hibernate.SessionFactory;

import java.util.List;

public class BankService {
    private BankDAO bankDAO;

    public BankService(SessionFactory sessionFactory) {
        this.bankDAO = new BankDAO(sessionFactory);
    }

    // Create a new bank
    public void createBank(Bank bank) {
        bankDAO.createBank(bank);
    }

    // Get bank by ID
    public Bank getBankById(int bankId) {
        return bankDAO.getBankById(bankId);
    }

    // Update bank details
    public void updateBank(Bank bank) {
        bankDAO.updateBank(bank);
    }

    // Delete bank by ID
    public void deleteBank(int bankId) {
        bankDAO.deleteBank(bankId);
    }

    // Get all banks
    public List<Bank> getAllBanks() {
        return bankDAO.getAllBanks();
    }

    // Close resources
    public void close() {
        bankDAO.close();
    }
}
