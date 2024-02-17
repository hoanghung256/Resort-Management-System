package service;

import model.Booking;
import model.Contract;
import repository.IBookingRepository;
import utils.Validation;

import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author
 */
public class BookingService implements IBookingService {
    private IBookingRepository bookingRepo;
    private TreeSet<Booking> bookings;
    private Queue<Booking> bookingQueue = new ConcurrentLinkedQueue<>();
    private ArrayList<Contract> contracts = new ArrayList<>();
    private Validation val = new Validation();

    public BookingService(IBookingRepository bookingRepo){
        this.bookingRepo = bookingRepo;
        bookings = bookingRepo.readFile();
        bookingQueue.addAll(bookings);
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
        String serID;
        String bookID;
        String contractID;
        Contract contract;
        for (Booking b : bookingQueue){
            contract = null;
            serID = b.getServiceID();
            bookID = b.getBookingID();
            if (serID.matches("^SV(VL|HO)-\\d{4}$")){
                contractID = serID + bookID;
                for (Contract c : contracts){
                    if (c.getContractID().equals(contractID)) contract = c;
                    if (contract != null) break;
                }
                if (contract != null) continue;
                System.out.println("Create new contract for booking with ID: " + bookID + ".\nWith Service ID that required to sign a contract: " + serID);
                double prePayment = val.getAndValidSalary("Enter pre-payment amount: ");
                double totalAmount = val.getAndValidSalary("Enter total amount: ");
                Contract newContract = new Contract(contractID, bookID, prePayment, totalAmount);
                contracts.add(newContract);
                break;
            }
        }
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
