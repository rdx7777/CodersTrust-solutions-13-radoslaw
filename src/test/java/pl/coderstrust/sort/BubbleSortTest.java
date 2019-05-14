package pl.coderstrust.sort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BubbleSortTest {

    @ParameterizedTest
    @MethodSource("dataForTestingEmptyArray")
    public void shouldSortEmptyArray(int[] input, int... expected) {
        assertThat(BubbleSort.sort(input)).isEqualTo(expected);
    }

    static Stream<Arguments> dataForTestingEmptyArray() {
        int[] input = {};
        int[] expected = {};
        return Stream.of(Arguments.of(input, expected));
    }

    @ParameterizedTest
    @MethodSource("dataForTestingOneElementArray")
    public void shouldSortOneElementArray(int[] input, int... expected) {
        assertThat(BubbleSort.sort(input)).isEqualTo(expected);
    }

    static Stream<Arguments> dataForTestingOneElementArray() {
        int[] input = {1};
        int[] expected = {1};
        return Stream.of(Arguments.of(input, expected));
    }

    @ParameterizedTest
    @MethodSource("dataForTestingSameElementsArray")
    public void shouldSortSameElementsArray(int[] input, int... expected) {
        assertThat(BubbleSort.sort(input)).isEqualTo(expected);
    }

    static Stream<Arguments> dataForTestingSameElementsArray() {
        int[] input = {5, 5, 5, 5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5, 5, 5, 5};
        return Stream.of(Arguments.of(input, expected));
    }

    @ParameterizedTest
    @MethodSource("dataForTestingAlreadySortedArray")
    public void shouldSortAlreadySortedArray(int[] input, int... expected) {
        assertThat(BubbleSort.sort(input)).isEqualTo(expected);
    }

    static Stream<Arguments> dataForTestingAlreadySortedArray() {
        int[] input = {1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99};
        int[] expected = {1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99};
        return Stream.of(Arguments.of(input, expected));
    }

    @ParameterizedTest
    @MethodSource("dataForTestingShuffledElementsArray")
    public void shouldSortShuffledElementsArray(int[] input, int... expected) {
        assertThat(BubbleSort.sort(input)).isEqualTo(expected);
    }

    static Stream<Arguments> dataForTestingShuffledElementsArray() {
        int[] input = {3, 99, 2, 56, 43, 15, -2, 11, 10, 1, 12, 8};
        int[] expected = {-2, 1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99};
        return Stream.of(Arguments.of(input, expected));
    }

    @ParameterizedTest
    @MethodSource("dataForTestingReverseSortedArray")
    public void shouldSortReverseSortedArray(int[] input, int... expected) {
        assertThat(BubbleSort.sort(input)).isEqualTo(expected);
    }

    static Stream<Arguments> dataForTestingReverseSortedArray() {
        int[] input = {99, 56, 43, 15, 12, 11, 10, 8, 3, 2, 1};
        int[] expected = {1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99};
        return Stream.of(Arguments.of(input, expected));
    }

    @ParameterizedTest
    @MethodSource("dataForTestingContainingDuplicatedElementsArray")
    public void shouldSortContainingDuplicatedElementsArray(int[] input, int... expected) {
        assertThat(BubbleSort.sort(input)).isEqualTo(expected);
    }

    static Stream<Arguments> dataForTestingContainingDuplicatedElementsArray() {
        int[] input = {3, 0, -2, 99, 2, 1, 3, 56, 43, 15, 12, 11, 10, -11, 43, 1, 12, 8, -3, -2};
        int[] expected = {-11, -3, -2, -2, 0, 1, 1, 2, 3, 3, 8, 10, 11, 12, 12, 15, 43, 43, 56, 99};
        return Stream.of(Arguments.of(input, expected));
    }

    @Test
    public void shouldThrowExceptionForNullAsArray() {
        assertThrows(IllegalArgumentException.class, () -> BubbleSort.sort(null));
    }
}
