package service;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author hoang hung
 */
public interface IFileService {
    public ArrayList<Employee> readEmployeesFromFile();
    
    public void saveEmployeesIntoFile(ArrayList<Employee> employees);
    
    public ArrayList<Customer> readCustomersFromFile();
    
    public void saveCustomersIntoFile(ArrayList<Customer> customers);
}
