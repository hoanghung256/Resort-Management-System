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
    public void update(Customer entity);

    @Override
    public void add(Customer entity);

    @Override
    public void display();
}
