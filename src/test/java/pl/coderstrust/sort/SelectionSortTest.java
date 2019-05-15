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
    @MethodSource("shouldSortArguments")
    void shouldSort(int[] input, int[] expected) {
        assertThat(SelectionSort.sort(input)).isEqualTo(expected);
    }

    static Stream<Arguments> shouldSortArguments() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{5, 5, 5, 5, 5, 5, 5}, new int[]{5, 5, 5, 5, 5, 5, 5}),
                Arguments.of(new int[]{1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99}, new int[]{1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99}),
                Arguments.of(new int[]{3, 99, 2, 56, 43, 15, -2, 11, 10, 1, 12, 8}, new int[]{-2, 1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99}),
                Arguments.of(new int[]{99, 56, 43, 15, 12, 11, 10, 8, 3, 2, 1}, new int[]{1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99}),
                Arguments.of(new int[]{1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99}, new int[]{1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99}),
                Arguments.of(new int[]{3, 0, -2, 99, 2, 1, 3, 56, 43, 15, 12, 11, 10, -11, 43, 1, 12, 8, -3, -2}, new int[]{-11, -3, -2, -2, 0, 1, 1, 2, 3, 3, 8, 10, 11, 12, 12, 15, 43, 43, 56, 99})
        );
    }

    @Test
    void shouldThrowExceptionForNullAsArray() {
        assertThrows(IllegalArgumentException.class, () -> SelectionSort.sort(null));
    }
}
