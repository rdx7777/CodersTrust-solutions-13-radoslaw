package pl.coderstrust.search;

public class LinearSearch implements SearchingMethod {

    @Override
    public int search(int[] array, int element) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array cannot be null.");
        }
        for (int index = 0; index < array.length; index++) {
            if (array[index] == element) {
                return index;
            }
        }
        return -1;
    }
}
