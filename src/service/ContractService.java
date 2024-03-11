package service;

import java.util.ArrayList;
import java.util.Iterator;
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

    public ContractService() {

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
            System.out.println("+--------------+--------------+--------------+-------------+----------+-------------+");
            System.out.printf("| %-12s | %-12s | %-12s | %-11s | %-8s | %-11s |%n",
                    "Contract ID", "Customer ID", "Booking ID", "Pre-Payment", "Voucher", "Total");
            System.out.println("+--------------+--------------+--------------+-------------+----------+-------------+");
            for (Contract st : contracts) {
                System.out.println(st.toString());
            }
            System.out.println("+--------------+--------------+--------------+-------------+----------+-------------+");
        }
    }

    public void deleteContractByID() {
        if (contracts.isEmpty()) {
            System.out.println("No contracts found.");
        } else {
            String contractID = val.getAndValidValue("Input the contract ID want to find: ", "^CT[0-9]{4}$", "Invalid contract ID. Please enter a valid contract ID.");
            ArrayList<Contract> listRemove = new ArrayList<>();
            for (Contract st : contracts) {
                if (contractID.equals(st.getContractID())) {
                    listRemove.add(st);
                }
            }
            contracts.removeAll(listRemove);
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
