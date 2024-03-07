package controller;

import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import model.*;
import repository.*;
import service.*;
import utils.Validation;
import view.Menu;

public class FuramaController extends Menu<String> {

    private static final String MENU_TITLE = "FURAMA RESORT MANAGEMENT";
    private static final String[] MENU_OPTIONS = {"Employee Management", "Customer Management", "Facility Management",
        "Booking Management", "Promotion Management", "Exit"};
    private Menu<String> employeeManagementMenu;
    private Menu<String> customerManagementMenu;
    private Menu<String> facilityManagementMenu;
    private Menu<String> bookingManagementMenu;
    private Menu<String> promotionManagementMenu;
    private Validation val;

    public FuramaController() {
        super(MENU_TITLE, MENU_OPTIONS);
        val = new Validation();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                runEmployeeManagementMenu();
                break;
            case 2:
                runCustomerManagementMenu();
                break;
            case 3:
                runFacilityManagementMenu();
                break;
            case 4:
                runBookingManagementMenu();
                break;
            case 5:
                runPromotionManagementMenu();
                break;
            case 6:
                System.exit(0);
                break;
        }
    }

    private void runEmployeeManagementMenu() {
        String title = "EMPLOYEE MANAGEMENT";
        String[] options = {"Display employees list", "Add new employee", "Edit employee information",
            "Return main menu"};
        IEmployeeRepository employeeRepo = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepo);

        employeeManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        employeeService.display();
                        break;
                    case 2:
                        String id;
                        do {
                            id = val.getAndValidEmpId("Enter new employee ID: ");
                            if (employeeService.findById(id) != null) {
                                System.out.println("Employee ID have been existed! Please enter a unique ID.");
                            }
                        } while (employeeService.findById(id) != null);

                        String name = val.getAndValidPersonName("Enter new employee's Name: ");
                        String gender = val.getAndValidValue("Enter employee's gender: ", "M|F",
                                "Invalid gender! Please input again!");
                        boolean genderEmployee = gender.equals("M") ? true : false;
                        LocalDate date = val.getAndValidDate("Enter employee's date of birth: ");
                        Date dateOfBirth = java.sql.Date.valueOf(date);
                        String identity = val.getAndValidIdentificationNum("Enter employee's identification number: ");
                        String phoneNumber = val.getAndValidPhone("Enter employee's phone number: ");
                        String email = val.getAndValidEmail("Enter employee's email: ");
                        String level = val.getString("Enter employee's level: ");
                        String position = val.getString("Enter employee's position: ");
                        Double salary = val.getAndValidSalary("Enter employee's salary: ");
                        Employee newEmp = new Employee(id, name, dateOfBirth, identity, genderEmployee, phoneNumber, email, level, position, salary);
                        employeeService.add(newEmp);
                        break;
                    case 3:
                        Employee e;
                        do {
                            String inputId = val.getAndValidEmpId("Enter employer ID: ");
                            e = employeeService.findById(inputId);
                        } while (e == null);
                        employeeService.update(e);
                        break;
                    case 4:
                        employeeService.save();
                        return;
                }
            }
        };

        employeeManagementMenu.run();
    }

    private void runCustomerManagementMenu() {
        String title = "CUSTOMER MANAGEMENT";
        String[] options = {"Display customers list", "Add new customer", "Edit customer information",
            "Return main menu"};
        ICustomerRepository customerRepo = new CustomerRepository();
        CustomerService customerService = new CustomerService(customerRepo);

        customerManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        customerService.display();
                        break;
                    case 2:
                        String id;
                        do {
                            id = val.getAndValidEmpId("Enter new customer ID: ");
                            if (customerService.findById(id) != null) {
                                System.out.println("Customer ID have been existed! Please enter a unique ID.");
                            }
                        } while (customerService.findById(id) != null);

                        String fullName = val.getAndValidPersonName("Enter customer's name: ");
                        LocalDate date = val.getAndValidDate("Enter date of birth: ");
                        Date dateOfBirth = java.sql.Date.valueOf(date);
                        String identity = val.getAndValidIdentificationNum("Enter Identification number: ");
                        String gen = val.getAndValidValue("Enter customer's gender (M/F): ", "[MF]",
                                "Gender must be Male or Female!");
                        boolean gender = gen.equals("M") ? true : false;
                        String phoneNumber = val.getAndValidPhone("Enter phone number: ");
                        String email = val.getAndValidEmail("Enter customer's email: ");
                        String level = val.getString("Enter Customer level: ");
                        String address = val.getAndValidValue("Enter Address: ", "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$",
                                "Address must be upper case first character of each word!");
                        Customer newCus = new Customer(id, fullName, dateOfBirth, identity, gender, phoneNumber, email,
                                level, address);
                        customerService.add(newCus);
                        break;
                    case 3:
                        Customer c;
                        do {
                            String inputId = val.getAndValidCusId("Enter customer ID: ");
                            c = customerService.findById(inputId);
                        } while (c == null);
                        customerService.update(c);
                        break;
                    case 4:
                        customerService.save();
                        break;
                }
            }
        };
        customerManagementMenu.run();
    }

    private void runFacilityManagementMenu() {
        String title = "FACILITY MANAGEMENT";
        String[] options = {"Add new facility", "Display facility list", "Display maintenance list",
            "Return main menu"};
        IFacilityRepository facilityRepo = new FacilityRepository();
        FacilityService facilityService = new FacilityService(facilityRepo);

        facilityManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        String idFacility;
                        do {
                            idFacility = val.getAndValidServiceCode(
                                    "Enter new facility code (SVxx-yyyy; xx: VL(villa), HO(house), RO(room); y:0-9): ");
                            if (facilityService.findById(idFacility) != null) {
                                System.out.println("Facility ID have been existed! Please enter a unique ID.");
                            }
                        } while (facilityService.findById(idFacility) != null);
                        String nameFacility = val.getAndValidValue("Enter new facility name: ",
                                "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$", "Invalid facility name. Please enter a valid name.");
                        double area = val.getAndValidDouble("Enter area: ");
                        double prices = val.getAndValidDouble("Enter rental cost: ");
                        int maxPeople = val.getAndValidInt("Enter max people: ");
                        String type = val.getString("Enter rental type (hour,day,month,year): ");

                        Facility facility = null;
                        if (idFacility.startsWith("SVVL")) {
                            String standRoom = val.getString("Enter room standroom: ");
                            double poolArea = val.getAndValidDouble("Enter pool area: ");
                            int floors = val.getAndValidInt("Enter number of floors: ");
                            facility = new Villa(idFacility, nameFacility, area, prices, maxPeople, type, standRoom,
                                    poolArea, floors);
                            facilityService.add(facility);
                        }
                        if (idFacility.startsWith("SVHO")) {
                            String standRoom = val.getString("Enter room standroom: ");
                            int floors = val.getAndValidInt("Enter number of floors: ");
                            facility = new House(idFacility, nameFacility, area, prices, maxPeople, type, standRoom,
                                    floors);
                            facilityService.add(facility);
                        }
                        if (idFacility.startsWith("SVRO")) {
                            String freeService = val.getString("Enter free service: ");
                            facility = new Room(idFacility, nameFacility, area, prices, maxPeople, type, freeService);
                            facilityService.add(facility);
                        }
                        facilityService.save();
                        break;
                    case 2:
                        facilityService.display();
                        break;
                    case 3:
                        facilityService.displayMaintenanceList();
                        facilityService.save();
                        break;
                    case 4:
                        facilityService.save();
                        break;
                }
            }
        };
        facilityManagementMenu.run();
    }

    private void runBookingManagementMenu() {
        String title = "BOOKING MANAGEMENT";
        String[] options = {"Add new booking", "Display booking list", "Create new contract", "Display contract list",
            "Edit contract information",
            "Return main menu"};
        IBookingRepository bookingRepo = new BookingRepository();
        BookingService bookingService = new BookingService(bookingRepo);
        ICustomerRepository customerRepo = new CustomerRepository();
        CustomerService customerService = new CustomerService(customerRepo);
        IFacilityRepository facilityRepo = new FacilityRepository();
        FacilityService facilityService = new FacilityService(facilityRepo);
        IContractReposibility contractRepo = new ContractPepository();
        ContractService contractService = new ContractService(contractRepo);
        facilityService.display();

        bookingManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
//                    case 1:
//                        String bookID = "BK" + (bookingRepo.readFile().size() + 1);
//                        Date bookDate = java.sql.Date.valueOf(LocalDateTime.now().toLocalDate());
//                        Date startDate;
//                        Date endDate;
//                        while (true) {
//                            startDate = java.sql.Date.valueOf(val.getAndValidDate("Enter start date: "));
//                            if (startDate.compareTo(bookDate) > 0) {
//                                break;
//                            } else {
//                                System.out.println("Invalid date range. Please enter again.");
//                            }
//                        }
//                        while (true) {
//                            endDate = java.sql.Date.valueOf(val.getAndValidDate("Enter end date: "));
//                            if (endDate.compareTo(startDate) >= 0) {
//                                break;
//                            } else {
//                                System.out.println("Invalid date range. Please enter again.");
//                            }
//                        }
//
//                        String cusID;
//                        do {
//                            cusID = val.getAndValidCusId("Enter available customer ID: ");
//                            if (customerService.findById(cusID) != null) {
//                                break;
//                            }
//                        } while (customerService.findById(cusID) == null);
//                        String serID;
//                        Facility facility = null;
//                        do {
//                            serID = val.getAndValidServiceCode("Enter available service ID: ");
//                            if (facilityService.findById(serID) != null) {
//                                facility = facilityService.findById(serID);
//                                break;
//                            }
//                        } while (facilityService.findById(serID) == null);
//
//                        if (facilityService.getMap().containsKey(facility)) {
//                            for (Booking b : bookingRepo.readFile()) {
//                                if (b.getServiceID().equals(facility != null ? facility.getFacilityID() : null)) {
//                                    if (Integer.parseInt(startDate.toString().split("-")[1]) > Integer.parseInt(
//                                            new SimpleDateFormat("dd/MM/yyyy").format(b.getEndDate()).split("/")[1])
//                                            || startDate.toString().split("-")[1].equals("01")
//                                            && new SimpleDateFormat("dd/MM/yyyy").format(b.getEndDate())
//                                                    .split("/")[1].equals("12")) {
//                                        facility.setQuantityUsing(0);
//                                        break;
//                                    }
//                                }
//                            }
//                            if (facilityService.getMap().get(facility) <= 4) {
//                                facilityService.getMap().put(facility, facilityService.getMap().get(facility) + 1);
//                            }
//                        }
//                        Booking newBooking = new Booking(bookID, bookDate, startDate, endDate, cusID, serID);
//                        bookingService.add(newBooking);
//                        facilityService.save();
//                        System.out.println("Add new Booking successfully!");
//                        break;
                    case 1:

                        String bookID = "BK" + (bookingRepo.readFile().size() + 1);
                        String contractID = "CT" + (contractRepo.readFile().size() + 1);
                        //input date
                        Date bookDate = java.sql.Date.valueOf(LocalDateTime.now().toLocalDate());
                        Date startDate;
                        Date endDate;
                        while (true) {
                            startDate = java.sql.Date.valueOf(val.getAndValidDate("Enter start date: "));
                            if (startDate.compareTo(bookDate) > 0) {
                                break;
                            } else {
                                System.out.println("Invalid date range. Please enter again.");
                            }
                        }
                        while (true) {
                            endDate = java.sql.Date.valueOf(val.getAndValidDate("Enter end date: "));
                            if (endDate.compareTo(startDate) >= 0) {
                                break;
                            } else {
                                System.out.println("Invalid date range. Please enter again.");
                            }
                        }
                        //customerID
                        String cusID;
                        do {
                            cusID = val.getAndValidCusId("Enter available customer ID: ");
                            if (customerService.findById(cusID) != null) {
                                break;
                            }
                        } while (customerService.findById(cusID) == null);

                        //input quantity person and money
                        int quantityPerson = val.getAndValidInt("Input the quantity of person: ");
                        double moneyTarget = val.getAndValidDouble("Input the money avaible: ");
                        double prePayment = 0;
                        int extraQuantityPerson = quantityPerson;
                        double extraMoneytarger = moneyTarget;

                        ArrayList<Facility> facilityList = new ArrayList<>();
                        ArrayList<Facility> list = new ArrayList<>();

                        String type = val.getAndValidValue("Input type service you want to choose (SVVL(villa), SVHO(house), SVRO(room)): ", "^SV(VL|HO|RO)", "Invalid, enter again.");

                        for (Map.Entry<Facility, Integer> entry : facilityService.getMap().entrySet()) {
                            Facility facility = entry.getKey();
                            if (facility.getFacilityID().startsWith(type)) {
                                int quantityUsing = entry.getValue();
                                int remainingCapacity = (5 - quantityUsing);
                                if (remainingCapacity > 0) {
                                    for (int i = 0; i < remainingCapacity; i++) {
                                        facilityList.add(facility);
                                    }
                                }
                            }
                        }
                        Collections.sort(facilityList, Comparator.comparing(Facility::getQuantityMax).reversed());

//                        int i = 0;
                        do {
                            list.clear();
                            quantityPerson = extraQuantityPerson;
                            moneyTarget = extraMoneytarger;
                            prePayment = 0;
//                            for (Facility fa : extraFacility) {
//                                facilityList.add(fa);
//                            }
//
//                            extraFacility.clear();
                            int i = 0;
                            do {
                                if (i >= facilityList.size()) {
                                    break; // Thoát vòng lặp nếu không còn phần tử trong facilityList
                                }
                                Facility currentFacility = facilityList.get(i);
                                if (quantityPerson < currentFacility.getQuantityMax()) {
                                    // Nếu quantityPerson nhỏ hơn quantityMax của currentFacility
                                    for (int j = 0; j < facilityList.size(); j++) {
                                        Facility a = facilityList.get(j);
                                        if (quantityPerson < a.getQuantityMax() && quantityPerson >= 0) {
                                            quantityPerson -= a.getQuantityMax();
                                            moneyTarget -= a.getPrices();
                                            prePayment += a.getPrices();
                                            list.add(a);
                                            facilityList.remove(a);
                                            j--; // Giảm chỉ số vì đã loại bỏ một phần tử
                                        }
                                    }
                                } else {
                                    // Nếu quantityPerson lớn hơn hoặc bằng quantityMax của currentFacility
                                    quantityPerson -= currentFacility.getQuantityMax();
                                    moneyTarget -= currentFacility.getPrices();
                                    prePayment += currentFacility.getPrices();
                                    list.add(currentFacility);
                                    facilityList.remove(currentFacility);
                                }
//                                i++; // Tăng chỉ số i
                            } while (quantityPerson > 0 && moneyTarget > 0);
//                            extraFacility.forEach(System.out::println);
//                            System.out.println("");
                            for (Facility a : list) {
                                System.out.printf("| %-12s | %-10s | %-5s | %-6s |%n", a.getFacilityID(), a.getFacilityName(), a.getQuantityMax(), a.getPrices());
                            }
                            System.out.printf("Total prices: %f$ %n", prePayment);

                            System.out.println("-----");
                            for (Facility f : facilityList) {
                                System.out.println(f.getFacilityID());
                            }
                            System.out.println("-----");
                        } while (!val.demand("Do you agree with this suggestion (Y/N)?"));

                        Booking newBooking = new Booking(bookID, bookDate, startDate, endDate, cusID);
                        bookingService.add(newBooking);
                        contractService.add(new Contract(contractID, cusID, bookID, prePayment, 0));
                        facilityService.save();
                        contractService.save();
                        System.out.println("Add new Booking successfully!");

                        break;
                    case 2:
                        bookingService.display();
                        break;
                    case 3:
                        bookingService.createNewContract();
                        break;
                    case 4:
                        contractService.display();
                        break;
                    case 5:
                        bookingService.updateContract();
                        break;
                    case 6:
                        contractService.save();
                        bookingService.save();
                        return;
                }

            }
        };
        bookingManagementMenu.run();
    }

    private void runPromotionManagementMenu() {
        String title = "PROMOTION MANAGEMENT";
        String[] options = {"Display customer use service", "Display customer get voucher", "Return main menu"};
        ICustomerRepository customerRepo = new CustomerRepository();
        CustomerService customerService = new CustomerService(customerRepo);
        IBookingRepository bookingRepo = new BookingRepository();
        BookingService bookingService = new BookingService(bookingRepo);
        IFacilityRepository facilityRepo = new FacilityRepository();
        FacilityService facilityService = new FacilityService(facilityRepo);
        IPromotionRepository promotionRepo = new PromotionRepository();
        PromotionService promotionService = new PromotionService(promotionRepo);

        promotionManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        Customer c = new Customer();
                        Facility f;

                        System.out.println("+------------+-------------+----------------------+");
                        System.out.printf("| %-10s | %-11s | %-20s |%n",
                                "Time", "Customer ID", "Name");
                        System.out.println("+------------+-------------+----------------------+");

                        for (Booking b : bookingRepo.readFile()) {
                            c = customerService.findById(b.getCustomerID());
                            System.out.printf("| %-10s | %-11s | %-20s |%n",
                                    new SimpleDateFormat("dd/MM/yyyy").format(b.getBookDate()), c.getID(), c.getFullName());
                            System.out.println("+------------+-------------+----------------------+");
                        }
                        break;
                    case 2:
                        ArrayList<Booking> arrayDate = new ArrayList<>();
                        for (Booking b : bookingRepo.readFile()) {
                            arrayDate.add(b);
                        }

                        Collections.sort(arrayDate, (b1, b2) -> b1.getBookDate().compareTo(b2.getBookDate()));

                        System.out.println("+------------+-----------------+-----------------+-----------------+--------------+--------------+");
                        System.out.printf("| %-10s | %-15s | %-15s | %-15s | %-12s | %-12s |%n",
                                "Booking ID", "Book date", "Start date", "End date", "Customer ID", "Service ID");
                        System.out.println("+------------+-----------------+-----------------+-----------------+--------------+--------------+");
                        for (Booking st : arrayDate) {
                            System.out.println(st.toString());
                        }
                        System.out.println("+------------+-----------------+-----------------+-----------------+--------------+--------------+");

                        int month1 = val.getAndValidInt("Input month want to arrange voucher: ");
                        int year1 = val.getAndValidInt("Input year want to arrange voucher: ");

                        ArrayList<Booking> bookingList = new ArrayList<>();

                        for (Booking b : arrayDate) {
                            if (Integer.valueOf(new SimpleDateFormat("dd/MM/yyyy").format(b.getBookDate()).split("/")[2]).equals(year1) && Integer.valueOf(new SimpleDateFormat("dd/MM/yyyy").format(b.getBookDate()).split("/")[1]).equals(month1)) {
                                bookingList.add(b);
                            }
                        }

                        int numOfVoucher50 = val.getAndValidInt("Input the quantity of voucher 50%: ");
                        int numOfVoucher20 = val.getAndValidInt("Input the quantity of voucher 20%: ");
                        int numOfVoucher10 = val.getAndValidInt("Input the quantity of voucher 10%: ");

                        Queue<Integer> voucherStack = new ArrayDeque<>();
                        Queue<Booking> bookingStack = new ArrayDeque<>();

                        for (int i = 0; i < numOfVoucher50; i++) {
                            voucherStack.add(50);
                        }
                        for (int i = 0; i < numOfVoucher20; i++) {
                            voucherStack.add(20);
                        }
                        for (int i = 0; i < numOfVoucher10; i++) {
                            voucherStack.add(10);
                        }
                        for (Booking b : bookingList) {
                            bookingStack.add(b);
                        }

                        if (bookingStack.size() > voucherStack.size()) {
                            for (int i = 0; i < bookingStack.size() - voucherStack.size(); i++) {
                                voucherStack.add(0);
                            }
                        }

                        System.out.println("+------------+----------+");
                        System.out.printf("| %-10s | %-8s |%n",
                                "Booking ", "Voucher ");
                        System.out.println("+------------+----------+");
                        TreeSet<Promotion> promotions = new TreeSet<>();

                        while (!bookingStack.isEmpty()) {
                            Booking booking = bookingStack.poll();
                            int voucher = voucherStack.poll();
                            Promotion p = new Promotion();
                            p.setDPAndNOV(voucher, booking);
                            promotions.add(p);
                            System.out.printf("| %-10s | %-8s |%n",
                                    booking.getCustomerID(), voucher + "%");
                            System.out.println("+------------+----------+");
                        }

//                        Map<Integer, Stack<Booking>> bookingYear = new HashMap<>();
//                        Map<Integer, Map<Integer, Stack<Booking>>> bookingMonth = new HashMap<>();
//
//                        for (Booking b : bookingList) {
//                            int year = Integer.parseInt(new SimpleDateFormat("dd/MM/yyyy").format(b.getBookDate()).split("/")[2]);
//                            int month = Integer.parseInt(new SimpleDateFormat("dd/MM/yyyy").format(b.getBookDate()).split("/")[1]);
//
//                            bookingYear.computeIfAbsent(year, k -> new Stack<>()).add(b);
//                            bookingMonth.computeIfAbsent(year, k -> new HashMap<>())
//                                    .computeIfAbsent(month, k -> new Stack<>())
//                                    .add(b);
//                        }
//
//                        for (Map.Entry<Integer, Stack<Booking>> entry : bookingYear.entrySet()) {
//                            Stack<Booking> booking1 = entry.getValue();
//
//                            int year = entry.getKey();
//                            System.out.println(year + ": " + booking1.size() + " students");
//                            Map<Integer, Stack<Booking>> bookingOfMonth = bookingMonth.get(year);
//
//                            for (Map.Entry<Integer, Stack<Booking>> monthEntry : bookingOfMonth.entrySet()) {
//                                int month = monthEntry.getKey();
//                                bookingStack = monthEntry.getValue();
//
//                                while (!bookingStack.isEmpty()) {
//                                    Booking booking = bookingStack.pop();
//                                    int voucher = voucherStack.pop();
//                                    System.out.println("  Booking: " + booking.getBookingID() + ", Voucher: " + voucher + "%");
//                                    Promotion p = new Promotion();
//                                    p.setDPAndNOV(voucher, booking);
//                                    promotions.add(p);
//                                }
//                            }
//                        }
//                        bookingStack.forEach(System.out::println);
                        promotionRepo.writeFile(promotions);
                        voucherStack.clear();
                        bookingStack.clear();
                        break;

                    case 3:
                        promotionService.save();
                        break;
                }
            }
        };
        promotionManagementMenu.run();
    }

    public static void main(String[] args) {
    }
}
