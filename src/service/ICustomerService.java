package service;

import model.Customer;

/**
 *
 * @author hoang hung
 */
public interface ICustomerService extends Service<Customer> {
    @Override
    Customer findById(String id);

    @Override
    void display();

    @Override
    void add(Customer c);

    void update(Customer c);

    @Override
    void save();
}
