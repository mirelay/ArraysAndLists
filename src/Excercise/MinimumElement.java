package Excercise;

import java.util.Scanner;

public class MinimumElement {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter array length: ");
        int count = scanner.nextInt();

        int[] array = readIntegers(count);

        System.out.println("Minimum element is " + findMin(array));
        scanner.close();
    }

    public static int[] readIntegers(int count) {
        int[] array = new int[count];
        for(int i=0; i<count; i++) {
            System.out.println("Enter integer for position " + (i+1));
            int member = scanner.nextInt();
            array[i] = member;
        }
        scanner.close();
        return array;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for(int i=1; i<array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
