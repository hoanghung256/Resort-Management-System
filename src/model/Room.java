package model;

public class Room extends Facility {

    private String freeService;

    public Room(String facilityID, String facilityName, double area, double prices, int quantityMax, String type, String freeService) {
        super(facilityID, facilityName, area, prices, quantityMax, type);
        this.freeService = freeService;
    }

    public Room() {
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" + "freeService=" + freeService + '}';
    }

}
