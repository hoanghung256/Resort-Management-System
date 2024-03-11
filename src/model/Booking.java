package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Booking implements Comparable<Booking> {

    private String bookingID;
    private Date bookDate;
    private Date startDate;
    private Date endDate;
    private String customerID;

    public Booking(String bookingID, Date bookDate, Date startDate, Date endDate, String customerID) {
        this.bookingID = bookingID;
        this.bookDate = bookDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerID = customerID;
    }

    public Booking() {

    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;

        return Objects.equals(getBookingID(), booking.getBookingID())
                && Objects.equals(getBookDate(), booking.getBookDate())
                && Objects.equals(getStartDate(), booking.getStartDate())
                && Objects.equals(getEndDate(), booking.getEndDate())
                && Objects.equals(getCustomerID(), booking.getCustomerID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingID(), getBookDate(), getStartDate(), getEndDate(), getCustomerID());
    }

    @Override
    public int compareTo(Booking o) {
        int dateComparison = this.bookDate.compareTo(o.bookDate);
        if (dateComparison == 0) {
            return this.endDate.compareTo(o.endDate);
        } else {
            return dateComparison;
        }
    }

    public String toStringWriteInFile() {
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("| %-10s | %-15s | %-15s | %-15s | %-12s |",
                bookingID, date.format(bookDate), date.format(startDate), date.format(endDate), customerID);    }

    public static Booking fromString(String str) throws ParseException {
        String[] parts = str.split("\\|");
        Booking booking = new Booking();
        booking.setBookingID(parts[1]);
        booking.setBookDate(new SimpleDateFormat("dd/MM/yyyy").parse(parts[2]));
        booking.setStartDate(new SimpleDateFormat("dd/MM/yyyy").parse(parts[3]));
        booking.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse(parts[4]));
        booking.setCustomerID(parts[5]);
        return booking;
    }

    @Override
    public String toString() {
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("| %-10s | %-15s | %-15s | %-15s | %-12s |",
                bookingID, date.format(bookDate), date.format(startDate), date.format(endDate), customerID);
    }
}
