package repository;

import java.util.ArrayList;

import model.Booking;

/**
 *
 * @author hoang hung
 */
public interface IBookingRepository extends Repository<Booking> {
    final String bookingsPath = "\\data\\booking.csv";

    @Override
    public ArrayList<Booking> readFile();

    @Override 
    public void writeFile(ArrayList<Booking> bookings);
}
