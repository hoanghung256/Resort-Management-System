package service;

import java.util.ArrayList;

import model.Employee;
import repository.IEmployeeRepository;

/**
 *
 * @author hoang hung
 */
public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepo;
    private ArrayList<Employee> employees;

    public EmployeeService(IEmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
        employees = employeeRepo.readFile();
    }

    @Override
    public Employee findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    public void add(Employee e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void update(Employee e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void save() {
        employeeRepo.writeFile(employees);
    }
}
