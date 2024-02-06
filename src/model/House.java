package model;

public class House extends Facility {

    private String standardRoom;
    private int numFloor;

    public House(String facilityID, String facilityName, double area, double prices, int quantityMax, String type, String standardRoom, int numFloor) {
        super(facilityID, facilityName, area, prices, quantityMax, type);
        this.standardRoom = standardRoom;
        this.numFloor = numFloor;
    }

    public House() {
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(int numFloor) {
        this.numFloor = numFloor;
    }

    @Override
    public String toString() {
        return "House{" + "standardRoom=" + standardRoom + ", numFloor=" + numFloor + '}';
    }

}
