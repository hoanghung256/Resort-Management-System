package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Contract;

public class ContractPepository implements IContractReposibility {

    public ContractPepository() {
    }

    @Override
    public ArrayList<Contract> readFile() {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(path + contractsPath));
            ArrayList<Contract> conList = new ArrayList<>();
            while ((line = input.readLine()) != null) {
                String[] tokString = line.split(",");
                Contract contract = new Contract(tokString[0], tokString[1], tokString[2], Double.parseDouble(tokString[3].trim()),Integer.parseInt(tokString[4].trim()), Double.parseDouble(tokString[5].trim()));
                conList.add(contract);
            }
            return conList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void writeFile(ArrayList<Contract> contracts) {
        try {
            PrintWriter w = new PrintWriter(path + contractsPath);
            for (Contract contract : contracts) {
                String line = contract.getContractID() + "," + contract.getCusID() + "," + contract.getBookingID() + "," + contract.getPrePayment() + "," + contract.getVoucher()+","+ contract.getTotalAmount();
                w.println(line);
            }
            w.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public static void main(String[] args) {
        ContractPepository contr = new ContractPepository();
        contr.readFile();
  

    }
}
