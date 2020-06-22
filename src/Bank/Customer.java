package Bank;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Double> transactions;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.transactions = new ArrayList<Double>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getTransaction() {
        return transactions;
    }

    public void createTransaction(double transactionAmount) {
        transactions.add(transactionAmount);
        System.out.println("Transaction of $" + transactionAmount + " created!");
    }

    public void print(boolean printTransactions) {
        System.out.println("Customer: " + customerName);
        if(printTransactions) {
            for(int i = 0; i < transactions.size(); i++) {
                double transactionAmount = transactions.get(i);
                String details;
                if(transactionAmount < 0) {
                    details = "Outbound transaction of ";
                } else {
                    details = "Inbound transaction of ";
                }
                System.out.println(details + "$" + transactionAmount);
            }
        }
    }

}
