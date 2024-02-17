package service;

import model.Booking;
import repository.IBookingRepository;
import utils.Validation;

import java.util.TreeSet;

/**
 *
 * @author 
 */
public class BookingService implements IBookingService {
    private IBookingRepository bookingRepo;
    private TreeSet<Booking> bookings;
    private Validation val = new Validation();

    public BookingService(IBookingRepository bookingRepo){
        this.bookingRepo = bookingRepo;
        bookings = bookingRepo.readFile();
    }
    @Override
    public Booking findById(String id) {
        for (Booking b : bookings){
            if (b.getBookingID().equals(id)){
                return b;
            }
        }
        return null;
    }

    @Override
    public void display() {
        if (bookings.isEmpty()) {
            System.out.println("No booking found.");
        } else {
            System.out.println("+------------+----------------------+------------+-----------------+------------+--------------+--------------------------------+------------+----------------------+");
            System.out.printf("| %-10s | %-15s | %-15s | %-15s | %-12s | %-12s |%n",
                    "Booking ID", "Book date", "Start date", "End date", "Customer ID", "Service ID");
            System.out.println("+------------+----------------------+------------+-----------------+------------+--------------+--------------------------------+------------+----------------------+");
            for (Booking st : bookings) {
                System.out.println(st.toString());
            }
            System.out.println("+------------+----------------------+------------+-----------------+------------+--------------+--------------------------------+------------+----------------------+");
        }
    }

    @Override
    public void add(Booking b) {
        bookings.add(b);
    }

    @Override
    public void createNewContract() {

    }

    @Override
    public void displayContractList() {

    }

    @Override
    public void updateContract() {

    }

    @Override
    public void save() {
        bookingRepo.writeFile(bookings);
    }
}
