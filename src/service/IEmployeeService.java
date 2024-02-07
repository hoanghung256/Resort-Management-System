package service;

import model.Employee;

/**
 *
 * @author hoang hung
 */
public interface IEmployeeService extends Service<Employee> {
    @Override
    Employee findById(String id);

    @Override
    void display();

    @Override
    void add(Employee e);

    void update(Employee e);

    @Override
    void save();
}
