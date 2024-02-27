package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TreeSet;
import model.Booking;


/**
 * @author hoang hung
 */
public class BookingRepository implements IBookingRepository {
    public BookingRepository() {
    }

    @Override
    public TreeSet<Booking> readFile() {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(path+ bookingsPath));
            TreeSet<Booking> bookList = new TreeSet<>();
            while((line = input.readLine())!= null){
                String[] tokString = line.split(",");
                DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                Booking booking = new Booking(tokString[0], date.parse(tokString[1]), date.parse(tokString[2]), date.parse(tokString[3]), tokString[4], tokString[5]);
                bookList.add(booking);
            }
            return bookList;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void writeFile(TreeSet<Booking> bookings) {
        try {
            PrintWriter w = new PrintWriter(path + bookingsPath);
            for (Booking book : bookings) {
                w.println(book.toStringWriteInFile());
            }
            w.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}