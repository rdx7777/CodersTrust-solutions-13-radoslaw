package pl.coderstrust.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyLinkedListTest {

    private MyLinkedList<Integer> list;

    @BeforeEach
    void setup() {
        list = new MyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(4);
        list.add(9);
    }

    @Test
    void shouldReturnTrueIfListIsEmpty() {
        list = new MyLinkedList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldAddElementToList() {
        list = new MyLinkedList<>();
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void shouldReturnCorrectListSize() {
        assertThat(list.size()).isEqualTo(12);
        list.add(10);
        list.add(12);
        list.add(15);
        assertThat(list.size()).isEqualTo(15);
        list = new MyLinkedList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void shouldGetElementFromListWithProvidedIndex() {
        assertThat(list.get(5)).isEqualTo(4);
    }

    @Test
    void shouldThrowExceptionWhileGettingElementFromEmptyList() {
        list = new MyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0), "Passed index cannot be applied to empty list.");
    }

    @Test
    void shouldThrowExceptionWhileGettingElementAtNonExistingIndexFromList() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1), "Passed index cannot be lower than 0.");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(20), "Passed index cannot be greater than list size.");
    }

    @Test
    void shouldRemoveProvidedElementFromList() {
        assertThat(list.size()).isEqualTo(12);
        assertFalse(list.remove(100));
        assertThat(list.size()).isEqualTo(12);
        assertThat(list.get(0)).isEqualTo(0);
        assertTrue(list.remove(0));
        assertThat(list.get(3)).isEqualTo(3);
        assertThat(list.size()).isEqualTo(11);
        assertFalse(list.remove(null));
        list.add(null);
        assertThat(list.size()).isEqualTo(12);
        assertTrue(list.remove(null));
        assertThat(list.size()).isEqualTo(11);
        assertTrue(list.remove(9));
        assertThat(list.size()).isEqualTo(10);
    }

    @Test
    void shouldThrowExceptionWhileRemovingElementFromEmptyList() {
        list = new MyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0), "Passed value cannot be applied to empty list.");
    }

    @Test
    void shouldAddElementAtProvidedIndexToList() {
        list = new MyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(1)).isEqualTo(1);
        assertThat(list.get(2)).isEqualTo(2);
        list.add(0, 50);
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0)).isEqualTo(50);
        assertThat(list.get(1)).isEqualTo(0);
        assertThat(list.get(2)).isEqualTo(1);
        assertThat(list.get(3)).isEqualTo(2);
        list.add(1, 100);
        assertThat(list.size()).isEqualTo(5);
        assertThat(list.get(1)).isEqualTo(100);
        assertThat(list.get(2)).isEqualTo(0);
        assertThat(list.get(3)).isEqualTo(1);
        assertThat(list.get(4)).isEqualTo(2);
        list.add(5, 200);
        assertThat(list.size()).isEqualTo(6);
        assertThat(list.get(5)).isEqualTo(200);
    }

    @Test
    void shouldThrowExceptionWhileAddingElementToListAtNonExistingIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 100), "Passed index cannot be lower than 0.");
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(20, 100), "Passed index cannot be greater than list size.");
    }

    @Test
    void shouldThrowExceptionWhileAddingElementToEmptyListAtForbiddenIndex() {
        list = new MyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 100), "When adding to empty list passed index cannot be different than 0.");
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(20, 100), "When adding to empty list passed index cannot be different than 0.");
    }

    @Test
    void shouldReturnCorrectValueForNextAndHasNextMethodsInIterator() {
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            assertTrue(iterator.hasNext());
            assertThat(iterator.next()).isEqualTo(list.get(i));
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    void shouldCorrectlyRemoveElementWhileUsingIterator() {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        assertThat(list.size()).isEqualTo(0);
        assertFalse(iterator.hasNext());
    }
}
