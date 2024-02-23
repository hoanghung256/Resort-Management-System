package service;

import java.util.TreeSet;
import java.util.Stack;

import model.Promotion;
import model.Booking;
import repository.IBookingRepository;
import repository.IPromotionRepository;

public class PromotionService {

    private IPromotionRepository promotionRepo;
    private IBookingRepository bookingRepo;
    private TreeSet<Promotion> promotions;
    private Stack<Integer> voucherStack = new Stack<>();

    public PromotionService(IPromotionRepository promotionRepo) {
        this.promotionRepo = promotionRepo;
        promotions = promotionRepo.readFile();
    }

    public Stack<Integer> getStack() {
        return voucherStack;
    }

    public void display() {
        if (promotions.isEmpty()) {
            System.out.println("No voucher found.");
        } else {
            System.out.println(
                    "+------------+----------------------+------------+");
            System.out.printf("| %-10s | %-15s | %n",
                    "Discount Percent", "Number of Voucher");
            System.out.println(
                    "+------------+----------------------+------------+");
            for (Promotion p : promotions) {
                System.out.println(p.toString());
            }
            System.out.println(
                    "+------------+----------------------+------------+");
        }
    }

    public void add(Promotion p) {
        promotions.add(p);
    }

    public void save() {
        promotionRepo.writeFile(promotions);
    }
}
