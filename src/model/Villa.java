package model;

public class Villa extends Facility {

    private String standardRoom;
    private double poolArea;
    private int numFloor;

    public Villa(String facilityID, String facilityName, double area, double prices, int quantityMax, String type, String standardRoom, double poolArea, int numFloor) {
        super(facilityID, facilityName, area, prices, quantityMax, type);
        this.standardRoom = standardRoom;
        this.poolArea = poolArea;
        this.numFloor = numFloor;
    }

    public Villa() {
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(int numFloor) {
        this.numFloor = numFloor;
    }

    @Override
    public String toString() {
        return "Villa{" + "standardRoom=" + standardRoom + ", poolArea=" + poolArea + ", numFloor=" + numFloor + '}';
    }

}
