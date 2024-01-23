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

//    public EmployeeRepository() {
//        fileService = new FileService();
//        employees = fileService.readEmployeesFromFile();
//    }
//    
//    @Override
//    public Employee findById(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void display(ArrayList<Employee> employees) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void update(Employee e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void add(Employee e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
