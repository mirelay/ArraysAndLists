package ArrayList;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList =  new ArrayList<String>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for(int i=0; i<groceryList.size(); i++) {
            System.out.println("Item " + (i+1) + ": " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String oldItem, String newItem) {
        int position = findItem(oldItem);
        if(position>=0) {
            modifyGroceryItem(position, newItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println(newItem + " is the new item on position " + (position+1));
    }

    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if(position>=0) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position) {
        String item = groceryList.get(position);
        groceryList.remove(position);
        System.out.println("Item " + item + " has been removed from position " + (position+1));
    }

    private int findItem(String searchItem) {
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String item) {
        int position = findItem(item);
        if(position>=0) {
            return true;
        }
        return false;
    }
}
