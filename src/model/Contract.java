package model;

import java.util.ArrayList;

public class Contract {

    private String contractID;
    private String cusID;
    private String bookingID;
    private ArrayList<String> book;
    private double prePayment;
    private int voucher;
    private double totalAmount;
    private double deposit;

    public Contract(String contractID, String cusID, String bookingID, ArrayList<String> book, double prePayment, int voucher, double totalAmount, double deposit) {
        this.contractID = contractID;
        this.cusID = cusID;
        this.bookingID = bookingID;
        this.book = book;
        this.prePayment = prePayment;
        this.voucher = voucher;
        this.totalAmount = totalAmount;
        this.deposit = deposit;
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

    public ArrayList<String> getBook() {
        return book;
    }

    public void setBook(ArrayList<String> book) {
        this.book = book;
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

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-12s | %-12s | %-30s | %-11s | %-8s | %-11s | %-11s |", contractID, cusID,bookingID, book,prePayment,voucher, totalAmount, deposit);
    }
}
