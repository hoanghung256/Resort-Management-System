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

    @Override
    public void findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    public void add(Customer c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void update(Customer c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
