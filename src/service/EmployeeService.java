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

}
