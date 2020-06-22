package Excercise;

import java.util.Scanner;

public class ReverseArray {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = readIntegers(7);
        printArray(array);
        reverseArray(array);
        printArray(array);
    }

    public static int[] readIntegers(int count) {
        scanner = new Scanner(System.in);
        int[] array = new int[count];
        for(int i=0; i<count; i++) {
            System.out.println("Enter integer for position " + (i+1));
            int member = scanner.nextInt();
            array[i] = member;
        }
        scanner.close();
        return array;
    }

    public static void reverseArray(int[] array) {
        for(int i=0; i<array.length/2; i++) {
            int mid = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = mid;
         }
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
