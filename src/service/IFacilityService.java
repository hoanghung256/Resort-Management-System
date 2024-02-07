package service;

import model.Facility;

/**
 *
 * @author hoang hung
 */
public interface IFacilityService extends Service<Facility> {
    @Override
    Facility findById(String id);

    @Override
    void display();

    @Override
    void add(Facility f);

    void displayMaintenanceList();
    
    @Override
    void save();
}
