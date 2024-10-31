package com.akhila.ATM;

import AtmSystem.Entity.Account;
import AtmSystem.Entity.Bank;
import AtmSystem.Entity.Card;
import AtmSystem.Entity.Customer;
import AtmSystem.Entity.Transaction;
import AtmSystem.Service.AccountService;
import AtmSystem.Service.BankService;
import AtmSystem.Service.CardService;
import AtmSystem.Service.CustomerService;
import AtmSystem.Service.TransactionService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Create SessionFactory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Create services
        BankService bankService = new BankService(sessionFactory);
        CustomerService customerService = new CustomerService(sessionFactory);
        AccountService accountService = new AccountService(sessionFactory);
        CardService cardService = new CardService(sessionFactory);
        TransactionService transactionService = new TransactionService(sessionFactory);

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu options
            System.out.println("\nATM System Menu:");
            System.out.println("1. Bank Operations");
            System.out.println("2. Customer Operations");
            System.out.println("3. Account Operations");
            System.out.println("4. Card Operations");
            System.out.println("5. Transaction Operations");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Bank Operations
                    System.out.println("\nBank Operations:");
                    System.out.println("1. Create Bank");
                    System.out.println("2. Get Bank by ID");
                    System.out.println("3. Update Bank");
                    System.out.println("4. Delete Bank");
                    System.out.println("5. Get All Banks");
                    System.out.print("Enter your choice: ");
                    int bankChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    switch (bankChoice) {
                        case 1:
                            Bank newBank = new Bank();
                            System.out.print("Enter bank name: ");
                            newBank.setBank_name(scanner.nextLine());
                            System.out.print("Enter bank id: ");
                            newBank.setBank_id(scanner.nextInt());
                            scanner.nextLine();
                            System.out.print("Enter bank address: ");
                            newBank.setBank_address(scanner.nextLine());
                            System.out.print("Enter bank contact: ");
                            newBank.setBank_contact(scanner.nextLine());
                            bankService.createBank(newBank);
                            System.out.println("Successfully created bank: ");
                            break;
                        case 2:
                            System.out.print("Enter bank ID: ");
                            Bank bank = bankService.getBankById(scanner.nextInt());
                            if (bank != null) {
                                System.out.println("Bank found: " + bank.getBank_name());
                            } else {
                                System.out.println("Bank not found.");
                            }
                            break;
                        case 3:
                            System.out.print("Enter bank ID to update: ");
                            int updateBankId = scanner.nextInt();
                            Bank updateBank = bankService.getBankById(updateBankId);
                            if (updateBank != null) {
                                System.out.print("Enter new bank name: ");
                                updateBank.setBank_name(scanner.next());
                                bankService.updateBank(updateBank);
                            } else {
                                System.out.println("Bank not found.");
                            }
                            break;
                        case 4:
                            System.out.print("Enter bank ID to delete: ");
                            bankService.deleteBank(scanner.nextInt());
                            break;
                        case 5:
                        	List<Bank> banks = bankService.getAllBanks(); // Correct way to handle the list
                        	if (!banks.isEmpty()) {
                        	    Bank bank1 = banks.get(0); // Access the first bank if needed
                        	    System.out.println("Bank: " + bank1.getBank_name());
                        	} else {
                        	    System.out.println("No banks found.");
                        	}

                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 2: // Customer Operations
                    System.out.println("\nCustomer Operations:");
                    System.out.println("1. Create Customer");
                    System.out.println("2. Get Customer by ID");
                    System.out.println("3. Update Customer");
                    System.out.println("4. Delete Customer");
                    System.out.println("5. Get All Customers");
                    System.out.print("Enter your choice: ");
                    int customerChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    switch (customerChoice) {
                        case 1:
                            Customer newCustomer = new Customer();
                            System.out.print("Enter customer name: ");
                            newCustomer.setCust_name(scanner.nextLine());
                            System.out.print("Enter customer address: ");
                            newCustomer.setCust_address(scanner.nextLine());
                            System.out.print("Enter customer contact: ");
                            newCustomer.setCust_contact(scanner.nextLine());
                            customerService.createCustomer(newCustomer);
                            break;
                        case 2:
                            System.out.print("Enter customer ID: ");
                            Customer customer = customerService.getCustomerById(scanner.nextInt());
                            if (customer != null) {
                                System.out.println("Customer found: " + customer.getCust_name());
                            } else {
                                System.out.println("Customer not found.");
                            }
                            break;
                        case 3:
                            System.out.print("Enter customer ID to update: ");
                            int updateCustomerId = scanner.nextInt();
                            Customer updateCustomer = customerService.getCustomerById(updateCustomerId);
                            if (updateCustomer != null) {
                                System.out.print("Enter new customer name: ");
                                updateCustomer.setCust_name(scanner.next());
                                customerService.updateCustomer(updateCustomer);
                            } else {
                                System.out.println("Customer not found.");
                            }
                            break;
                        case 4:
                            System.out.print("Enter customer ID to delete: ");
                            customerService.deleteCustomer(scanner.nextInt());
                            break;
                        case 5:
                        	List<Customer> customers = customerService.getAllCustomers();
                        	if(!customers.isEmpty()) {
                        		Customer customer1 = customers.get(0);
                        		System.out.println("Customer: "+customer1.getCust_name());
                        	}else { 
                        		System.out.println("no customer found");
                        	}
                            
                            break;
                           
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 3: // Account Operations
                	
                    System.out.println("\nAccount Operations:");
                    
                    System.out.println("1. Create Account");
                    System.out.println("2. Get Account by ID");
                    System.out.println("3. Update Account");
                    System.out.println("4. Delete Account");
                    System.out.println("5. Get All Accounts");
                    System.out.print("Enter your choice: ");
                    int accountChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    switch (accountChoice) {
                        case 1:
                            Account newAccount = new Account();
                            System.out.println("enter account num");
                            newAccount.setaccountNumb(scanner.nextInt());
                            scanner.nextLine();
                            System.out.println("enter account type: ");
                            newAccount.setaccount_type(scanner.nextLine());
                            System.out.print("Enter account balance: ");
                            newAccount.setBalance(scanner.nextDouble());
                            // Fetch and set bank reference
                            System.out.print("Enter Bank ID: ");
                            int bankId = scanner.nextInt();
                            Bank bank = bankService.getBankById(bankId); // Assuming bankService exists
                            if (bank != null) {
                                newAccount.setBank(bank); // Set actual Bank entity
                                accountService.createAccount(newAccount);
                            } else {
                                System.out.println("Bank not found. Cannot create account.");
                            }
                            break;
                           
                        case 2:
                            System.out.print("Enter account ID: ");
                            Account account = accountService.getAccountById(scanner.nextInt());
                            if (account != null) {
                                System.out.println("Account found: " + account.getBalance());
                            } else {
                                System.out.println("Account not found.");
                            }
                            break;
                        case 3:
                            System.out.print("Enter account ID to update: ");
                            int updateAccountId = scanner.nextInt();
                            Account updateAccount = accountService.getAccountById(updateAccountId);
                            if (updateAccount != null) {
                                System.out.print("Enter new account balance: ");
                                updateAccount.setBalance(scanner.nextDouble());
                                accountService.updateAccount(updateAccount);
                            } else {
                                System.out.println("Account not found.");
                            }
                            break;
                        case 4:
                            System.out.print("Enter account ID to delete: ");
                            accountService.deleteAccount(scanner.nextInt());
                            break;
                        case 5:
                        	List<Account> accounts = accountService.getAllAccounts();
                        	if(!accounts.isEmpty()) {
                        		Account account1 = accounts.get(0);
                        		System.out.println("Account: "+ account1.getaccount_id());
                        	}else { 
                        		System.out.println("no customer found");
                        	}
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 4: // Card Operations
                    System.out.println("\nCard Operations:");
                    System.out.println("1. Create Card");
                    System.out.println("2. Get Card by ID");
                    System.out.println("3. Update Card");
                    System.out.println("4. Delete Card");
                    System.out.println("5. Get All Cards");
                    System.out.print("Enter your choice: ");
                    int cardChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    switch (cardChoice) {
                        case 1:
                            Card newCard = new Card();
                            System.out.print("Enter card number: ");
                            newCard.setCard_numb(scanner.nextInt());
                            System.out.print("Enter account ID: ");
                            newCard.setAccountId(scanner.nextInt());
                            scanner.nextLine();
                            System.out.println("enter card name: ");
                            newCard.setCard_name(scanner.nextLine());
                            System.out.println("enter expiry date: ");
                            newCard.setDate_exp(scanner.nextInt());
                            
                            cardService.createCard(newCard);
                            break;
                        case 2:
                            System.out.print("Enter card ID: ");
                            Card card = cardService.getCardById(scanner.nextInt());
                            if (card != null) {
                                System.out.println("Card found: " + card.getCard_id());
                            } else {
                                System.out.println("Card not found.");
                            }
                            break;
                        case 3:
                            System.out.print("Enter card ID to update: ");
                            int updateCardId = scanner.nextInt();
                            Card updateCard = cardService.getCardById(updateCardId);
                            if (updateCard != null) {
                                System.out.print("Enter new card number: ");
                                updateCard.setCardNumber(scanner.next());
                                cardService.updateCard(updateCard);
                            } else {
                                System.out.println("Card not found.");
                            }
                            break;
                        case 4:
                            System.out.print("Enter card ID to delete: ");
                            cardService.deleteCard(scanner.nextInt());
                            break;
                        case 5:
                        	List<Card> cards = cardService.getAllCards();
                        	if(!cards.isEmpty()) {
                        		Card card1 = cards.get(0);
                        		System.out.println("Card: "+card1.getCard_numb());
                        	}else { 
                        		System.out.println("no card found");
                        	}
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 5: // Transaction Operations
                    System.out.println("\nTransaction Operations:");
                    System.out.println("1. Create Transaction");
                    System.out.println("2. Get Transaction by ID");
                    System.out.println("3. Update Transaction");
                    System.out.println("4. Delete Transaction");
                    System.out.println("5. Get All Transactions");
                    System.out.print("Enter your choice: ");
                    int transactionChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    switch (transactionChoice) {
                        case 1:
                            Transaction newTransaction = new Transaction();
                            System.out.print("Enter transaction amount: ");
                            newTransaction.setAmount(scanner.nextDouble());
                            newTransaction.setDateTime(LocalDateTime.now());
                            System.out.print("Enter account ID: ");
                            newTransaction.setAccountId(scanner.nextInt());
                            transactionService.createTransaction(newTransaction);
                            break;
                        case 2:
                            System.out.print("Enter transaction ID: ");
                            Transaction transaction = transactionService.getTransactionById(scanner.nextInt());
                            if (transaction != null) {
                                System.out.println("Transaction found: " + transaction.getAmount());
                            } else {
                                System.out.println("Transaction not found.");
                            }
                            break;
                        case 3:
                            System.out.print("Enter transaction ID to update: ");
                            int updateTransactionId = scanner.nextInt();
                            Transaction updateTransaction = transactionService.getTransactionById(updateTransactionId);
                            if (updateTransaction != null) {
                                System.out.print("Enter new transaction amount: ");
                                updateTransaction.setAmount(scanner.nextDouble());
                                transactionService.updateTransaction(updateTransaction);
                            } else {
                                System.out.println("Transaction not found.");
                            }
                            break;
                        case 4:
                            System.out.print("Enter transaction ID to delete: ");
                            transactionService.deleteTransaction(scanner.nextInt());
                            break;
                        case 5:
                        	List<Transaction> transactions = transactionService.getAllTransactions();
                        	if(!transactions.isEmpty()) {
                        		Transaction transaction1 = transactions.get(0);
                        		System.out.println("Transaction: "+transaction1.getTr_id());
                        	}else { 
                        		System.out.println("no card found");
                        	}
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 0: // Exit
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);

        // Close resources
        bankService.close();
        customerService.close();
       // accountService.close();
        cardService.close();
        transactionService.close();
        sessionFactory.close();
        scanner.close();
    }
}
