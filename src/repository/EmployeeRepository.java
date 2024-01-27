package repository;

import java.util.ArrayList;
import model.Employee;
import service.FileService;

/**
 *
 * @author hoang hung
 */
public class EmployeeRepository implements IEmployeeRepository {
    private FileService fileService;
    private ArrayList<Employee> employees;

    public EmployeeRepository() {
        fileService = new FileService();
//        employees = fileService.readEmployeesFromFile();
    }

    @Override
    public Employee findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void display(ArrayList<Employee> employees) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    public void update(Employee e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void add(Employee e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}
