package repository;

import java.io.File;
import java.util.ArrayList;
import model.Customer;

/**
 *
 * @author hoang hung
 */
public interface ICustomerRepository extends Repository<Customer> {
    final String path = new File("src").getAbsolutePath();
    final String customersPath = "\\data\\customer.csv";

    @Override
    public ArrayList<Customer> readFile();

    @Override 
    public void writeFile(ArrayList<Customer> customers);
}
