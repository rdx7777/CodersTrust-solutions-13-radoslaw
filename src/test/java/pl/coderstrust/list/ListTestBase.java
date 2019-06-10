package pl.coderstrust.list;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class ListTestBase {

    private Long[] array1To5 = {1L, 2L, 3L, 4L, 5L};
    private Long[] array1To11 = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L};

    public abstract List<Long> getListType();

    @Test
    void shouldReturnCorrectListSize() {
        List<Long> list = getListType();
        Collections.addAll(list, array1To11);
        assertThat(list.size()).isEqualTo(11);
        Collections.addAll(list, array1To5);
        assertThat(list.size()).isEqualTo(16);
    }

    @Test
    void shouldReturnTrueIfListIsEmpty() {
        List<Long> list = getListType();
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldAddElementToList() {
        List<Long> list = getListType();
        assertTrue(list.add(1L));
        assertThat(list.size()).isEqualTo(1);
        Collections.addAll(list, array1To11);
        assertThat(list.size()).isEqualTo(12);
    }

    @Test
    void shouldCheckIfListContainsProvidedObject() {
        List<Long> list = getListType();
        Collections.addAll(list, array1To11);
        assertFalse(list.contains(null));
        list.add(null);
        assertTrue(list.contains(5L));
        assertFalse(list.contains(122L));
        assertFalse(list.contains(5d));
        assertFalse(list.contains(5));
        assertFalse(list.contains("example string"));
        assertFalse(list.contains(0L));
        assertTrue(list.contains(null));
    }

    @Test
    // WHY is this test working ???????????????????????????????????
    void shouldReturnListAsArray() {
        List<Long> list = getListType();
        for (int i = 0; i < array1To11.length; i++) {
            list.add(array1To11[i]);
        }
//        Collections.addAll(list, array1To11);
        // line below is NOT WORKING ******************************
//        Long[] arrayOfLongs = (Long[]) list.toArray();
        System.out.println(list.toArray()); // Object...
        System.out.println(array1To11); // Long...
        assertThat(list.toArray()).isEqualTo(array1To11);
//        assertThat(arrayOfLongs).isEqualTo(array1To11);
    }

    @Test
    void shouldReturnListAsArrayOfProvidedType() {
        List<Long> list = getListType();
        Collections.addAll(list, array1To11);
//        String[] stringArray1To11 = new String[array1To11.length];
//        for (int i = 0; i < array1To11.length; i++) {
//            stringArray1To11[i] = array1To11[i].toString();
//        }
//        System.out.println(Arrays.asList(stringArray1To11));
//        String[] expectedArray = new String[list.size()];
//        String[] expectedArray = new String[0];
        Long[] expectedArray = new Long[0];
        expectedArray = list.toArray(expectedArray);
//        assertThat(expectedArray).isEqualTo(stringArray1To11);
        assertThat(expectedArray).isEqualTo(array1To11);
    }

    @Test
    void shouldClearList() {
        List<Long> list = getListType();
        Collections.addAll(list, array1To11);
        assertThat(list.size()).isEqualTo(11);
        System.out.println(list.get(0)); // ***** to be deleted
        list.clear();
        assertThat(list.size()).isEqualTo(0); // ***** to be deleted ***** or not ???????????????
        System.out.println(list.size()); // ***** to be deleted
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
    }

    @Test
    void shouldGetElementFromListWithProvidedIndex() {
        List<Long> list = getListType();
        Collections.addAll(list, array1To11);
        assertThat(list.get(5)).isEqualTo(6L);
    }

    @Test
    void shouldReturnIndexOfProvidedElement() {
        List<Long> list = getListType();
        Collections.addAll(list, array1To11);
        list.add(null);
        assertThat(list.indexOf(5L)).isEqualTo(4);
        assertThat(list.indexOf(12L)).isEqualTo(-1);
        assertThat(list.indexOf(null)).isEqualTo(11);
    }

    @Test
    void shouldReturnLastIndexOfProvidedElement() {
        List<Long> list = getListType();
        Collections.addAll(list, array1To11);
        assertThat(list.lastIndexOf(null)).isEqualTo(-1);
        list.add(null);
        Collections.addAll(list, array1To11);
        list.add(null);
        assertThat(list.lastIndexOf(5L)).isEqualTo(16);
        assertThat(list.lastIndexOf(12L)).isEqualTo(-1);
        assertThat(list.lastIndexOf(null)).isEqualTo(23);
    }
}
