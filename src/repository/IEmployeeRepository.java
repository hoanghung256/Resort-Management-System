package repository;

import java.util.ArrayList;
import model.Employee;

/**
 *
 * @author hoang hung
 */
public interface IEmployeeRepository extends Repository<Employee> {
    @Override
    public Employee findById(String id);
    
    @Override
    public void display(ArrayList<Employee> employees);

    @Override
    public void update(Employee e);

    @Override
    public void add(Employee e);
}
