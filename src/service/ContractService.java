package service;

import java.util.ArrayList;
import model.Contract;
import repository.ContractPepository;
import repository.IContractReposibility;
import utils.Validation;

public class ContractService implements IContractService {

    private FacilityService fase = new FacilityService();
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
            System.out.printf("+--------------+--------------+--------------+--------------------------------+-------------+----------+-------------+-------------+%n");
            System.out.printf("| %-12s | %-12s | %-12s | %-30s | %-11s | %-8s | %-11s | %-11s |%n",
                    "Contract ID", "Customer ID", "Booking ID", "Facility Service", "Pre-Payment", "Voucher", "Total", "Deposit");
            System.out.printf("+--------------+--------------+--------------+--------------------------------+-------------+----------+-------------+-------------+%n");
            for (Contract st : contracts) {
                System.out.println(st.toString());
                System.out.printf("+--------------+--------------+--------------+--------------------------------+-------------+----------+-------------+-------------+%n");
            }
        }
    }

//    public static void main(String[] args) {
//        IContractReposibility contractRepo = new ContractPepository();
//        ContractService con = new ContractService(contractRepo);
//        con.display();
//    }

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
