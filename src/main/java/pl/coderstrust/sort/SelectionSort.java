package pl.coderstrust.sort;

public class SelectionSort {

    public static int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array can not be null.");
        }
        int[] sortedArray = array.clone();
        for (int i = 0; i < sortedArray.length; i++) {
            int minimalElementPosition = i;
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] < sortedArray[minimalElementPosition]) {
                    minimalElementPosition = j;
                }
            }
            swapElementsInArray(sortedArray, minimalElementPosition, i);
        }
        return sortedArray;
    }

    private static void swapElementsInArray(int[] array, int indexOfFirstElement, int indexOfSecondElement) {
        int temp = array[indexOfSecondElement];
        array[indexOfSecondElement] = array[indexOfFirstElement];
        array[indexOfFirstElement] = temp;
    }
}
