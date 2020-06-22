package Excercise;

public class Main {

    public static void main(String[] args) {

	int[] array = SortArray.inputArray();
	int[] sortedArray = SortArray.sortArray(array);
	SortArray.printArray(array);
	SortArray.printArray(sortedArray);
    }
}
