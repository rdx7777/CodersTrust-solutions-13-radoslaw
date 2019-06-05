package pl.coderstrust.comparesorting;

class SelectionSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new SelectionSort();
    }
}
