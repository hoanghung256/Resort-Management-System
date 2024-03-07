package service;

import java.util.ArrayList;
import model.Contract;
import repository.IContractReposibility;
import utils.Validation;

public class ContractService implements IContractService {

    private IContractReposibility contractRepo;
    private ArrayList<Contract> contracts;
    private Validation val = new Validation();

    public ContractService(IContractReposibility contractRepo) {
        this.contractRepo = contractRepo;
        contracts = contractRepo.readFile();
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public void add(Contract c) {
        contracts.add(c);
    }

    @Override
    public void display() {
        if (contracts.isEmpty()) {
            System.out.println("No contracts found.");
        } else {
            System.out.println("+--------------+--------------+-----------------+-----------------+");
            System.out.printf("| %-12s | %-12s | %-12s | %-15s | %-15s |%n",
                    "Contract ID", "Customer ID","Booking ID", "Pre-Payment", "Total");
            System.out.println("+--------------+--------------+-----------------+-----------------+");
            for (Contract st : contracts) {
                System.out.println(st.toString());
            }
            System.out.println("+--------------+--------------+-----------------+-----------------+");
        }
    }

    @Override
    public Contract findById(String id) {
        for (Contract b : contracts) {
            if (b.getContractID().equals(id)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public void save() {
        contractRepo.writeFile(contracts);
    }

}
