package repository;

import java.util.LinkedHashMap;

import model.Facility;

/**
 *
 * @author hoang hung
 */
public interface IFacilityRepository extends Repository<Facility, LinkedHashMap<Facility, Integer>> {
    final String facilitiesPath = "\\data\\facility.csv";

    @Override
    public LinkedHashMap<Facility, Integer> readFile();

    @Override 
    public void writeFile(LinkedHashMap<Facility, Integer> facilities);
}
