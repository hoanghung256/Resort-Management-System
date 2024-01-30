package service;

import model.Employee;

/**
 *
 * @author hoang hung
 */
public interface IEmployeeService extends Service<Employee> {
    @Override
    public Employee findById(String id);

    @Override
    public void display();

    @Override
    public void add(Employee e);

    @Override
    public void update(Employee e);

    @Override
    public void save();
}
