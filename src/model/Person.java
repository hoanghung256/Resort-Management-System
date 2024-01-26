package model;

import java.util.Date;
import java.util.Objects;
/**
 *
 * @author hoang hung
 */
public abstract class Person {
    private String ID;
    private String fullName;
    private Date dateOfBirth;
    private String identity;
    private boolean gender;
    private String phoneNumber;
    private String email;
    
    Person(){
        
    }

    public Person(String ID, String fullName, Date dateOfBirth, String identity, boolean gender, String phoneNumber, String email) {
        this.ID = ID;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.identity = identity;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.ID);
        hash = 23 * hash + Objects.hashCode(this.fullName);
        hash = 23 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 23 * hash + Objects.hashCode(this.identity);
        hash = 23 * hash + (this.gender ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.phoneNumber);
        hash = 23 * hash + Objects.hashCode(this.email);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (!Objects.equals(this.identity, other.identity)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public abstract String toString();
}