package model;

public class Promotion {
    int discountPercent;
    int numOfVoucher;

    public Promotion(int discountPercent, int numOfVoucher) {
        this.discountPercent = discountPercent;
        this.numOfVoucher = numOfVoucher;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getNumOfVoucher() {
        return numOfVoucher;
    }

    public void setNumOfVoucher(int numOfVoucher) {
        this.numOfVoucher = numOfVoucher;
    }

    public String toStringWriteInFile() {
        return discountPercent + "," + numOfVoucher;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-15s | %n", discountPercent, numOfVoucher);
    }
}