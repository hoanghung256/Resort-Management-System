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
        customers = fileService.readCustomersFromFile();
    }
    
    @Override
    public Customer findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void display(ArrayList<Customer> customers) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Customer c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Customer c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
