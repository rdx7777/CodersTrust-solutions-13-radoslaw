package pl.coderstrust.search;

class LinearSearchTest extends SearchingTestBase {

    @Override
    public SearchingMethod getSearchingMethod() {
        return new LinearSearch();
    }
}
