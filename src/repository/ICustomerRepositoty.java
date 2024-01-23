package repository;

import java.util.ArrayList;
import model.Customer;

/**
 *
 * @author hoang hung
 */
public interface ICustomerRepositoty extends Repository<Customer> {
    @Override
    public Customer findById(String id);
    
    @Override
    public void display(ArrayList<Customer> customers);

    @Override
    public void update(Customer c);

    @Override
    public void add(Customer c);
}
