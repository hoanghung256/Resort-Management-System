package model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author hoang hung
 */
public class Customer extends Person {
    private String level;
    private Service service;
    private Booking booking;
    private String address;
    
    Customer(){
        
    }

    public Customer(String ID, String fullName, Date dateOfBirth, String identity, boolean gender, String phoneNumber, String email, String level, Service service, Booking booking, String address) {
        super(ID, fullName, dateOfBirth, identity, gender, phoneNumber, email);
        this.level = level;
        this.service = service;
        this.booking = booking;
        this.address = address;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.level);
        hash = 79 * hash + Objects.hashCode(this.service);
        hash = 79 * hash + Objects.hashCode(this.booking);
        hash = 79 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.level, other.level)) {
            return false;
        }
        if (!Objects.equals(this.service, other.service)) {
            return false;
        }
        if (!Objects.equals(this.booking, other.booking)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "level=" + level + ", service=" + service + ", booking=" + booking + ", address=" + address + '}';
    }
}
