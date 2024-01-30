package service;

import java.util.Date;
import java.util.ArrayList;

import model.Customer;
import repository.ICustomerRepository;
import utils.Validation;

/**
 *
 * @author hoang hung
 */
public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepo;
    private ArrayList<Customer> customers;
    private Validation val = new Validation();

    public CustomerService(ICustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
        customers = customerRepo.readFile();
    }

    @Override
    public Customer findById(String id) {
        for (Customer c : customers) {
            if (c.getID().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    public void add(Customer c) {
        customers.add(c);
    }

    @Override
    public void update(Customer c) {
        while (true) {
            String[] split = c.toString().split(", ");
            for (int i = 0; i < 9; i++) {
                System.out.println((i + 1) + ". " + split[i]);
            }
            System.out.println("10. Back");
            int choice = Integer.parseInt(val.getAndValidValue("Enter your choice: ", "^[1-9]|10$", "Invalid choice!"));
            switch (choice) {
                case 1:
                    System.out.println("ID is fixed. Can not change!");
                    break;
                case 2:
                    String name = val.getAndValidPersonName("Enter new name:");
                    c.setFullName(name);
                    if (c.getFullName().equals(name)) {
                        System.out.println("Successfully change name.");
                    }
                    break;
                case 3:
                    Date date = java.sql.Date.valueOf(val.getAndValidDate("Enter new date of birth: "));
                    c.setDateOfBirth(date);
                    if (c.getDateOfBirth().equals(date)) {
                        System.out.println("Successfully change date of birth.");
                    }
                    break;
                case 4:
                    boolean gender = val.getAndValidValue("Enter gender: ", "^Male|Female$", "Invalid gender!")
                            .equals("Male");
                    c.setGender(gender);
                    if (c.isGender() == gender) {
                        System.out.println("Successfully change gender.");
                    }
                    break;
                case 5:
                    String identity = val.getAndValidIdentificationNum("Enter new identification number: ");
                    c.setIdentity(identity);
                    if (c.getIdentity().equals(identity)) {
                        System.out.println("Successfully change identification.");
                    }
                    break;
                case 6:
                    String phoneNumber = val.getAndValidPhone("Enter new phone number: ");
                    c.setPhoneNumber(phoneNumber);
                    if (c.getPhoneNumber().equals(phoneNumber)) {
                        System.out.println("Successfully change phone number.");
                    }
                    break;
                case 7:
                    String email = val.getAndValidValue("Enter new email: ",
                            "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$", "Invalid email!");
                    c.setEmail(email);
                    if (c.getEmail().equals(email)) {
                        System.out.println("Successfully change email.");
                    }
                    break;
                case 8:
                    String level = val.getAndValidValue("Enter new level: ", ".*", "Invalid level!");
                    c.setLevel(level);
                    if (c.getLevel().equals(level)) {
                        System.out.println("Successfully change level");
                    }
                    break;
                case 9:
                    String address = val.getAndValidValue("Enter new address: ", ".*", "Invalid position!");
                    c.setAddress(address);
                    if (c.getAddress().equals(address)) {
                        System.out.println("Successfully change address");
                    }
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    @Override
    public void save() {
        customerRepo.writeFile(customers);
    }

    
}
