package service;

import java.util.ArrayList;

import model.Customer;
import repository.ICustomerRepository;

/**
 *
 * @author hoang hung
 */
public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepo;
    private ArrayList<Customer> customers;

    public CustomerService(ICustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
        customers = customerRepo.readFile();
    }

    @Override
    public Customer findById(String id) {
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
    public void update() {
        // Use switch case to know which attribute user want to change
    }

    @Override
    public void save() {
        customerRepo.writeFile(customers);
    }
}
