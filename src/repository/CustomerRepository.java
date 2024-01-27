package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Customer;

/**
 *
 * @author hoang hung
 */
public class CustomerRepository implements ICustomerRepository {
    public CustomerRepository() {
    }

    @Override
    public ArrayList<Customer> readFile() {
        String line;
        try{
            BufferedReader input = new BufferedReader(new FileReader(path + customersPath));
            ArrayList<Customer> cusList = new ArrayList<>();
            while((line = input.readLine())!= null){
                String[] tokString = line.split(",");
                Date dayOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(tokString[2]);
                boolean gender = tokString[3].equals("Male")? true : false;
                Customer customer = new Customer(tokString[0], tokString[1], dayOfBirth, tokString[4], gender, tokString[5], tokString[6], tokString[7],tokString[8]);
                cusList.add(customer);
            }
            return cusList;
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    @Override
    public void writeFile(ArrayList<Customer> customers) {
        try {
            PrintWriter w = new PrintWriter(path + customersPath);
            for (Customer cus: customers){
                w.println(cus.toStringWriteInFile());
            }   
            w.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
