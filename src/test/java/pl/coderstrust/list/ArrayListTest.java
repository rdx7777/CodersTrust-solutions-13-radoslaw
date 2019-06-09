package pl.coderstrust.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest extends ListTestBase {

    @Override
    public List<Long> getListType() {
        return new ArrayList<>();
    }
}
