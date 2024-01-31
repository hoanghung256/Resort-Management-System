package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Customer;
import repository.ICustomerRepository;

public class CustomerService implements ICustomerService {

    private ICustomerRepository customerRepo;
    static ArrayList<Customer> customers;

    public CustomerService(ICustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
        customers = customerRepo.readFile();
    }

    @Override
    public Customer findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void display() {
        if (customers.isEmpty()) {
            System.out.println("No customer found.");
        } else {
            System.out.println("+------------+----------------------+------------+-----------------+------------+--------------+--------------------------------+------------+----------------------+");
            System.out.printf("| %-10s | %-20s | %-10s | %-15s | %-10s | %-12s | %-30s | %-10s | %-20s |%n",
                    "ID", "Full Name", "Birthday", "Identification", "Gender", "Phone number", "Email", "Level", "Address");
            System.out.println("+------------+----------------------+------------+-----------------+------------+--------------+--------------------------------+------------+----------------------+");
            for (Customer st : customers) {
                String gender = (st.isGender() == true) ? "Male" : "Female";
                String dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").format(st.getDateOfBirth());
                System.out.printf("| %-10s | %-20s | %-10s | %-15s | %-10s | %-12s | %-30s | %-10s | %-20s |%n",
                        st.getID(), st.getFullName(), dateOfBirth, st.getIdentity(), gender, st.getPhoneNumber(), st.getEmail(), st.getLevel(), st.getAddress());
            }
            System.out.println("+------------+----------------------+------------+-----------------+------------+--------------+--------------------------------+------------+----------------------+");
        }
    }

    @Override
    public void add(Customer c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void update() {
        // Use switch case to know which attribute user want to change
    }

    @Override
    public void save() {
        customerRepo.writeFile(customers);
    }

}
