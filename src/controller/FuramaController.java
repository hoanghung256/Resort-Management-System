package controller;

import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
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
        String[] options = {"Add new booking", "Display booking list", "Display contract list", "Delete contract by ID", "Return main menu"};
        IBookingRepository bookingRepo = new BookingRepository();
        BookingService bookingService = new BookingService(bookingRepo);
        ICustomerRepository customerRepo = new CustomerRepository();
        CustomerService customerService = new CustomerService(customerRepo);
        IFacilityRepository facilityRepo = new FacilityRepository();
        FacilityService facilityService = new FacilityService(facilityRepo);
        IContractReposibility contractRepo = new ContractPepository();
        ContractService contractService = new ContractService(contractRepo);

        bookingManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        facilityService.display();
                        String bookID = "BK" + String.format("%04d", bookingRepo.readFile().size() + 1);
                        String contractID = "CT" + String.format("%04d", contractRepo.readFile().size() + 1);
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
                        double prePayment = 0;

                        ArrayList<Facility> facilityList = new ArrayList<>();
                        ArrayList<Facility> list = new ArrayList<>();
                        ArrayList<Facility> exlist = new ArrayList<>();
                        ArrayList<String> listString = new ArrayList<>();

                        Date date1 = new Date(startDate.getYear() - 1900, startDate.getMonth() - 1, startDate.getDay()); // Lưu ý: Năm phải trừ đi 1900, tháng bắt đầu từ 0
                        Date date2 = new Date(endDate.getYear() - 1900, endDate.getMonth() - 1, endDate.getDay());
                        long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
                        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) + 1;

                        System.out.println("Choose booking method:");
                        System.out.println("1.Book according to suggestions");
                        System.out.println("2.Book based on personal preference");
                        int choe;
                        do {
                            choe = val.getAndValidInt("Input your choose: ");
                            switch (choe) {
                                case 1:
                                    int quantityPerson = val.getAndValidInt("Input the quantity of person: ");
                                    double moneyTarget = val.getAndValidDouble("Input the money avaible: ");
                                    int extraQuantityPerson = quantityPerson;
                                    double extraMoneytarger = moneyTarget;
                                    String type = val.getAndValidValue("Input type service you want to choose (SVVL(villa), SVHO(house), SVRO(room)): ", "^SV(VL|HO|RO)", "Invalid, enter again.");

                                    for (Map.Entry<Facility, Integer> entry : facilityService.getMap().entrySet()) {
                                        Facility facility = entry.getKey();
                                        if (facility.getFacilityID().startsWith(type)) {
                                            int quantityUsing = entry.getValue();
                                            int remainingCapacity = (5 - quantityUsing);
                                            if (remainingCapacity > 0) {
                                                for (int i = 0; i < remainingCapacity; i++) {
                                                    facilityList.add(facility);
                                                    exlist.add(facility);
                                                }
                                            }
                                        }
                                    }
                                    Collections.sort(facilityList, Comparator.comparing(Facility::getQuantityMax).reversed());
                                    Collections.sort(exlist, Comparator.comparing(Facility::getQuantityMax).reversed());

                                    do {
                                        list.clear();
                                        quantityPerson = extraQuantityPerson;
                                        moneyTarget = extraMoneytarger / diffInDays;
                                        prePayment = 0;
                                        int x = 0;
                                        for (Facility s : facilityList) {
                                            x += s.getQuantityMax();
                                        }
                                        if (x < 20) {
                                            for (Facility s : exlist) {
                                                facilityList.add(s);
                                            }
                                        }

                                        int i = 0;
                                        do {
                                            if (i >= facilityList.size()) {
                                                break;
                                            }
                                            Facility currentFacility = facilityList.get(i);
                                            if (quantityPerson < currentFacility.getQuantityMax()) {
                                                for (int j = 0; j < facilityList.size(); j++) {
                                                    Facility a = facilityList.get(j);
                                                    if (quantityPerson >= a.getQuantityMax()) {
                                                        quantityPerson -= a.getQuantityMax();
                                                        moneyTarget -= a.getPrices();
                                                        prePayment += a.getPrices();
                                                        list.add(a);
                                                        facilityList.remove(a);
                                                        j--;
                                                    }
                                                }
                                            } else {
                                                quantityPerson -= currentFacility.getQuantityMax();
                                                moneyTarget -= currentFacility.getPrices();
                                                prePayment += currentFacility.getPrices();
                                                list.add(currentFacility);
                                                facilityList.remove(currentFacility);
                                            }
                                        } while (quantityPerson > 0 && moneyTarget > 0);
                                        Collections.sort(list, Comparator.comparing(Facility::getFacilityID).reversed());
                                        listString = facilityService.count(list);

                                        System.out.printf("Total prices in 1 day: %.2f$ %n", prePayment);
                                        System.out.printf("Total prices: %.2f$ %n", prePayment * diffInDays);

                                    } while (!val.demand("Do you agree with this suggestion (Y/N)?"));

                                    break;
                                case 2:
                                    for (Map.Entry<Facility, Integer> entry : facilityService.getMap().entrySet()) {
                                        Facility facility = entry.getKey();
                                        int quantityUsing = entry.getValue();
                                        int remainingCapacity = (5 - quantityUsing);
                                        if (remainingCapacity > 0) {
                                            for (int i = 0; i < remainingCapacity; i++) {
                                                facilityList.add(facility);
                                                exlist.add(facility);
                                            }
                                        }
                                    }
                                    do {
                                        list.clear();
                                        int x = 0;
                                        for (Facility s : facilityList) {
                                            x += s.getQuantityMax();
                                        }
                                        if (x < 20) {
                                            for (Facility s : exlist) {
                                                facilityList.add(s);
                                            }
                                        }
                                        int person = 0;
                                        int i = 0;
                                        do {
                                            if (i >= facilityList.size()) {
                                                break;
                                            }
                                            //////////

                                            String serID;
                                            do {
                                                serID = val.getAndValidServiceCode("Enter your service ID want to book: ");
                                                if (facilityService.findById(cusID) != null) {
                                                    break;
                                                }
                                            } while (facilityService.findById(cusID) != null);

                                            for (int j = 0; j < facilityList.size(); j++) {
                                                Facility a = facilityList.get(j);
                                                if (serID.equals(a.getFacilityID())) {
                                                    person += a.getQuantityMax();
                                                    prePayment += a.getPrices();
                                                    list.add(a);
                                                    facilityList.remove(a);
                                                    j--;
                                                    break;
                                                }
                                                ///////
                                            }
                                        } while (val.demand("Do you want to countinue booking (Y/N)?"));
                                        Collections.sort(list, Comparator.comparing(Facility::getFacilityID).reversed());
                                        listString = facilityService.count(list);

                                        System.out.printf("Total prices in 1 day: %.2f$ for %d %n", prePayment, person);
                                        System.out.printf("Total prices: %.2f$ %n", prePayment * diffInDays);

                                    } while (!val.demand("Do you agree with this suggestion (Y/N)?"));

                                    break;
                                default:
                                    System.out.println("Invalid choose.");
                                    break;

                            }
                        } while (choe != 1 && choe != 2);

                        Map<String, ArrayList<Facility>> groupFacility = facilityService.countNum(list);
                        for (Map.Entry<String, ArrayList<Facility>> entry : groupFacility.entrySet()) {
                            ArrayList<Facility> facilitys = entry.getValue();
                            facilityService.getMap().put(facilitys.get(0), facilitys.size());
                        }

                        double totalPrice = prePayment * diffInDays;

                        double deposit;
                        while (true) {
                            deposit = val.getAndValidDouble("Input the deposit: ");
                            if (deposit <= totalPrice) {
                                break;
                            } else {
                                System.out.println("Invalid date range. Please enter again.");
                            }
                        }

                        Booking newBooking = new Booking(bookID, bookDate, startDate, endDate, cusID);
                        bookingService.add(newBooking);
                        contractService.add(new Contract(contractID, cusID, bookID, listString, prePayment, 0, totalPrice, deposit));
                        facilityService.save();
                        contractService.save();
                        bookingService.save();
                        System.out.println("Add new Booking successfully!");

                        break;

                    case 2:
                        bookingService.display();
                        break;
                    case 3:
                        contractService.display();
                        break;
                    case 4:
                        contractService.display();
                        contractService.deleteContractByID();
                        contractService.save();
                        break;
                    case 5:
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
        IContractReposibility contractRepo = new ContractPepository();
        ContractService contractService = new ContractService(contractRepo);
        IPromotionRepository promotionRepo = new PromotionRepository();
        PromotionService promotionService = new PromotionService(promotionRepo);

        promotionManagementMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        Customer c = new Customer();
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
                        TreeSet<Promotion> arrayPromo = promotionRepo.readFile();

                        for (Booking b : bookingRepo.readFile()) {
                            boolean hasPromo = false;
                            for (Promotion p : arrayPromo) {
                                if (b.getBookingID().equalsIgnoreCase(p.getVoucher().getBookingID())) {
                                    hasPromo = true;
                                    break;
                                }
                            }
                            if (!hasPromo) {
                                arrayDate.add(b);
                            }
                        }
                        Collections.sort(arrayDate, Comparator.comparing(Booking::getBookDate).thenComparing(Booking::getEndDate));
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
                        Booking booking = new Booking();
                        int voucher = 0;

                        while (!bookingStack.isEmpty()) {
                            booking = bookingStack.poll();
                            voucher = voucherStack.poll();
                            Promotion p = new Promotion(voucher, booking);
                            p.setDPAndNOV(voucher, booking);
                            promotions.add(p);

                            System.out.printf("| %-10s | %-8s |%n",
                                    booking.getCustomerID(), voucher + "%");
                            System.out.println("+------------+----------+");
                            for (Contract b : contractService.getContracts()) {
                                if (b.getBookingID().equals(booking.getBookingID())) {
                                    b.setVoucher(p.getDiscountPercent());
                                    b.setTotalAmount(b.getTotalAmount() - (b.getTotalAmount() * p.getDiscountPercent() / 100));
                                }
                            }
                        }

                        voucherStack.clear();
                        bookingStack.clear();
                        contractService.save();
                        promotionService.save();
                        break;

                    case 3:
                        promotionService.save();
                        break;
                }
            }
        };
        promotionManagementMenu.run();
    }

}
