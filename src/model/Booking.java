package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author hoang hung
 */
public class Booking implements Comparable<Booking> {
    private String bookingID;
    private Date bookDate;
    private Date startDate;
    private Date endDate;
    private String customerID;
    private String serviceID;

    public Booking(String bookingID, Date bookDate, Date startDate, Date endDate, String customerID, String serviceID) {
        this.bookingID = bookingID;
        this.bookDate = bookDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerID = customerID;
        this.serviceID = serviceID;
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
        customerID = customerID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return Objects.equals(getBookingID(), booking.getBookingID()) && Objects.equals(getBookDate(), booking.getBookDate()) && Objects.equals(getStartDate(), booking.getStartDate()) && Objects.equals(getEndDate(), booking.getEndDate()) && Objects.equals(getCustomerID(), booking.getCustomerID()) && Objects.equals(getServiceID(), booking.getServiceID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingID(), getBookDate(), getStartDate(), getEndDate(), getCustomerID(), getServiceID());
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
        return bookingID + "," + date.format(bookDate) + "," + date.format(startDate) + "," + date.format(endDate) + "," + customerID + "," + serviceID;
    }

    @Override
    public String toString() {
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("| %-10s | %-15s | %-15s | %-15s | %-12s | %-12s |",
                bookingID, date.format(bookDate), date.format(startDate), date.format(endDate), customerID, serviceID);
    }
}