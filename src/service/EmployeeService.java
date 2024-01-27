package service;

import model.Employee;
import repository.EmployeeRepository;

/**
 *
 * @author hoang hung
 */
public class EmployeeService implements IEmployeeService {
    private EmployeeRepository employeeRepo;

    public EmployeeService() {
        employeeRepo = new EmployeeRepository();
    }

    @Override
    public void findById(String id) {
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

}
