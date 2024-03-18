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
                String[] bookStrings = tokString[3].split("\\|");
                ArrayList<String> bookList = new ArrayList<>();
                for(int i = 0; i < bookStrings.length; i++){
                    bookList.add(bookStrings[i]);
                }
                Contract contract = new Contract(tokString[0], tokString[1], tokString[2], bookList,Double.parseDouble(tokString[4].trim()),Integer.parseInt(tokString[5].trim()), Double.parseDouble(tokString[6].trim()),Double.parseDouble(tokString[7].trim()));
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
                String line = contract.getContractID() + "," + contract.getCusID() + "," + contract.getBookingID() + "," + String.join("|", contract.getBook())+ "," + contract.getPrePayment() + "," + contract.getVoucher()+","+ contract.getTotalAmount() + "," + contract.getDeposit();
                w.println(line);
            }
            w.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
