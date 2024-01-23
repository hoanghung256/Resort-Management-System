package service;

import java.io.File;
import java.util.ArrayList;
import model.Customer;
import model.Employee;

/**
 *
 * @author hoang hung
 */
public class FileService implements IFileService {
    private final String path = new File("src").getAbsolutePath();
    private final String employeesPath = "\\data\\employees.txt";
    private final String customersPath = "\\data\\customers.txt";

//    @Override
//    public ArrayList<Employee> readEmployeesFromFile() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public ArrayList<Customer> readCustomersFromFile() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void saveEmployeesIntoFile(ArrayList<Employee> employees) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void saveCustomersIntoFile(ArrayList<Employee> customers) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
