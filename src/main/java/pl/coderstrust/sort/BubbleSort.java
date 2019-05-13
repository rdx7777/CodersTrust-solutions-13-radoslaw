package pl.coderstrust.sort;

public class BubbleSort {

    public static int[] sort(int[] array) {
        int[] sortedArray = array.clone();
        if (sortedArray.length == 0) {
            throw new NullPointerException("Passed array can not be empty.");
        }
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 1; j < sortedArray.length; j++) {
                if (sortedArray[j - 1] > sortedArray[j]) {
                    swapElementsInArray(sortedArray, j - 1, j);
                }
            }
        }
        return sortedArray;
    }

    private static void swapElementsInArray(int[] array, int indexOfFirstElement, int indexOfSecondElement) {
        int temp = array[indexOfSecondElement];
        array[indexOfSecondElement] = array[indexOfFirstElement];
        array[indexOfFirstElement] = temp;
    }
}
