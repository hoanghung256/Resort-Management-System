package service;

import java.util.ArrayList;
import java.util.Date;

import model.Employee;
import repository.IEmployeeRepository;
import utils.Validation;

/**
 *
 * @author hoang hung
 */
public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepo;
    private ArrayList<Employee> employees;
    static Validation val;

    public EmployeeService(IEmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
        employees = employeeRepo.readFile();
        val = new Validation();
    }

    @Override
    public Employee findById(String id) {
        for (Employee e : employees) {
            if (e.getID().equals(id)) {
                return e;
            }
        }
        System.out.println("Not found employee!");
        return null;
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        employees.forEach(System.out::println);
    }

    @Override
    public void add(Employee e) {
        // TODO Auto-generated method stub
        employees.add(e);
        
    }

    @Override
    public void update(Employee e) {
        while (true) {
            String[] split = e.toString().split(", ");
            for (int i = 0; i < 10; i++) {
                System.out.println((i+1) + ". " + split[i]);
            }
            System.out.println("11. Back");
            int choice = Integer.parseInt(val.getAndValidValue("Enter your choice: ", "^[1-9]|10|11$", "Invalid choice!"));
            switch (choice){
                case 1:
                    System.out.println("ID is fixed. Can not change!");
                    break;
                case 2:
                    String name = val.getAndValidPersonName("Enter new name:");
                    e.setFullName(name);
                    if (e.getFullName().equals(name)){
                        System.out.println("Successfully change name.");
                    }
                    break;
                case 3:
                    Date date = java.sql.Date.valueOf(val.getAndValidDate("Enter new date of birth: "));
                    e.setDateOfBirth(date);
                    if (e.getDateOfBirth().equals(date)){
                        System.out.println("Successfully change date of birth.");
                    }
                    break;
                case 4:
                    boolean gender = val.getAndValidValue("Enter gender: ", "^Male|Female$", "Invalid gender!").equals("Male");
                    e.setGender(gender);
                    if (e.isGender() == gender){
                        System.out.println("Successfully change gender.");
                    }
                    break;
                case 5:
                    String identity = val.getAndValidIdentificationNum("Enter new identification number: ");
                    e.setIdentity(identity);
                    if (e.getIdentity().equals(identity)){
                        System.out.println("Successfully change identification.");
                    }
                    break;
                case 6:
                    String phoneNumber = val.getAndValidPhone("Enter new phone number: ");
                    e.setPhoneNumber(phoneNumber);
                    if (e.getPhoneNumber().equals(phoneNumber)){
                        System.out.println("Successfully change phone number.");
                    }
                    break;
                case 7:
                    String email = val.getAndValidValue("Enter new email: ", "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$", "Invalid email!");
                    e.setEmail(email);
                    if (e.getEmail().equals(email)){
                        System.out.println("Successfully change email.");
                    }
                    break;
                case 8:
                    String level = val.getAndValidValue("Enter new level: ", ".*", "Invalid level!");
                    e.setLevel(level);
                    if (e.getLevel().equals(level)){
                        System.out.println("Successfully change level");
                    }
                    break;
                case 9:
                    String position = val.getAndValidValue("Enter new position: ", ".*", "Invalid position!");
                    e.setPosition(position);
                    if (e.getPosition().equals(position)){
                        System.out.println("Successfully change position");
                    }
                    break;
                case 10:
                    double salary = val.getAndValidSalary("Enter new salary: ");
                    e.setSalary(salary);
                    if (e.getSalary() == salary){
                        System.out.println("Successfully change salary!");
                    }
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    @Override
    public void save() {
        employeeRepo.writeFile(employees);
    }

}
