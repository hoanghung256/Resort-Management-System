package controller;

import java.util.Date;
import java.time.LocalDate;
import java.util.TreeSet;

import model.*;
import repository.*;
import service.*;
import utils.Validation;
import view.Menu;

/**
 * @author hoang hung
 */
public class FuramaController extends Menu<String> {
    private static final String MENU_TITLE = "FURAMA RESORT MANAGEMENT";
    private static final String[] MENU_OPTIONS = {"Employee Management", "Customer Management", "Facility Management",
            "Booking Management", "Promotion Management", "Exit"};
    private Menu<String> employeeManagementMenu;
    private Menu<String> customerManagementMenu;
    private Menu<String> bookingManagementMenu;
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
                runBookingManagementMenu();
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
        String[] options = {"Display employees list", "Add new employee", "Edit employee information",
                "Return main menu"};
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
                        String id;
                        do {
                            id = val.getAndValidEmpId("Enter new employee ID: ");
                            if (employeeService.findById(id) != null) {
                                System.out.println("Employee ID have been existed! Please enter a unique ID.");
                            }
                        } while (employeeService.findById(id) != null);

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
        String[] options = {"Display customers list", "Add new customer", "Edit customer information",
                "Return main menu"};
        ICustomerRepository customerRepo = new CustomerRepository();
        CustomerService customerService = new CustomerService(customerRepo);

        customerManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        customerService.display();
                        break;
                    case 2:
                        String id;
                        do {
                            id = val.getAndValidEmpId("Enter new customer ID: ");
                            if (customerService.findById(id) != null) {
                                System.out.println("Customer ID have been existed! Please enter a unique ID.");
                            }
                        } while (customerService.findById(id) != null);

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
                        // customerService.save();
                        break;
                }
            }
        };

        customerManagementMenu.run();
    }

    private void runBookingManagementMenu() {
        String title = "Booking MANAGEMENT";
        String[] options = {"Add new booking", "Display booking list", "Create new contract", "Display contract list", "Edit contract information",
                "Return main menu"};
        IBookingRepository bookingRepo = new BookingRepository();
        BookingService bookingService = new BookingService(bookingRepo);
        ICustomerRepository customerRepo = new CustomerRepository();
        CustomerService customerService = new CustomerService(customerRepo);
        IFacilityRepository facilityRepo = new FacilityRepository();
        FacilityService facilityService = new FacilityService();

        bookingManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        String bookID = "BK" + (bookingRepo.readFile().size() + 1);
                        Date bookDate = java.sql.Date.valueOf(val.getAndValidDate("Enter book date: "));
                        Date startDate = java.sql.Date.valueOf(val.getAndValidDate("Enter start date: "));
                        Date endDate = java.sql.Date.valueOf(val.getAndValidDate("Enter end date: "));
                        String cusID;
                        do {
                            cusID = val.getAndValidCusId("Enter available customer ID: ");
                            if (customerService.findById(cusID) != null) {
                                break;
                            }
                        } while (customerService.findById(cusID) == null);
                        String serID;
                        Facility facility = null;
                        do {
                            serID = val.getAndValidServiceCode("Enter available service ID: ");
                            if (facilityService.findById(serID) != null) {
                                facility = facilityService.findById(serID);
                                break;
                            }
                        } while (facilityService.findById(serID) == null);
                        if (facilityRepo.readFile().containsKey(facility)) {
                            facilityRepo.readFile().put(facility, facilityRepo.readFile().get(facility) + 1);
                        }
                        Booking newBooking = new Booking(bookID, bookDate, startDate, endDate, cusID, serID);
                        bookingService.add(newBooking);
                        break;
                    case 2:
                        bookingService.display();
                        break;
                    case 3:
                        bookingService.createNewContract();
                        break;
                    case 4:
                        bookingService.displayContractList();
                        break;
                    case 5:
                        bookingService.updateContract();
                        break;
                    case 6:
                        bookingService.save();
                        return;
                }
            }
        };
        bookingManagementMenu.run();
    }
}
