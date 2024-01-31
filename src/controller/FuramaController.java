package controller;

import java.util.Date;
import java.time.LocalDate;

import model.*;
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
    private static final String[] MENU_OPTIONS = { "Employee Management", "Customer Management", "Facility Management",
            "Booking Management", "Promotion Management", "Exit" };
    private Menu<String> employeeManagementMenu;
    private Menu<String> customerManagementMenu;
    private Validation val;

    public FuramaController() {
        super(MENU_TITLE, MENU_OPTIONS);
        val = new Validation();
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
        String[] options = { "Display employees list", "Add new employee", "Edit employee information",
                "Return main menu" };
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
                        String id = val.getAndValidEmpId("Enter new employee ID: ");
                        String name = val.getAndValidPersonName("Enter new employee's Name: ");
                        String gender = val.getAndValidValue("Enter employee's gender: ", "M|F",
                                "Invalid gender! Please input again!");
                        boolean genderEmployee = gender.equals("M") ? true : false;
                        LocalDate date = val.getAndValidDate("Enter employee's date of birth: ");
                        Date dateOfBirth = java.sql.Date.valueOf(date);
                        String identity = val.getAndValidIdentificationNum("Enter employee's identification number: ");
                        String phoneNumber = val.getAndValidPhone("Enter employee's phone number: ");
                        String email = val.getAndValidEmail("Enter employee's email: ");
                        String level = val.getString("Enter employee's level: ");
                        String position = val.getString("Enter employee's position: ");
                        Double salary = val.getAndValidSalary("Enter employee's salary: ");
                        Employee newEmp = new Employee(id, name, dateOfBirth, identity, genderEmployee, phoneNumber,
                                email,
                                level, position, salary);
                        employeeService.add(newEmp);
                        break;
                    case 3:
                        // Use findById() to know which person user want to edit then call update()
                        Employee e;
                        do {
                            String inputId = val.getAndValidEmpId("Enter employer ID: ");
                            e = employeeService.findById(inputId);
                        } while (e == null);
                        employeeService.update(e);
                        break;
                    case 4:
                        // employeeService.save();
                        return;
                }
            }
        };

        employeeManagementMenu.run();
    }

    private void runCustomerManagementMenu() {
        String title = "CUSTOMER MANAGEMENT";
        String[] options = { "Display customers list", "Add new customer", "Edit customer information",
                "Return main menu" };
        ICustomerRepository customerRepo = new CustomerRepository();
        CustomerService customerService = new CustomerService(customerRepo);

        customerManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:

                        break;
                    case 2:
                        String id = val.getAndValidCusId("Enter customer ID: ");
                        String fullName = val.getAndValidPersonName("Enter customer's name: ");
                        LocalDate date = val.getAndValidDate("Enter date of birth: ");
                        Date dateOfBirth = java.sql.Date.valueOf(date);
                        String identity = val.getAndValidIdentificationNum("Enter Identification number: ");
                        String gen = val.getAndValidValue("Enter customer's gender (M/F): ", "[MF]",
                                "Gender must be Male or Female!");
                        boolean gender = gen.equals("M") ? true : false;
                        String phoneNumber = val.getAndValidPhone("Enter phone number: ");
                        String email = val.getAndValidEmail("Enter customer's email: ");
                        String level = val.getString("Enter Customer level: ");
                        String address = val.getAndValidValue("Enter Address: ", "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$",
                                "Address must be upper case first character of each word!");
                        Customer newCus = new Customer(id, fullName, dateOfBirth, identity, gender, phoneNumber, email,
                                level, address);
                        customerService.add(newCus);
                        break;
                    case 3:
                        Customer c;
                        do {
                        String inputId = val.getAndValidCusId("Enter customer ID: ");
                            c = customerService.findById(inputId);
                        } while (c == null);
                        customerService.update(c);
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
