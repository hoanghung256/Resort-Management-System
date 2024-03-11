package repository;

import java.util.ArrayList;
import model.Customer;

public interface ICustomerRepository extends Repository<Customer, ArrayList<Customer>> {
    final String customersPath = "\\data\\customer.csv";

    @Override
    public ArrayList<Customer> readFile();

    @Override 
    public void writeFile(ArrayList<Customer> customers);
}
