package controller;

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
        val  = new Validation();
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

                        break;
                    case 2:

                        break;
                    case 3:
                        // Use findById() to know which person user want to edit then call update()
                        break;
                    case 4:
                        employeeService.save();
                        break;
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
