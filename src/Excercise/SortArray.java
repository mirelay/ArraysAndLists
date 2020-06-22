package Excercise;

import java.util.Scanner;

public class SortArray {

    public static int[] sortArray(int[] array) {
        for(int j=0; j<array.length-1; j++) {
            int maxPosition = j;
            int maxValue = array[j];

            for (int i = j+1; i < array.length; i++) {
                if (array[i] > maxValue) {
                    maxValue = array[i];
                    maxPosition = i;
                }
            }
            array[maxPosition] = array[j];
            array[j] = maxValue;
        }
        return array;
    }

    public static int[] inputArray() {
        boolean inputInteger = false;
        Scanner scanner = new Scanner(System.in);
        int arrayLength=0;
        while(!inputInteger) {
            System.out.println("Enter array length between 5 and 10");
            if(scanner.hasNextInt()) {
                arrayLength = scanner.nextInt();
                if(arrayLength>4 && arrayLength<=10) {
                    inputInteger=true;
                }
            } else {
                System.out.println("Enter only integers between 5 and 10");
            }
            scanner.nextLine();
        }

        int[] inputArray = new int[arrayLength];

        int count = 1;
        while (count<=arrayLength) {
            System.out.println("Input integer for position " + count);
            if(scanner.hasNextInt()) {
                int arrayElement = scanner.nextInt();
                inputArray[count-1] = arrayElement;
                count++;
            } else {
                System.out.println("Input only integers!");
            }
            scanner.nextLine();
        }
        scanner.close();
        return inputArray;
    }

    public static void printArray(int[] array) {
        for(int i=0; i<array.length; i++) {
            if(i==array.length-1) {
                System.out.print(array[i] + ";" + "\n");
            } else {
                System.out.print(array[i] + ",");
            }
        }
    }
}
