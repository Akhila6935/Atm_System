package AtmSystem.services;

import AtmSystem.DAO.customerDAO;
import AtmSystem.Entity.customer;
import java.util.List;

public class customerServices {

    private customerDAO customerDAO;

    // Constructor to inject customerDAO dependency
    public customerServices(customerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    // Create or update a customer
    public void saveOrUpdateCustomer(customer customerEntity) {
        customerDAO.saveOrUpdate(customerEntity);
    }

    public customer getCustomerById(int id) {
        return customerDAO.getById(id);
    }

    public List<customer> getAllCustomers() {
        return customerDAO.getAll();
    }

    public void deleteCustomerById(int id) {
        customerDAO.deleteById(id);
    }
}