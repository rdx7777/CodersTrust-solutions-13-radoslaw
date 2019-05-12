package pl.coderstrust.sort;

public class SelectionSort {

    public static int[] sort(int[] array) {

        int[] sortedArray = new int[array.length];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = array[i];
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
}
