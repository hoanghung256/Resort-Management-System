package service;

import model.Customer;

/**
 *
 * @author hoang hung
 */
public interface ICustomerService extends Service<Customer> {
    @Override
    public void findById(String id);
    
    @Override
    public void display();
    
    @Override
    public void add(Customer c);
    
    @Override
    public void update(Customer c);
}
