package repository;

import java.util.ArrayList;
import model.Contract;

public interface IContractReposibility extends Repository<Contract, ArrayList<Contract>>{
    final String contractsPath = "\\data\\contract.csv";
    
    @Override
    public ArrayList<Contract> readFile();

    @Override
    public void writeFile(ArrayList<Contract> contract);

}
