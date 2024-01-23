package service;

import model.Customer;
import model.Employee;

/**
 *
 * @author hoang hung
 */
public interface IEmployeeService extends Service<Employee> {
    @Override
    public void findById(String id);
    
    @Override
    public void update(Employee entity);

    @Override
    public void add(Employee entity);

    @Override
    public void display();
}
