package AtmSystem.DAO;

import AtmSystem.Entity.Account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AccountDAO {

    private final SessionFactory sessionFactory;

    public AccountDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory; // Reuse existing SessionFactory
    }

    // No need to create and close SessionFactory here
    @SuppressWarnings("deprecation")
	public void createAccount(Account account) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error creating account: " + e.getMessage());
        }
    }

    // READ by ID
    public Account getAccountById(int accountId) {
        Account account = null;
        try (Session session = sessionFactory.openSession()) {
            account = session.get(Account.class, accountId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    // READ All
    public List<Account> getAllAccounts() {
        List<Account> accounts = null;
        try (Session session = sessionFactory.openSession()) {
            accounts = session.createQuery("from Account", Account.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    // UPDATE
    @SuppressWarnings("deprecation")
    public void updateAccount(Account account) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // DELETE by ID
    @SuppressWarnings("deprecation")
    public void deleteAccountById(int accountId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Account account = session.get(Account.class, accountId);
            if (account != null) {
                session.delete(account);
                System.out.println("Account is deleted successfully");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
