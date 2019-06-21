package pl.coderstrust.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(list.remove(0));
        assertThat(list.size()).isEqualTo(11);
        assertThat(list.get(3)).isEqualTo(3);
    }

    @Test
    void shouldRemoveNullFromList() {
        list.add(null);
        assertThat(list.size()).isEqualTo(13);
        assertTrue(list.remove(null));
        assertThat(list.size()).isEqualTo(12);
    }

    @Test
    void shouldReturnFalseWhenRemoveNonExistingElementFromList() {
        assertFalse(list.remove(100));
        assertFalse(list.remove(null));
    }

    @Test
    void shouldThrowExceptionWhileRemovingElementFromEmptyList() {
        list = new MyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0), "Passed value cannot be applied to empty list.");
    }

    @Test
    void shouldAddElementAtProvidedIndexToEmptyList() {
        list = new MyLinkedList<>();
        assertTrue(list.add(0, 100));
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0)).isEqualTo(100);
    }

    @Test
    void shouldAddElementAtBeginningOfNonEmptyList() {
        assertThat(list.size()).isEqualTo(12);
        assertTrue(list.add(0, 100));
        assertThat(list.size()).isEqualTo(13);
        assertThat(list.get(0)).isEqualTo(100);
    }

    @Test
    void shouldAddElementAtEndOfNonEmptyList() {
        assertThat(list.size()).isEqualTo(12);
        assertTrue(list.add(12, 100));
        assertThat(list.size()).isEqualTo(13);
        assertThat(list.get(12)).isEqualTo(100);
    }

    @Test
    void shouldAddElementInTheMiddleOfList() {
        assertThat(list.size()).isEqualTo(12);
        assertTrue(list.add(5, 100));
        assertThat(list.size()).isEqualTo(13);
        assertThat(list.get(5)).isEqualTo(100);
        assertThat(list.get(6)).isEqualTo(4);
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
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 100), "When adding to empty list passed index cannot be different than 0.");
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

    @Test
    void shouldCheckIfListContainsProvidedElement() {
        assertTrue(list.contains(0));
        assertFalse(list.contains(100));
    }

    @Test
    void shouldReturnFalseWhileCheckingIfEmptyListContainsProvidedElement() {
        list = new MyLinkedList<>();
        assertFalse(list.contains(0));
    }
}
