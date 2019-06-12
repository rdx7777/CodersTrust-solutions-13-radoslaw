package pl.coderstrust.search;

public class BinarySearch implements SearchingMethod {

    @Override
    public int search(int[] array, int element) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array cannot be null.");
        }
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex <= rightIndex) {
            int currentPosition = leftIndex + (rightIndex - leftIndex) / 2;
            if (array[currentPosition] == element) {
                return currentPosition;
            }
            if (array[currentPosition] < element) {
                leftIndex = currentPosition + 1;
            } else {
                rightIndex = currentPosition - 1;
            }
        }
        return -1;
    }
}
