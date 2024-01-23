package repository;

import java.util.ArrayList;
import model.Customer;
import service.FileService;

/**
 *
 * @author hoang hung
 */
public class CustomerRepository implements ICustomerRepositoty {
    private FileService fileService;
    private ArrayList<Customer> customers;

    public CustomerRepository() {
        fileService = new FileService();
//        customers = fileService.readCustomersFromFile();
    }
    
}
