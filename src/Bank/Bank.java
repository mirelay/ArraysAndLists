package Bank;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branchList;
    private static Bank bankObject = null;

    public Bank(String name) {
        this.name = name;
        this.branchList = new ArrayList<Branch>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    public static Bank getBankObject(String name) {
        if(bankObject == null) {
            return new Bank(name);
        }
        return bankObject;
    }

    public void addBranch(String branchName) {
        if(findBranch(branchName) == null) {
            branchList.add(new Branch(branchName));
            System.out.println("New branch " + branchName + " successfully created!");
        } else {
            System.out.println("Branch " + branchName + " already exists!");
        }
    }

    public Branch findBranch(String branchName) {
        for(int i = 0; i < branchList.size(); i++) {
            Branch branch = branchList.get(i);
            if(branch.getBranchName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public Customer findCustomer(String customerName) {
        for(int i = 0; i < branchList.size(); i++) {
            Branch branch = branchList.get(i);
            for(int j = 0; j < branch.getCustomers().size(); j++) {
                Customer customer = branch.getCustomers().get(j);
                if(customer.getCustomerName().equals(customerName)) {
                    return customer;
                }
            }
        }
        return null;
    }
}
