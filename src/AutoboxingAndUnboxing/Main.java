package AutoboxingAndUnboxing;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();

        for(int i = 0; i < 5; i++) {
            intArrayList.add(Integer.valueOf(i));
        }

        for(int i = 0; i < intArrayList.size(); i++) {
            System.out.println("Element " + i + ": -> " + intArrayList.get(i).intValue());
        }

    }
}

