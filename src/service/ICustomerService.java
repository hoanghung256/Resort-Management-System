package service;

import model.Customer;

/**
 *
 * @author hoang hung
 */
public interface ICustomerService extends Service<Customer> {
    @Override
    public Customer findById(String id);

    @Override
    public void display();

    @Override
    public void add(Customer c);

    @Override
    public void update();

    @Override
    public void save();
}
