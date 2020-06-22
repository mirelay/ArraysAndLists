package Bank;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getBranchName() {
        return branchName;
    }

    private void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean addCustomer(String customerName, double initialTransaction) {
        if(findCustomer(customerName) == null) {
            Customer customer = new Customer(customerName);
            addCustomer(customer);
            System.out.println("Customer " + customerName + " successfully created!");
            customer.createTransaction(initialTransaction);
            return true;
        } else {
            System.out.println("Customer " + customerName + " already exists!");
            return false;
        }
    }

    public boolean createTransaction(String customerName, double transactionAmount) {
        Customer customer = findCustomer(customerName);
        if(customer != null) {
            customer.createTransaction(transactionAmount);
            return true;
        } else {
            System.out.println("Customer " + customerName + " does not exist!");
            return false;
        }
    }

    private Customer findCustomer(String customerName) {
        for(int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if(customer.getCustomerName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }

    public void printCustomers(boolean printTransactions) {
        for(int i = 0; i < customers.size(); i++) {
            customers.get(i).print(printTransactions);
        }
    }
}
