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
    
}
