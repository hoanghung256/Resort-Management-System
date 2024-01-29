package controller;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.Date;

import model.Employee;
=======
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

import model.Customer;
>>>>>>> 0d8af81 (Updated Customer add)
import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.ICustomerRepository;
import repository.IEmployeeRepository;
import service.*;
import utils.Validation;
import view.Menu;

/**
 *
 * @author hoang hung
 */
public class FuramaController extends Menu<String> {
    private static final String MENU_TITLE = "FURAMA RESORT MANAGEMENT";
    private static final String[] MENU_OPTIONS = {"Employee Management", "Customer Management", "Facility Management", "Booking Management", "Promotion Management", "Exit"};
    private Menu<String> employeeManagementMenu;
    private Menu<String> customerManagementMenu;
<<<<<<< HEAD
    static Validation validation = new Validation();
=======
    private Validation validation = new Validation();
>>>>>>> 0d8af81 (Updated Customer add)

    public FuramaController() {
        super(MENU_TITLE, MENU_OPTIONS);
    }
    
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                runEmployeeManagementMenu();
                break;
            case 2:
                runCustomerManagementMenu();
                break;
            case 3:
                // Call Facility Management menu
                break;
            case 4:
                // Call Booking Management menu
                break;
            case 5:
                // Call Promotion Management menu
                break;
            case 6:
                System.out.println("Goodbye!");
                System.exit(0);
                break;    
        }
    }
    
    private void runEmployeeManagementMenu() {
        String title = "EMPLOYEE MANAGEMENT";
        String[] options = {"Display employees list", "Add new employee", "Edit employee information", "Return main menu"};
        IEmployeeRepository employeeRepo = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepo);
        
        employeeManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        employeeService.display();
                        break;
                    case 2:
                        String id = validation.getAndValidEmpId("Enter new employee ID: ");
                        String name = validation.getAndValidPersonName("Enter new employee's Name: ");
                        String gender = validation.getAndValidValue("Enter employee's gender: ", "M|F", "Invalid gender! Please input again!");
                        boolean genderEmployee = gender.equals("M")? true : false;
                        LocalDate date = validation.getAndValidDate("Enter employee's date of birth: ");
                        Date dateOfBirth = java.sql.Date.valueOf(date);
                        String identity = validation.getAndValidIdentificationNum("Enter employee's identification number: ");
                        String phoneNumber = validation.getAndValidPhone("Enter employee's phone number: ");
                        String email = validation.getAndValidValue("Enter employee's email: ", "^(.+)@(\\S+)$", "Invalid email. Please enter email again!");
                        String level = validation.getString("Enter employee's level: ");
                        String position = validation.getString("Enter employee's position: ");
                        Double salary = validation.getAndValidSalary("Enter employee's salary: ");
                        Employee e = new Employee(id, name, dateOfBirth, identity, genderEmployee, phoneNumber, email, level, position, salary);
                        employeeService.add(e);
                        break;
                    case 3:
                        // Use findById() to know which person user want to edit then call update()
                        break;
                    case 4:
                        // employeeService.save();
                        break;    
                }
            }
        };
        
        employeeManagementMenu.run();
    }
    
    private void runCustomerManagementMenu() {
        String title = "CUSTOMER MANAGEMENT";
        String[] options = {"Display customers list", "Add new customer", "Edit customer information", "Return main menu"};
        ICustomerRepository customerRepo = new CustomerRepository();
        CustomerService customerService = new CustomerService(customerRepo);

        customerManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        
                        break;
                    case 2:
                        String id = validation.getAndValidCusId("Enter customer ID: ");
                        String fullName = validation.getAndValidPersonName("Enter customer's name: ");
                        LocalDate date = validation.getAndValidDate("Enter date of birth: ");
                        Date dateOfBirth = java.sql.Date.valueOf(date);
                        String identity = validation.getAndValidIdentificationNum("Enter Identification number: ");
                        String gen = validation.getAndValidValue("Enter customer's gender (M/F): ", "[MF]", "Gender must be Male or Female!");
                        boolean gender= gen.equals("M")? true:false;
                        String phoneNumber = validation.getAndValidPhone("Enter phone number: ");
                        String email = validation.getAndValidValue("Enter customer email: ", "(.+)@(\\S+)$", "Email must be follow YY..Y@gmail.com");
                        String level = validation.getString("Enter Customer level: ");
                        String address = validation.getAndValidValue("Enter Address: ", "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$", "Address must be upper case first character of each word!");
                        Customer c = new Customer(id, fullName, dateOfBirth, identity, gender, phoneNumber, email, level, address);
                        customerService.add(c);
                        break;
                    case 3:
                        // Use findById() to know which person user want to edit then call update()
                        break;
                    case 4:
                        customerService.save();
                        break;    
                }
            }
        };
        
        customerManagementMenu.run();
    }
}
