package repository;

import java.util.ArrayList;
import model.Employee;

public interface IEmployeeRepository extends Repository<Employee, ArrayList<Employee>> {
    final String employeesPath = "\\data\\employee.csv";

    @Override
    public ArrayList<Employee> readFile();

    @Override 
    public void writeFile(ArrayList<Employee> employees);
}
