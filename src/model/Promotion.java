package model;

import java.util.Objects;

public class Promotion implements Comparable<Promotion> {
    int discountPercent;
    Booking voucher;

    public Promotion(int discountPercent, Booking voucher) {
        this.discountPercent = discountPercent;
        this.voucher = voucher;
    }

    public Promotion(){
        
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Booking getVoucher() {
        return voucher;
    }

    public void setVoucher(Booking voucher) {
        this.voucher = voucher;
    }

    public void setDPAndNOV(int discountPercent, Booking voucher){
        this.discountPercent = discountPercent;
        this.voucher = voucher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Promotion )) return false;
        Promotion promotion = (Promotion) o;
        return getDiscountPercent() == promotion.getDiscountPercent() && getVoucher()== promotion.getVoucher();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiscountPercent(), getVoucher());
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
        return discountPercent + "," + voucher.toStringWriteInFile();
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-15s | %n", discountPercent, voucher);
    }
}