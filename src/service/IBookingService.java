package service;

import model.Booking;

/**
 *
 * @author hoang hung
 */
public interface IBookingService extends Service<Booking> {
    @Override
    void add(Booking entity);

    @Override
    void display();

    @Override
    Booking findById(String id);

    void createNewContract();

    void displayContractList();

    void updateContract();

    @Override
    void save();
}
