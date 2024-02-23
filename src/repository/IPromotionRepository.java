package repository;

import java.util.TreeSet;

import model.Promotion;

/**
 *
 * @author hoang hung
 */
public interface IPromotionRepository extends Repository<Promotion, TreeSet<Promotion>> {
    final String promotionPath = "\\data\\promotion.csv";

    @Override
    public TreeSet<Promotion> readFile();

    @Override
    public void writeFile(TreeSet<Promotion> promotion);
}
