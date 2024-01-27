package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Employee;

/**
 *
 * @author hoang hung
 */
public class EmployeeRepository implements IEmployeeRepository {
    public EmployeeRepository() {
    }

    @Override
    public ArrayList<Employee> readFile() {
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
    public void writeFile(ArrayList<Employee> employees) {
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
}
