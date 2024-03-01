package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.TreeSet;
import model.Booking;

import model.Promotion;

public class PromotionRepository implements IPromotionRepository {
    public PromotionRepository() {
    }

    @Override
    public TreeSet<Promotion> readFile() {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(path + promotionPath));
            TreeSet<Promotion> promotionList = new TreeSet<>();
            while ((line = input.readLine()) != null) {
                String[] tokString = line.split(",");
                Promotion promotion = new Promotion(Integer.parseInt(tokString[0]), Booking.fromString(tokString[1]));
                promotionList.add(promotion);
            }
            input.close();
            return promotionList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void writeFile(TreeSet<Promotion> promotions) {
        try {
            PrintWriter w = new PrintWriter(path + promotionPath);
            for (Promotion promotion : promotions) {
                w.println(promotion.toStringWriteInFile());
            }
            w.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
