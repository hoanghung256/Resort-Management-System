package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import model.Facility;
import model.House;
import model.Room;
import model.Villa;

public class FacilityRepository implements IFacilityRepository {

    @Override
    public LinkedHashMap<Facility, Integer> readFile() {
        LinkedHashMap<Facility, Integer> facilityMap = new LinkedHashMap<>();

        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(path + facilitiesPath));

            while ((line = input.readLine()) != null) {
                String[] toString = line.split(",");
                if (toString.length >= 6) {
                    String id = toString[1].trim();
                    String name = toString[2].trim();
                    double area = Double.parseDouble(toString[3]);
                    double prices = Double.parseDouble(toString[4]);
                    int quantityMax = Integer.parseInt(toString[5]);
                    String type = toString[6].trim();

                    Facility facility = null;
                    //villa
                    if (id.startsWith("SVVL")) {
                        String standardVilla = toString[7].trim();
                        double poolArea = Double.parseDouble(toString[8]);
                        int numFlootVilla = Integer.parseInt(toString[9]);
                        facility = new Villa(id, name, area, prices, quantityMax, type, standardVilla, poolArea, numFlootVilla);
                    }

                    //home
                    if (id.startsWith("SVHO")) {
                        String standardHouse = toString[7].trim();
                        int numFlootHouse = Integer.parseInt(toString[8]);
                        facility = new House(id, name, area, prices, quantityMax, type, standardHouse, numFlootHouse);
                    }

                    //room
                    if (id.startsWith("SVRO")) {
                        String freeService = toString[7].trim();
                        facility = new Room(id, name, area, prices, quantityMax, type, freeService);
                    }

                    int quantityUsing = Integer.parseInt(toString[0]);
                    facilityMap.put(facility, quantityUsing);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return facilityMap;
    }

    @Override
    public void writeFile(LinkedHashMap<Facility, Integer> facilities) {

        try {
            PrintWriter pr = new PrintWriter(path + facilitiesPath);
            for (Facility facility : facilities.keySet()) {
                int quantityUsing = facilities.get(facility);
                String line = quantityUsing + "," + facility.getFacilityID() + "," + facility.getFacilityName() + "," + facility.getArea() + ","
                        + facility.getPrices() + "," + facility.getQuantityMax() + "," + facility.getType();
                if (facility instanceof Villa) {
                    Villa villa = (Villa) facility;
                    line += "," + villa.getStandardRoom() + "," + villa.getPoolArea() + "," + villa.getNumFloor();
                } else if (facility instanceof House) {
                    House house = (House) facility;
                    line += "," + house.getStandardRoom() + "," + house.getNumFloor();
                } else if (facility instanceof Room) {
                    Room room = (Room) facility;
                    line += "," + room.getFreeService();
                }

                pr.println(line);
            }
            pr.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
