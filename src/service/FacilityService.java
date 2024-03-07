package service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import model.Facility;
import model.House;
import model.Room;
import model.Villa;
import repository.FacilityRepository;
import repository.IFacilityRepository;

public class FacilityService implements IFacilityService {

    private IFacilityRepository facilityRepo;
    private LinkedHashMap<Facility, Integer> facilitys;

    public FacilityService(IFacilityRepository facilityRepo) {
        this.facilityRepo = facilityRepo;
        facilitys = facilityRepo.readFile();
    }

    public LinkedHashMap<Facility, Integer> getMap() {
        return facilitys;
    }

    @Override
    public void display() {
        if (facilitys.isEmpty()) {
            System.out.println("No facilities available.");
        } else {
            System.out.println("Facility List :");

            System.out.println("Villa :");
            System.out.println("+-----------------+--------------+----------------------+------------+-----------------+------------+--------------+------------+--------------+------------------+-------------+");
            System.out.printf("| %-15s | %-12s | %-20s | %-10s | %-15s | %-10s | %-12s | %-10s | %-12s | %-16s | %-11s |%n",
                    "Rooms remaining", "Facility ID", "Facility Name", "Area (m^2)", "Rental Cost ($)", "Max People", "Rental Type", "Standard", "Area of pool", "Number of floors", "Status");
            System.out.println("+-----------------+--------------+----------------------+------------+-----------------+------------+--------------+------------+--------------+------------------+-------------+");
            for (Map.Entry<Facility, Integer> entry : facilitys.entrySet()) {
                Facility facility = entry.getKey();
                String status = (entry.getValue() == 5) ? "Unavailable" : "Available";
                if (facility.getFacilityID().startsWith("SVVL")) {
                    Villa villa = (Villa) facility;
                    System.out.printf("| %-15s | %-12s | %-20s | %-10s | %-15s | %-10s | %-12s | %-10s | %-12s | %-16s | %-11s |%n",
                            5 - facility.getQuantityUsing(), facility.getFacilityID(), facility.getFacilityName(), facility.getArea(),
                            facility.getPrices(), facility.getQuantityMax(), facility.getType(), villa.getStandardRoom(), villa.getPoolArea(), villa.getNumFloor(), status);
                    System.out.println("+-----------------+--------------+----------------------+------------+-----------------+------------+--------------+------------+--------------+------------------+-------------+");
                }
            }

            System.out.println("House :");
            System.out.println("+-----------------+--------------+----------------------+------------+-----------------+------------+--------------+------------+------------------+-------------+");
            System.out.printf("| %-15s | %-12s | %-20s | %-10s | %-15s | %-10s | %-12s | %-10s | %-16s | %-11s |%n",
                    "Rooms remaining", "Facility ID", "Facility Name", "Area (m^2)", "Rental Cost ($)", "Max People", "Rental Type", "Standard", "Number of floors", "Status");
            System.out.println("+-----------------+--------------+----------------------+------------+-----------------+------------+--------------+------------+------------------+-------------+");
            for (Map.Entry<Facility, Integer> entry : facilitys.entrySet()) {
                Facility facility = entry.getKey();
                String status = (entry.getValue() == 5) ? "Unavailable" : "Available";
                if (facility.getFacilityID().startsWith("SVHO")) {
                    House house = (House) facility;
                    System.out.printf("| %-15s | %-12s | %-20s | %-10s | %-15s | %-10s | %-12s | %-10s | %-16s | %-11s |%n",
                            5 - facility.getQuantityUsing(), facility.getFacilityID(), facility.getFacilityName(), facility.getArea(),
                            facility.getPrices(), facility.getQuantityMax(), facility.getType(), house.getStandardRoom(), house.getNumFloor(), status);
                    System.out.println("+-----------------+--------------+----------------------+------------+-----------------+------------+--------------+------------+------------------+-------------+");
                }
            }

            System.out.println("Room :");
            System.out.println("+-----------------+--------------+----------------------+------------+-----------------+------------+--------------+----------------------+-------------+");
            System.out.printf("| %-15s | %-12s | %-20s | %-10s | %-15s | %-10s | %-12s | %-20s | %-11s |%n",
                    "Rooms remaining", "Facility ID", "Facility Name", "Area (m^2)", "Rental Cost ($)", "Max People", "Rental Type", "Free service", "Status");
            System.out.println("+-----------------+--------------+----------------------+------------+-----------------+------------+--------------+----------------------+-------------+");
            for (Map.Entry<Facility, Integer> entry : facilitys.entrySet()) {
                Facility facility = entry.getKey();
                String status = (entry.getValue() == 5) ? "Unavailable" : "Available";
                if (facility.getFacilityID().startsWith("SVRO")) {
                    Room room = (Room) facility;
                    System.out.printf("| %-15s | %-12s | %-20s | %-10s | %-15s | %-10s | %-12s | %-20s | %-11s |%n",
                            5 - facility.getQuantityUsing(), facility.getFacilityID(), facility.getFacilityName(), facility.getArea(),
                            facility.getPrices(), facility.getQuantityMax(), facility.getType(), room.getFreeService(), status);
                    System.out.println("+-----------------+--------------+----------------------+------------+-----------------+------------+--------------+----------------------+-------------+");
                }
            }
        }
    }

    @Override
    public void add(Facility f) {
        facilitys.put(f, 0);
    }

    @Override
    public void displayMaintenanceList() {
        if (facilitys.isEmpty()) {
            System.out.println("No facilities available.");
        } else {
            ArrayList<Facility> maintenanceList = new ArrayList<>();
            for (Map.Entry<Facility, Integer> entry : facilitys.entrySet()) {
                Facility facility = entry.getKey();
                int timesUsed = entry.getValue();
                if (timesUsed == 5) {
                    maintenanceList.add(facility);
                }
            }
            if (maintenanceList.isEmpty()) {
                System.out.println("No facilities maintenance.");
            } else {
                System.out.println("Facility List Maintenance :");
                System.out.println("+----------------+----------------------+");
                System.out.printf("| %-14s | %-20s |%n", "Facility ID", "Facility Name");
                System.out.println("+----------------+----------------------+");
                for (Facility facility : maintenanceList) {
                    System.out.printf("| %-14s | %-20s |%n",
                            facility.getFacilityID(), facility.getFacilityName());
                    System.out.println("+----------------+----------------------+");
                    facilitys.put(facility, 0);
                }
            }

        }
    }

    @Override
    public void save() {
        facilityRepo.writeFile(facilitys);
    }

    @Override
    public Facility findById(String id) {
        for (Map.Entry<Facility, Integer> entry : facilitys.entrySet()) {
            Facility facility = entry.getKey();
            if (facility.getFacilityID().equals(id)) {
                return facility;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        IFacilityRepository facilityRepo = new FacilityRepository();
        FacilityService facilityService = new FacilityService(facilityRepo);
        facilityService.display();
    }

}
