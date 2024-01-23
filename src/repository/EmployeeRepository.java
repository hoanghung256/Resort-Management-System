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
}
