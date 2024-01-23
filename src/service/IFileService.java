package service;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author hoang hung
 */
public interface IFileService {
    public ArrayList<Employee> readEmployeesFromFile();
    
    public ArrayList<Customer> readCustomersFromFile();
    
    public void saveEmployeesIntoFile(ArrayList<Employee> employees);
    
    public void saveCustomersIntoFile(ArrayList<Employee> customers);
}
