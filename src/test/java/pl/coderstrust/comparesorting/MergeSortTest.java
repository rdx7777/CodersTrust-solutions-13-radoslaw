package pl.coderstrust.comparesorting;

class MergeSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new MergeSort();
    }
}
