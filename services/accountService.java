package AtmSystem.services;

import AtmSystem.DAO.accountDAO;
import AtmSystem.Entity.account;
import java.util.List;

public class accountService {

	private accountDAO accountDAO;

    public accountService(accountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void saveOrUpdateaccount(account acc) {
        accountDAO.saveOrUpdate(acc);
    }

    public account getaccountById(int id) {
        return accountDAO.getById(id);
    }

    public List<account> getAllaccounts() {
        return accountDAO.getAll();
    }

    public void deleteaccountById(int id) {
        accountDAO.deleteById(id);
    }
}