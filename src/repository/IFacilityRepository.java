package repository;

import java.util.ArrayList;

import model.Facility;

/**
 *
 * @author hoang hung
 */
public interface IFacilityRepository extends Repository<Facility> {
    final String facilitiesPath = "\\data\\facility.csv";

    @Override
    public ArrayList<Facility> readFile();

    @Override 
    public void writeFile(ArrayList<Facility> facilities);
}
