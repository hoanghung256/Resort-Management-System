package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author hoang hung
 */
public class Employee extends Person {
    private String level;
    private String position;
    private double salary;

    Employee() {

    }

    public Employee(String ID, String fullName, Date dateOfBirth, String identity, boolean gender, String phoneNumber,
            String email, String level, String position, double salary) {
        super(ID, fullName, dateOfBirth, identity, gender, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.level);
        hash = 59 * hash + Objects.hashCode(this.position);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.salary) ^ (Double.doubleToLongBits(this.salary) >>> 32));
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
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.level, other.level)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.salary)) {
            return false;
        }
        return true;
    }

    public String toStringWriteInFile() {
        String dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").format(super.getDateOfBirth());
        String gender = (super.isGender() == true) ? "Male" : "Female";
        return super.getID() + "," + super.getFullName() + "," + dateOfBirth + "," + gender + "," + super.getIdentity()
                + "," + super.getPhoneNumber() + "," + super.getEmail() + "," + level + "," + position + "," + salary;
    }

    @Override
    public String toString() {
        String dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").format(super.getDateOfBirth());
        String gender = (super.isGender() == true) ? "Male" : "Female";
        return String.format("| %-10s | %-20s | %-15s | %-15s | %-7s | %-12s | %-25s | %-15s | %-15s | %-7s$ |",
                super.getID(), super.getFullName(), dateOfBirth, super.getIdentity(), gender, super.getPhoneNumber(),
                super.getEmail(), level, position, salary);
    }
}
