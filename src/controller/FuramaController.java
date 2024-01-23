package controller;

import view.Menu;

/**
 *
 * @author hoang hung
 */
public class FuramaController extends Menu<String> {
    private static String MENU_TITLE = "FURAMA RESORT MANAGEMENT";
    private static String[] MENU_OPTIONS = {"Employee Management", "Customer Management", "Facility Management", "Booking Management", "Promotion Management", "Exit"};
    private Menu<String> employeeManagementMenu;
    private Menu<String> customerManagementMenu;

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
                runCustomerManagementMenuMenu();
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
                // Save all data into files
                System.exit(0);
                break;    
        }
    }
    
    private void runEmployeeManagementMenu() {
        String title = "EMPLOYEE MANAGEMENT";
        String[] options = {"Display employees list", "Add new employee", "Edit employee information", "Return main menu"};
        
        employeeManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        // Return main menu
                        break;
                }
            }
        };
        
        employeeManagementMenu.run();
    }
    
    private void runCustomerManagementMenuMenu() {
        String title = "CUSTOMER MANAGEMENT";
        String[] options = {"Display customers list", "Add new customer", "Edit customer information", "Return main menu"};
        
        customerManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        // Return main menu
                        break;
                }
            }
        };
        
        customerManagementMenu.run();
    }
}
