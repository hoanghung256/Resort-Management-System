package model;

public class Contract {

    private String contractID;
    private String cusID;
    private String bookingID;
    private double prePayment;
    private int voucher;
    private double totalAmount;

    public Contract(String contractID, String cusID, String bookingID, double prePayment, int voucher, double totalAmount) {
        this.contractID = contractID;
        this.cusID = cusID;
        this.bookingID = bookingID;
        this.prePayment = prePayment;
        this.voucher = voucher;
        this.totalAmount = totalAmount;
    }

    public Contract() {
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public double getPrePayment() {
        return prePayment;
    }

    public void setPrePayment(double prePayment) {
        this.prePayment = prePayment;
    }

    public int getVoucher() {
        return voucher;
    }

    public void setVoucher(int voucher) {
        this.voucher = voucher;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-12s | %-12s | %-11s | %-8s | %-11s |", contractID, cusID,bookingID, prePayment,voucher, totalAmount);
    }
}
