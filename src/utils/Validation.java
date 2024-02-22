package utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Validation implements IValidation {

    static Scanner sc = new Scanner(System.in);

    @Override
    public String getString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
    
    public String getAndValidValue(String msg, String regex, String cause) {
        String value;
        while (true) {
            try {
                value = getString(msg);
                if (value.isEmpty()) {
                    throw new Exception("Input can not empty");
                }
                if (!value.matches(regex)) {
                    throw new Exception(cause);
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return value;
    }
    // input name
    @Override
    public String getAndValidPersonName(String msg) {
        String personName;
        do {
            try {
                personName = getAndValidValue(msg, NAME_REGEX, "Invalid person name. Please enter a valid name.");
                return personName;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    // input customer id
    @Override
    public String getAndValidEmpId(String msg) {
        String empID;
        do {
            try {
                empID = getAndValidValue(msg, EMPID_REGEX, "Invalid employee ID. Please enter a valid employee ID.");
                return empID;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    // input customer id
    @Override
    public String getAndValidCusId(String msg) {
        String cusID;
        do {
            try {
                cusID = getAndValidValue(msg, CUSID_REGEX, "Invalid customer ID. Please enter a valid customer ID.");
                return cusID;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    //input identifycation number
    @Override
    public String getAndValidIdentificationNum(String msg) {
        String identification;
        do {
            try {
                identification = getAndValidValue(msg, IDENTIFICATION_REGEX, "Invalid identification number. Please enter a valid identification number.");
                return identification;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    //input salary
    @Override
    public double getAndValidSalary(String msg) {
        String salary;
        do {
            try {
                salary = getAndValidValue(msg, "[\\d.]+", "Invalid amount of money");

                if (Double.parseDouble(salary) <= 0) {
                    throw new Exception("Amount of money must a positive number");
                }

                return Double.parseDouble(salary);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount of money");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (true);
    }

    //input phone
    @Override
    public String getAndValidPhone(String msg) {
        String phoneNumber;
        do {
            try {
                phoneNumber = getAndValidValue(msg, PHONE_REGEX, "Invalid phone number. Please enter a valid phone number.");
                return phoneNumber;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    //input date
    @Override
    public LocalDate getAndValidDate(String msg) {
        LocalDate dob;
        do {
            try {
                String dobString = getAndValidValue(msg, "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", "Invalid date. Please enter a valid date.");
                dob = LocalDate.parse(dobString, formatter);
                validateDateOfBirth(dob);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                dob = null;
            }
        } while (dob == null);
        return dob;
    }

    //check input Date
    public void validateDateOfBirth(LocalDate dob) throws Exception {
        try {
            dob.format(formatter);
        } catch (DateTimeException ex) {
            throw new Exception("Invalid date. Please enter a valid date.");
        }
    }

    //check eligible age
    public int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();

        int age = currentDate.getYear() - birthDate.getYear();

        if (currentDate.getMonthValue() < birthDate.getMonthValue() || (currentDate.getMonthValue() == birthDate.getMonthValue() && currentDate.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }
        if (age >= 18) {
            System.out.println("You are eligible. Age: " + age);
        } else {
            System.out.println("You are not eligible. Age: " + age);
        }
        return age;
    }
    
    //input email
    @Override
    public String getAndValidEmail(String msg) {
        String identification;
        do {
            try {
                identification = getAndValidValue(msg, EMAIL_REGEX, "Invalid email. Please enter a valid email.");
                return identification;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    //input service code
    @Override
    public String getAndValidServiceCode(String msg) {
        String serviceCode;
        do {
            try {
                serviceCode = getAndValidValue(msg, SERVICECODE_REGEX,
                        "Invalid service code. Please enter a valid service code.");
                return serviceCode;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    
    //input double
     public double getAndValidDouble(String msg) {
        String d;
        do {
            try {
                d = getAndValidValue(msg, "[\\d.]+", "Invalid input. Please enter again.");

                if (Double.parseDouble(d) <= 0) {
                    throw new Exception("Value must a positive number");
                }

                return Double.parseDouble(d);
            } catch (NumberFormatException e) {
                System.out.println("Invalid.");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (true);
    }
     
     //input int
     public int getAndValidInt(String msg) {
        String d;
        do {
            try {
                d = getAndValidValue(msg, "[\\d]+", "Invalid input. Please enter again.");

                if (Integer.parseInt(d) <= 0) {
                    throw new Exception("Value must a positive number");
                }

                return Integer.parseInt(d);
            } catch (NumberFormatException e) {
                System.out.println("Invalid.");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (true);
    }
}