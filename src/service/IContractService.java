package service;

import model.Contract;

public interface IContractService extends Service<Contract> {
    @Override
    void add(Contract entity);

    @Override
    void display();

    @Override
    Contract findById(String id);

    @Override
    void save();
}
