package AtmSystem.services;

import AtmSystem.DAO.BankDAO;
import AtmSystem.Entity.Bank;

import java.util.List;

public class BankService {
    private BankDAO bankDAO;

    public BankService(BankDAO bankDAO) {
        this.bankDAO = bankDAO;
    }

    public void saveOrUpdateBank(Bank bank) {
        bankDAO.saveOrUpdate(bank);
    }

    public Bank getBankById(int id) {
        return bankDAO.getById(id);
    }

    public List<Bank> getAllBanks() {
        return bankDAO.getAll();
    }

    public void deleteBankById(int id) {
        bankDAO.deleteById(id);
    }
}
