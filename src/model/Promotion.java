package model;

import java.util.Objects;

public class Promotion implements Comparable<Promotion> {
    String voucherName;
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

    public void setDPAndNOV(int discountPercent, int numOfVoucher){
        this.discountPercent = discountPercent;
        this.numOfVoucher = numOfVoucher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Promotion )) return false;
        Promotion promotion = (Promotion) o;
        return getDiscountPercent() == promotion.getDiscountPercent() && getNumOfVoucher() == promotion.getNumOfVoucher();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiscountPercent(), getNumOfVoucher());
    }

    @Override
    public int compareTo(Promotion o) {
        if (o.discountPercent > this.discountPercent){
            return o.discountPercent;
        } else {
            return this.discountPercent;
        }
    }

    public String toStringWriteInFile() {
        return discountPercent + "," + numOfVoucher;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-15s | %n", discountPercent, numOfVoucher);
    }
}