package repository;

import java.util.ArrayList;
import model.Customer;
import service.FileService;

/**
 *
 * @author hoang hung
 */
public class CustomerRepository implements ICustomerRepositoty {
    private FileService fileService;
    private ArrayList<Customer> customers;

    public CustomerRepository() {
        fileService = new FileService();
//        customers = fileService.readCustomersFromFile();
    }

    @Override
    public Customer findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void display(ArrayList<Customer> customers) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    public void update(Customer c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void add(Customer c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
    
}
