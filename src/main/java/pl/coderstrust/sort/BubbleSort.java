package pl.coderstrust.sort;

public class BubbleSort {

    public static int[] sort(int[] array) {

        int[] sortedArray = new int[array.length];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = array[i];
        }
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 1; j < sortedArray.length; j++) {
                int a = sortedArray[j - 1];
                int b = sortedArray[j];
                if (a > b) {
                    sortedArray[j - 1] = b;
                    sortedArray[j] = a;
                }
            }
        }
        return sortedArray;
    }
}
