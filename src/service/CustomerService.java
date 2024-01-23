package service;

import model.Customer;
import repository.CustomerRepository;

/**
 *
 * @author hoang hung
 */
public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepo;

    public CustomerService() {
        customerRepo = new CustomerRepository();
    }

}
