package pl.coderstrust.hoare;

public class Hoare {

    public static int[] hoareQuickSort(int[] array, int leftIndex, int rightIndex) {
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

    private static void swapElementsInArray(int[] array, int indexOfFirstElement, int indexOfSecondElement) {
        int temp = array[indexOfSecondElement];
        array[indexOfSecondElement] = array[indexOfFirstElement];
        array[indexOfFirstElement] = temp;
    }
}
