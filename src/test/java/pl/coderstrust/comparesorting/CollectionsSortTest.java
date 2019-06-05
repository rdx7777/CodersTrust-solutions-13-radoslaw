package pl.coderstrust.comparesorting;

class CollectionsSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new CollectionsSort();
    }
}
