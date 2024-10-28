package com.akhila.ATM;


import AtmSystem.DAO.accountDAO;
import AtmSystem.DAO.BankDAO;
import AtmSystem.DAO.cardDAO;
import AtmSystem.DAO.customerDAO;
import AtmSystem.DAO.transactionDAO;
import AtmSystem.Entity.account;
import AtmSystem.Entity.Bank;
import AtmSystem.Entity.card;
import AtmSystem.Entity.customer;
import AtmSystem.Entity.transaction;
import AtmSystem.services.accountService;
import AtmSystem.services.BankService;
import AtmSystem.services.cardService;
import AtmSystem.services.customerServices;
import AtmSystem.services.TransactionService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Initialize Hibernate SessionFactory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Initialize DAO and Service for all entities
        BankDAO bankDAO = new BankDAO(sessionFactory);
        BankService bankService = new BankService(bankDAO);

        accountDAO accountDAO = new accountDAO(sessionFactory);
        accountService accountService = new accountService(accountDAO);

        cardDAO cardDAO = new cardDAO(sessionFactory);
        cardService cardService = new cardService(cardDAO);

        customerDAO customerDAO = new customerDAO(sessionFactory);
        customerServices customerServices = new customerServices(customerDAO);

        transactionDAO transactionDAO = new transactionDAO(sessionFactory);
        TransactionService transactionService = new TransactionService(transactionDAO);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM System:");
            System.out.println("1. Bank Management");
            System.out.println("2. Account Management");
            System.out.println("3. Card Management");
            System.out.println("4. Customer Management");
            System.out.println("5. Transaction Management");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int mainChoice = scanner.nextInt();
            switch (mainChoice) {
                case 1:
                    handleBankManagement(scanner, bankService);
                    break;
                case 2:
                    handleAccountManagement(scanner, accountService);
                    break;
                case 3:
                    handleCardManagement(scanner, cardService);
                    break;
                case 4:
                    handleCustomerManagement(scanner, customerServices);
                    break;
                case 5:
                    handleTransactionManagement(scanner, transactionService);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting the ATM System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        // Close resources
        scanner.close();
        sessionFactory.close();
    }

    private static void handleBankManagement(Scanner scanner, BankService bankService) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nBank Management:");
            System.out.println("1. Create or Update Bank");
            System.out.println("2. Get Bank by ID");
            System.out.println("3. Get All Banks");
            System.out.println("4. Delete Bank by ID");
            System.out.println("0. Back");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Bank bank = new Bank();
                    System.out.print("Enter Bank ID: ");
                    bank.setBank_id(scanner.nextInt());
                    System.out.print("Enter Bank Name: ");
                    bank.setBank_name(scanner.next());
                    System.out.print("Enter Bank Address: ");
                    bank.setBank_address(scanner.next());
                    System.out.print("Enter Bank Contact Number: ");
                    bank.setBank_contact(scanner.nextInt());

                    bankService.saveOrUpdateBank(bank);
                    System.out.println("Bank saved/updated successfully.");
                    break;

                case 2:
                    System.out.print("Enter Bank ID: ");
                    int bankId = scanner.nextInt();
                    Bank retrievedBank = bankService.getBankById(bankId);
                    if (retrievedBank != null) {
                        System.out.println("Bank: " + retrievedBank.getBank_name() + ", Address: " + retrievedBank.getBank_address() + ", Contact: " + retrievedBank.getBank_contact());
                    } else {
                        System.out.println("Bank not found.");
                    }
                    break;

                case 3:
                    List<Bank> banks = bankService.getAllBanks();
                    System.out.println("All Banks:");
                    for (Bank b : banks) {
                        System.out.println("ID: " + b.getBank_id() + ", Name: " + b.getBank_name() + ", Address: " + b.getBank_address() + ", Contact: " + b.getBank_contact());
                    }
                    break;

                case 4:
                    System.out.print("Enter Bank ID to delete: ");
                    int deleteBankId = scanner.nextInt();
                    bankService.deleteBankById(deleteBankId);
                    System.out.println("Bank deleted successfully.");
                    break;

                case 0:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void handleCustomerManagement(Scanner scanner, customerServices customerServices) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nCustomer Management:");
            System.out.println("1. Create or Update Customer");
            System.out.println("2. Get Customer by ID");
            System.out.println("3. Get All Customers");
            System.out.println("4. Delete Customer by ID");
            System.out.println("0. Back");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    customer cust = new customer();
                    System.out.print("Enter Customer ID: ");
                    cust.setCust_id(scanner.nextInt());
                    System.out.print("Enter Customer Name: ");
                    cust.setCust_name(scanner.next());
                    System.out.print("Enter Customer Address: ");
                    cust.setCust_address(scanner.next());
                    System.out.print("Enter Customer Contact Number: ");
                    cust.setCust_contact(scanner.nextInt());

                    customerServices.saveOrUpdateCustomer(cust);
                    System.out.println("Customer saved/updated successfully.");
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    customer retrievedCustomer = customerServices.getCustomerById(customerId);
                    if (retrievedCustomer != null) {
                        System.out.println("Customer: " + retrievedCustomer.getCust_name() + ", Address: " + retrievedCustomer.getCust_address() + ", Contact: " + retrievedCustomer.getcust_contact());
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    List<customer> customers = customerServices.getAllCustomers();
                    System.out.println("All Customers:");
                    for (customer c : customers) {
                        System.out.println("ID: " + c.getCust_id() + ", Name: " + c.getCust_name() + ", Address: " + c.getCust_address() + ", Contact: " + c.getcust_contact());
                    }
                    break;

                case 4:
                    System.out.print("Enter Customer ID to delete: ");
                    int deleteCustomerId = scanner.nextInt();
                    customerServices.deleteCustomerById(deleteCustomerId);
                    System.out.println("Customer deleted successfully.");
                    break;

                case 0:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private static void handleAccountManagement(Scanner scanner, accountService accountService) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nAccount Management:");
            System.out.println("1. Create or Update Account");
            System.out.println("2. Get Account by ID");
            System.out.println("3. Get All Accounts");
            System.out.println("4. Delete Account by ID");
            System.out.println("0. Back");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account acc = new account();
                    System.out.print("Enter Account Type: ");
                    acc.setAccount_type(scanner.next());
                    System.out.print("Enter Customer ID: ");
                    acc.setCust_id(scanner.nextInt());
                    System.out.print("Enter Bank ID: ");
                    acc.setBank_id(scanner.nextInt());
                    System.out.print("Enter Account Id: ");
                    acc.setAccount_id(scanner.nextInt());
                    System.out.print("Enter Account Balance: ");
                    acc.setBalance(scanner.nextFloat());

                    accountService.saveOrUpdateaccount(acc);
                    System.out.println("Account saved/updated successfully.");
                    break;

                case 2:
                    System.out.print("Enter Account ID: ");
                    int accountId = scanner.nextInt();
                    account retrievedAccount = accountService.getaccountById(accountId);
                    if (retrievedAccount != null) {
                        System.out.println("Account: " + retrievedAccount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    List<account> accounts = accountService.getAllaccounts();
                    System.out.println("All Accounts: " + accounts);
                    break;

                case 4:
                    System.out.print("Enter Account ID to delete: ");
                    int deleteAccountId = scanner.nextInt();
                    accountService.deleteaccountById(deleteAccountId);
                    System.out.println("Account deleted successfully.");
                    break;

                case 0:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void handleCardManagement(Scanner scanner, cardService cardService) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nCard Management:");
            System.out.println("1. Create or Update Card");
            System.out.println("2. Get Card by ID");
            System.out.println("3. Get All Cards");
            System.out.println("4. Delete Card by ID");
            System.out.println("0. Back");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    card cardEntity = new card();
                    System.out.print("Enter Card ID: ");
                    cardEntity.setCard_id(scanner.nextInt());
                    System.out.print("Enter Card Name: ");
                    cardEntity.setCard_name(scanner.next());
                    System.out.print("Enter Card Number: ");
                    cardEntity.setCard_numb(scanner.nextInt());
                    System.out.print("Enter Expiry Date (YYYYMM): ");
                    cardEntity.setDate_exp(scanner.nextInt());

                    cardService.saveOrUpdateCard(cardEntity);
                    System.out.println("Card saved/updated successfully.");
                    break;

                case 2:
                    System.out.print("Enter Card ID: ");
                    int cardId = scanner.nextInt();
                    card retrievedCard = cardService.getcardById(cardId);
                    if (retrievedCard != null) {
                        System.out.println("Card: " + retrievedCard.getCard_name() + ", Number: " + retrievedCard.getCard_numb() + ", Expiry: " + retrievedCard.getDate_exp());
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;

                case 3:
                    List<card> cards = cardService.getAllCards();
                    System.out.println("All Cards:");
                    for (card c : cards) {
                        System.out.println("ID: " + c.getCard_id() + ", Name: " + c.getCard_name() + ", Number: " + c.getCard_numb() + ", Expiry: " + c.getDate_exp());
                    }
                    break;

                case 4:
                    System.out.print("Enter Card ID to delete: ");
                    int deleteCardId = scanner.nextInt();
                    cardService.deleteCardById(deleteCardId);
                    System.out.println("Card deleted successfully.");
                    break;

                case 0:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

   
    private static void handleTransactionManagement(Scanner scanner, TransactionService transactionService) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nTransaction Management:");
            System.out.println("1. Create or Update Transaction");
            System.out.println("2. Get Transaction by ID");
            System.out.println("3. Get All Transactions");
            System.out.println("4. Delete Transaction by ID");
            System.out.println("0. Back");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    transaction trans = new transaction();
                    System.out.print("Enter Transaction ID: ");
                    trans.setTr_id(scanner.nextInt());
                    System.out.print("Enter Amount: ");
                    trans.setAmount(scanner.nextDouble());
                    System.out.print("Enter Account ID: ");
                    trans.setaccount_id(scanner.nextInt());

                    transactionService.saveOrUpdateTransaction(trans);
                    System.out.println("Transaction saved/updated successfully.");
                    break;

                case 2:
                    System.out.print("Enter Transaction ID: ");
                    int transactionId = scanner.nextInt();
                    transaction retrievedTransaction = transactionService.getTransactionById(transactionId);
                    if (retrievedTransaction != null) {
                        System.out.println("Transaction: " + retrievedTransaction);
                    } else {
                        System.out.println("Transaction not found.");
                    }
                    break;

                case 3:
                    List<transaction> transactions = transactionService.getAllTransactions();
                    System.out.println("All Transactions: " + transactions);
                    break;

                case 4:
                    System.out.print("Enter Transaction ID to delete: ");
                    int deleteTransactionId = scanner.nextInt();
                    transactionService.deleteTransactionById(deleteTransactionId);
                    System.out.println("Transaction deleted successfully.");
                    break;

                case 0:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
