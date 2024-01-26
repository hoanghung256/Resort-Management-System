package utils;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author hoang hung
 */
public interface IValidation {
    // Define regex for employee ID format: EMP-YYYY (YYYY is digit from 0-9)
    static final String EMPID_REGEX = "^EMP-[0-9]{4}$";
    // Define regex for customer ID format: CUS-YYYY (YYYY is digit from 0-9)
    static final String CUSID_REGEX = "^CUS-[0-9]{4}$";
    // Define regex for person name that uppercase first character of each word 
    static final String NAME_REGEX = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$";
    // Define regex for citizen identification number have 12 digits
    static final String IDENTIFICATION_REGEX = "^(\\d{12} | \\d{9})$";

    // Define regex for phone number have 10 digits and start with 0
    static final String PHONE_REGEX = "^0\\d{9}$";
    // Define date format for DATE
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //use try catch to format date. Ex: LocalDate validDate = LocalDate.parse(DateStr, formatter)
    
    public String getString(String msg);
    
    public String getAndValidEmpId(String msg);
    
    public String getAndValidCusId(String msg);
    
    public String getAndValidPersonName(String msg);
    
    public String getAndValidIdentificationNum(String msg);
    
    public double getAndValidSalary(String msg);
    
    public String getAndValidPhone(String msg);
    public Date getAndValidDate(String msg);
}
