package service;

import java.util.LinkedHashMap;
import java.util.Map;
import model.Facility;
import repository.IFacilityRepository;

/**
 *
 * @author 
 */
public class FacilityService implements IFacilityService {

    private IFacilityRepository facilityRepo;
    private LinkedHashMap<Facility, Integer> facilitys;

    public FacilityService(IFacilityRepository facilityRepo) {
        this.facilityRepo = facilityRepo;
        facilitys = facilityRepo.readFile();
    }

    public LinkedHashMap<Facility, Integer> getMap(){
        return facilitys;
    }

    @Override
    public void display() {
        if (facilitys.isEmpty()) {
            System.out.println("No facilities available.");
        } else {
            System.out.println("Facility List :");
            System.out.println("+------------+----------------------+------------+------------+------------+--------------+");
            System.out.printf("| %-12s | %-20s | %-10s | %-12s | %-10s | %-12s |%n",
                    "Facility ID", "Facility Name", "Area",
                    "Rental Cost", "Max People", "Rental Type");
            System.out.println("+------------+----------------------+------------+------------+------------+--------------+");

            for (Map.Entry<Facility, Integer> entry : facilitys.entrySet()) {
                Facility facility = entry.getKey();
                int timesUsed = entry.getValue();
                System.out.printf("| %-12s | %-20s | %-10s | %-12s | %-10s | %-12s |%n",
                        facility.getFacilityID(), facility.getFacilityName(), facility.getArea(),
                        facility.getPrices(), facility.getQuantityMax(), facility.getType());
                System.out.println("Times Used: " + timesUsed);
                System.out.println("+------------+----------------------+------------+------------+------------+--------------+");
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
            System.out.println("Facility List Maintenance :");
            System.out.println("+------------+----------------------+");
            System.out.printf("| %-12s | %-20s |%n", "Facility ID", "Facility Name");
            System.out.println("+------------+----------------------+");
            for (Map.Entry<Facility, Integer> entry : facilitys.entrySet()) {
                Facility facility = entry.getKey();
                int timesUsed = entry.getValue();
                if (timesUsed == 5) {
                    System.out.printf("| %-12s | %-20s |%n",
                            facility.getFacilityID(), facility.getFacilityName());
                    System.out.println("+------------+----------------------+");
                    facility.setQuantityUsing(0);
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
            if (facility.getFacilityID().equals(id)){
                return facility;
            }
        }
        return null;
    }
}
