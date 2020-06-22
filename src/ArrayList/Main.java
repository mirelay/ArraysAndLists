package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

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
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 to print choice options.");
        System.out.println("\t 1 to print the list of grocery items.");
        System.out.println("\t 2 to add an item to the list.");
        System.out.println("\t 3 to modify an item in the list.");
        System.out.println("\t 4 to remove the item from the list.");
        System.out.println("\t 5 to search for an item in the list.");
        System.out.println("\t 6 to quit the application.");
    }

    public static void addItem() {
        System.out.println("Please enter the grocery item ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.println("Enter item to modify: ");
        String oldItem = scanner.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(oldItem, newItem);
    }

    public static void removeItem() {
        System.out.println("Please enter item number: ");
        String item = scanner.nextLine();
        groceryList.removeGroceryItem(item);
    }

    private static void searchForItem() {
        System.out.println("Please enter the searched item: ");
        String searchedItem = scanner.nextLine();
        if(groceryList.onFile(searchedItem)) {
            System.out.println("Found " + searchedItem + " in our grocery list");
        } else {
            System.out.println(searchedItem + " is not in the shopping list");
        }
    }

    public static void  processArrayList() {
        ArrayList<String> newArray = new ArrayList<>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}
