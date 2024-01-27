package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Customer;
import model.Employee;

/**
 *
 * @author hoang hung
 */
public class FileService implements IFileService {
    private final String path = new File("src").getAbsolutePath();
    private final String employeesPath = "\\data\\employee.csv";
    private final String customersPath = "\\data\\customer.csv";

    @Override
    public ArrayList<Employee> readEmployeesFromFile() {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(path+ employeesPath));
            ArrayList<Employee> empList = new ArrayList<>();
            while((line = input.readLine())!= null){
                String[] tokString = line.split(",");
                Date dayOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(tokString[2]);
                boolean gender = tokString[3].equals("Male") ? true : false;
                double salary = Double.parseDouble(tokString[9]);
                Employee employee = new Employee(tokString[0], tokString[1], dayOfBirth, tokString[4], gender, tokString[5], tokString[6], tokString[7], tokString[8], salary);
                empList.add(employee);        
            }
            return empList;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }     
            
    }

    @Override
    public void saveEmployeesIntoFile(ArrayList<Employee> employees) {
        try {
            PrintWriter w = new PrintWriter(path + employeesPath);
            for (Employee employee: employees){
                w.println(employee.toStringWriteInFile());
            }   
            w.close();
        } catch (Exception e) {
            e.getMessage();
        }
        
    }
    @Override
    public ArrayList<Customer> readCustomersFromFile() {
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
    public void saveCustomersIntoFile (ArrayList<Customer> customers) {
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
