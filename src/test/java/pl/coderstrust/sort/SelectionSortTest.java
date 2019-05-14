package pl.coderstrust.sort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SelectionSortTest {

    @ParameterizedTest
    @MethodSource("dataForTests")
    void shouldSort(int[] input, int[] expected) {
        assertThat(SelectionSort.sort(input)).isEqualTo(expected);
    }

    static Stream<Arguments> dataForTests() {
        int[] inputNull = {};
        int[] expectedNull = {};
        int[] inputOneElement = {1};
        int[] expectedOneElement = {1};
        int[] inputSameElements = {5, 5, 5, 5, 5, 5, 5};
        int[] expectedSameElements = {5, 5, 5, 5, 5, 5, 5};
        int[] inputAlreadySortedElements = {1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99};
        int[] expectedAlreadySortedElements = {1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99};
        int[] inputShuffledElements = {3, 99, 2, 56, 43, 15, -2, 11, 10, 1, 12, 8};
        int[] expectedShuffledElements = {-2, 1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99};
        int[] inputReverseSortedElements = {99, 56, 43, 15, 12, 11, 10, 8, 3, 2, 1};
        int[] expectedReverseSortedElements = {1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99};
        int[] inputContainingDuplicatedElements = {3, 0, -2, 99, 2, 1, 3, 56, 43, 15, 12, 11, 10, -11, 43, 1, 12, 8, -3, -2};
        int[] expectedContainingDuplicatedElements = {-11, -3, -2, -2, 0, 1, 1, 2, 3, 3, 8, 10, 11, 12, 12, 15, 43, 43, 56, 99};
        return Stream.of(Arguments.of(inputNull, expectedNull), Arguments.of(inputOneElement, expectedOneElement),
                Arguments.of(inputSameElements, expectedSameElements), Arguments.of(inputAlreadySortedElements, expectedAlreadySortedElements),
                Arguments.of(inputShuffledElements, expectedShuffledElements), Arguments.of(inputReverseSortedElements, expectedReverseSortedElements),
                Arguments.of(inputContainingDuplicatedElements, expectedContainingDuplicatedElements));
    }

    @Test
    void shouldThrowExceptionForNullAsArray() {
        assertThrows(IllegalArgumentException.class, () -> SelectionSort.sort(null));
    }
}
