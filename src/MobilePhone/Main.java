package MobilePhone;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main (String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
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
        System.out.println("\t 1 to print the Contact list.");
        System.out.println("\t 2 to add a Contact to the list.");
        System.out.println("\t 3 to modify a Contact in the list.");
        System.out.println("\t 4 to remove Contact from the list.");
        System.out.println("\t 5 to search for a Contact in the list.");
        System.out.println("\t 6 to quit the application.");
    }

    public static void addContact() {
        System.out.println("Please, enter Name and Phone number:");
        mobilePhone.addContact(scanner.nextLine(), scanner.nextLine());
    }

    public static void removeContact() {
        System.out.println("Please, enter the name of the Contact to be removed:");
        mobilePhone.removeContact(scanner.nextLine());
    }

    public static void modifyContact() {
        System.out.println("Please, enter Contact name and phone number to be updated:");
        mobilePhone.modifyContact(scanner.nextLine(), scanner.nextLine());
    }

    public static void searchContact() {
        System.out.println("Please, enter Contact name:");
        mobilePhone.returnContact(scanner.nextLine());
    }
}
