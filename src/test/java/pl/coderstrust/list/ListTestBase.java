package pl.coderstrust.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public abstract class ListTestBase {

    private List<Long> list;
    private Long[] array1To5 = {1L, 2L, 3L, 4L, 5L};
    private Long[] array1To11 = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L};

    public abstract List<Long> getListType();

    @BeforeEach
    void setup() {
        list = getListType();
        Collections.addAll(list, array1To11);
    }

    @Test
    void shouldReturnCorrectListSize() {
        assertThat(list.size()).isEqualTo(11);
        Collections.addAll(list, array1To5);
        assertThat(list.size()).isEqualTo(16);
        list = getListType();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void shouldReturnTrueIfListIsEmpty() {
        list = getListType();
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldAddElementToList() {
        assertThat(list.size()).isEqualTo(11);
        assertTrue(list.add(1L));
        assertThat(list.size()).isEqualTo(12);
    }

    @Test
    void shouldCheckIfListContainsProvidedObject() {
        assertFalse(list.contains(null));
        list.add(null);
        assertTrue(list.contains(null));
        assertTrue(list.contains(5L));
        assertFalse(list.contains(0L));
    }

    @Test
    void shouldReturnListAsArray() {
        System.out.println(list.toArray());
        System.out.println(array1To11);
        assertThat(list.toArray()).isEqualTo(array1To11);
    }

    @Test
    void shouldReturnListAsArrayOfProvidedType() {
        Long[] expectedArray = list.toArray(new Long[0]);
        assertThat(expectedArray).isEqualTo(array1To11);
    }

    @Test
    void shouldClearList() {
        assertThat(list.size()).isEqualTo(11);
        list.clear();
        assertThat(list.size()).isEqualTo(0);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()), "Index cannot be greater than list size.");
    }

    @Test
    void shouldGetElementFromListWithProvidedIndex() {
        assertThat(list.get(5)).isEqualTo(6L);
    }

    @Test
    void shouldReturnIndexOfProvidedElement() {
        assertThat(list.indexOf(null)).isEqualTo(-1);
        list.add(null);
        assertThat(list.indexOf(5L)).isEqualTo(4);
        assertThat(list.indexOf(12L)).isEqualTo(-1);
        assertThat(list.indexOf(null)).isEqualTo(11);
    }

    @Test
    void shouldReturnLastIndexOfProvidedElement() {
        assertThat(list.lastIndexOf(null)).isEqualTo(-1);
        list.add(null);
        Collections.addAll(list, array1To11);
        list.add(null);
        assertThat(list.lastIndexOf(5L)).isEqualTo(16);
        assertThat(list.lastIndexOf(12L)).isEqualTo(-1);
        assertThat(list.lastIndexOf(null)).isEqualTo(23);
    }

    @Test
    void shouldSetGivenValueAtProvidedIndexInList() {
        Long exchangedValue = list.set(0, 100L);
        assertThat(exchangedValue).isEqualTo(1);
        assertThat(list.get(0)).isEqualTo(100L);
    }

    @Test
    void shouldThrowExceptionWhileSettingGivenValueAtNonExistingIndexInList() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(12, 1L));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, 1L));
    }

    @Test
    void shouldAddElementAtProvidedIndexToList() {
        assertThat(list.get(1)).isEqualTo(2L);
        assertThat(list.get(2)).isEqualTo(3L);
        list.add(1, 100L);
        assertThat(list.size()).isEqualTo(12);
        assertThat(list.get(1)).isEqualTo(100L);
        assertThat(list.get(2)).isEqualTo(2L);
    }

    @Test
    void shouldRemoveElementAtProvidedIndexFromList() {
        assertThat(list.remove(10)).isEqualTo(11L);
        assertThat(list.size()).isEqualTo(10);
        assertThat(list.remove(5)).isEqualTo(6L);
        assertThat(list.size()).isEqualTo(9);
        assertThat(list.remove(0)).isEqualTo(1L);
        assertThat(list.size()).isEqualTo(8);
    }

    @Test
    void shouldThrowExceptionWhileRemovingElementAtNonExistingIndexFromList() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(20));
    }

    @Test
    void shouldRemoveProvidedElementFromList() {
        assertTrue(list.remove(11L));
        assertThat(list.size()).isEqualTo(10);
        assertTrue(list.remove(5L));
        assertThat(list.size()).isEqualTo(9);
        assertTrue(list.remove(1L));
        assertThat(list.size()).isEqualTo(8);
        list.add(null);
        assertTrue(list.remove(null));
        assertFalse(list.remove(100L));
    }

    @Test
    void shouldReturnCorrectValueForNextAndHasNextMethodsInIterator() {
        list = getListType();
        Collections.addAll(list, array1To5);
        Iterator<Long> iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            assertTrue(iterator.hasNext());
            assertThat(iterator.next()).isEqualTo((long) (i + 1));
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    void shouldCorrectlyRemoveValueWhileUsingIterator() {
        list = getListType();
        Collections.addAll(list, array1To5);
        Iterator<Long> iterator = list.iterator();
        int j = list.size();
        for (int i = 0; i < j; i++) {
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        assertThat(list.size()).isEqualTo(0);
        assertFalse(iterator.hasNext());
    }
}
