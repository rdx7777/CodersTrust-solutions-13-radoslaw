package pl.coderstrust.sort;

public class SelectionSort {

    public static int[] sort(int[] array) {
        int[] sortedArray = array.clone();
        if (sortedArray.length == 0) {
            throw new NullPointerException("Passed array can not be empty.");
        }
        for (int i = 0; i < sortedArray.length; i++) {
            int checked = sortedArray[i];
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] < checked) {
                    checked = sortedArray[j];
                    sortedArray[j] = sortedArray[i];
                    sortedArray[i] = checked;
                }
            }
        }
        return sortedArray;
    }

    // version with amendments does'n work properly

//    public static int[] sort(int[] array) {
//        int[] sortedArray = array.clone();
//        for (int i = 0; i < sortedArray.length; i++) {
//            int minimalElementPosition = i;
//            for (int j = i + 1; j < sortedArray.length; j++) {
//                if (sortedArray[j] < sortedArray[minimalElementPosition]) {
//                    minimalElementPosition = j;
//                    swapElementsInArray(sortedArray, minimalElementPosition, i);
//                }
//            }
//        }
//        return sortedArray;
//    }

    private static void swapElementsInArray(int[] array, int indexOfFirstElement, int indexOfSecondElement) {
        int temp = array[indexOfSecondElement];
        array[indexOfSecondElement] = array[indexOfFirstElement];
        array[indexOfFirstElement] = temp;
    }
}
