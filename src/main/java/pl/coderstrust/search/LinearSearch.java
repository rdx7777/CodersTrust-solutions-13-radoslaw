package pl.coderstrust.search;

public class LinearSearch implements SearchingMethod {

    @Override
    public int search(int[] array, int element) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array cannot be null.");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
