package Bank;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = Bank.getBankObject("United Bulgarian Bank");

    public static void main (String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    createBank();
                    break;
                case 2:
                    createBranch();
                    break;
                case 3:
                    createCustomer();
                    break;
                case 4:
                    createTransaction();
                    break;
                case 5:
                    printCustomers();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
        scanner.close();
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 to print choice options.");
        System.out.println("\t 1 to create a Bank.");
        System.out.println("\t 2 to create a Branch.");
        System.out.println("\t 3 to create a Customer.");
        System.out.println("\t 4 to create a transaction for a Customer.");
        System.out.println("\t 5 to print Customers list.");
        System.out.println("\t 6 to quit the application.");
    }

    public static void createBank() {
        System.out.println("Enter a Bank name: ");
        String bankName = scanner.nextLine();
        new Bank(bankName);
    }

    public static void createBranch() {
        System.out.println("Enter a Branch name: ");
        String branchName = scanner.nextLine();
        bank.addBranch(branchName);
    }

    public static void createCustomer() {

        boolean branchSelected = false;
        while (!branchSelected) {
            System.out.println("Select branch: ");
            String branchName = scanner.nextLine();
            Branch branch = bank.findBranch(branchName);
            if(branch != null) {
                System.out.println("Enter Customer name: ");
                String customerName = scanner.nextLine();
                System.out.println("Enter initial transaction: ");
                Double transaction = scanner.nextDouble();
                scanner.nextLine();
                if(branch.addCustomer(customerName, transaction)) {
                    branchSelected = true;                } else {
                    System.out.println("Customer not created!");
                }
            } else {
                System.out.println("Branch " + branchName + " not found! Enter correct branch name!");
            }
        }
    }

    public static void createTransaction() {
        boolean customerSelected = false;
        while (!customerSelected) {
            System.out.println("Enter Customer name: ");
            String customerName = scanner.nextLine();
            Customer customer = bank.findCustomer(customerName);
            if(customer != null) {
                System.out.println("Enter transaction amount: ");
                Double transaction = scanner.nextDouble();
                scanner.nextLine();
                customer.createTransaction(transaction);
                customerSelected = true;
            } else {
                System.out.println("Customer not found!");
            }
        }
    }

    public static void printCustomers() {
        boolean branchSelected = false;
        while (!branchSelected) {
            System.out.println("Select branch: ");
            String branchName = scanner.nextLine();
            Branch branch = bank.findBranch(branchName);
            if(branch != null) {
                branchSelected = true;
                boolean printTransDetails;
                System.out.println("Select 'Yes' or 'No' to print transaction details");
                String printTransactionDetails = scanner.nextLine();
                if(printTransactionDetails.equals("Yes")) {
                    printTransDetails = true;
                } else {
                    printTransDetails = false;
                }
                branch.printCustomers(printTransDetails);
            } else {
                System.out.println("Branch " + branchName + " not found! Enter correct branch name!");
            }
        }
    }
}
