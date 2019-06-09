package pl.coderstrust.list;

import java.util.List;

class MyArrayListTest extends ListTestBase{

    @Override
    public List<Long> getListType() {
        return new MyArrayList<>();
    }
}
