package pl.coderstrust.comparesorting;

public class QuickSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array cannot be null.");
        }
        int[] sortedArray = hoareQuickSort(array, 0, array.length - 1);
        return sortedArray;
    }

    private static int[] hoareQuickSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int p = arrayPartition(array, leftIndex, rightIndex);
            hoareQuickSort(array, leftIndex, p);
            hoareQuickSort(array, p + 1, rightIndex);
        }
        return array;
    }

    private static int arrayPartition(int[] array, int leftIndex, int rightIndex) {
        int pivotIndex = setPivotIndex(leftIndex, rightIndex);
        int pivot = array[pivotIndex];
        int i = leftIndex - 1;
        int j = rightIndex + 1;
        while (true) {
            do {
                i++;
            }
            while (array[i] < pivot);
            do {
                j--;
            }
            while (array[j] > pivot);
            if (i >= j) {
                return j;
            } else {
                swapElementsInArray(array, i, j);
            }
        }
    }

    private static int setPivotIndex(int leftIndex, int rightIndex) {
        return (leftIndex + (rightIndex - leftIndex) / 2);
    }

    private static void swapElementsInArray(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}
