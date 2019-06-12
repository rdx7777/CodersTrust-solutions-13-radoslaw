package pl.coderstrust.search;

class BinarySearchTest extends SearchingTestBase {

    @Override
    public SearchingMethod getSearchingMethod() {
        return new BinarySearch();
    }
}
