package model;

import java.util.Date;

public abstract class Facility {

    private String facilityID;
    private String facilityName;
    private double area;
    private double prices;
    private int quantityMax;
    private Date type;

    public Facility(String facilityID, String facilityName, double area, double prices, int quantityMax, Date type) {
        this.facilityID = facilityID;
        this.facilityName = facilityName;
        this.area = area;
        this.prices = prices;
        this.quantityMax = quantityMax;
        this.type = type;
    }

    public Facility() {
    }

    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public int getQuantityMax() {
        return quantityMax;
    }

    public void setQuantityMax(int quantityMax) {
        this.quantityMax = quantityMax;
    }

    public Date getType() {
        return type;
    }

    public void setType(Date type) {
        this.type = type;
    }

    @Override
    public abstract String toString();

}
