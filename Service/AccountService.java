package AtmSystem.Service;

import AtmSystem.DAO.AccountDAO;
import AtmSystem.Entity.Account;
import org.hibernate.SessionFactory;

import java.util.List;

public class AccountService {
    private final AccountDAO accountDAO;

    public AccountService(SessionFactory sessionFactory) {
        this.accountDAO = new AccountDAO(sessionFactory);
    }

    // Create a new account
    public void createAccount(Account account) {
        try {
            accountDAO.createAccount(account);
            System.out.println("Account created successfully.");
        } catch (Exception e) {
            System.out.println("Error creating account: " + e.getMessage());
        }
    }

    // Retrieve an account by ID
    public Account getAccountById(int accountId) {
        Account account = null;
        try {
            account = accountDAO.getAccountById(accountId);
            if (account != null) {
                System.out.println("Account found: " + account);
            } else {
                System.out.println("Account not found with ID: " + accountId);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving account: " + e.getMessage());
        }
        return account;
    }

    // Update an existing account
    public void updateAccount(Account account) {
        try {
            accountDAO.updateAccount(account);
            System.out.println("Account updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating account: " + e.getMessage());
        }
    }

    // Delete an account by ID
    public void deleteAccount(int accountId) {
        try {
            accountDAO.deleteAccountById(accountId);
            System.out.println("Account deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error deleting account: " + e.getMessage());
        }
    }

    // Retrieve all accounts
    public List<Account> getAllAccounts() {
        List<Account> accounts = null;
        try {
            accounts = accountDAO.getAllAccounts();
            System.out.println("Accounts retrieved successfully.");
        } catch (Exception e) {
            System.out.println("Error retrieving accounts: " + e.getMessage());
        }
        return accounts;
    }

    // Close resources when done
    //public void close() {
      //  accountDAO.close();
    //}
}
