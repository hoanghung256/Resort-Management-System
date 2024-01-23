package utils;

/**
 *
 * @author hoang hung
 */
public interface IValidation {
    // Define regex for employee ID format: EMP-YYYY (YYYY is digit from 0-9)
    static final String EMPID_REGEX = " ";
    // Define regex for customer ID format: CUS-YYYY (YYYY is digit from 0-9)
    static final String CUSID_REGEX = " ";
    // Define regex for person name that uppercase first character of each word 
    static final String NAME_REGEX = " ";
    // Define regex for citizen identification number have 12 digits
    static final String IDENTIFICATION_REGEX = " ";
    // Define regex for phone number have 10 digits and start with 0
    static final String PHONE_REGEX = " ";
    
    public String getString(String msg);
    
    public String getAndValidEmpId(String msg);
    
    public String getAndValidCusId(String msg);
    
    public String getAndValidPersonName(String msg);
    
    public String getAndValidIdentificationNum(String msg);
    
    public double getAndValidSalary(String msg);
    
    public String getAndValidPhone(String msg);
}
