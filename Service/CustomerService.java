package AtmSystem.Service;

import AtmSystem.DAO.CustomerDAO;
import AtmSystem.Entity.Customer;
import org.hibernate.SessionFactory;

import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService(SessionFactory sessionFactory) {
        this.customerDAO = new CustomerDAO(sessionFactory);
    }

    // Create Customer
    public void createCustomer(Customer customer) {
        customerDAO.createCustomer(customer);
    }

    // Get Customer by ID
    public Customer getCustomerById(int customerId) {
        return customerDAO.getCustomerById(customerId);
    }

    // Update Customer
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    // Delete Customer by ID
    public void deleteCustomer(int customerId) {
        customerDAO.deleteCustomer(customerId);
    }

    // Get all Customers
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    // Close DAO resources when done
    public void close() {
        customerDAO.close();
    }
}
