package repository;

import java.util.TreeSet;

import model.Booking;

/**
 *
 * @author hoang hung
 */
public interface IBookingRepository extends Repository<Booking, TreeSet<Booking>> {
    final String bookingsPath = "\\data\\booking.csv";

    @Override
    public TreeSet<Booking> readFile();

    @Override 
    public void writeFile(TreeSet<Booking> bookings);
}
