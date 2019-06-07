package pl.coderstrust.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayUtilsTest {

    @ParameterizedTest
    @MethodSource("arrayUtilsArguments")
    void shouldSwapElementsInArray(int[] input, int indexOfFirstElement, int indexOfSecondElement, int[] expected) {
        ArrayUtils.swapElementsInArray(input, indexOfFirstElement, indexOfSecondElement);
        assertArrayEquals(input, expected);
    }

    static Stream<Arguments> arrayUtilsArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, 3, new int[]{1, 2, 4, 3, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 0, 4, new int[]{5, 2, 3, 4, 1}),
                Arguments.of(new int[]{1, 3, 3, 3, 3, 3, 4, 7, 6, 10}, 1, 2, new int[]{1, 3, 3, 3, 3, 3, 4, 7, 6, 10}),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0}, 0, 5, new int[]{0, 0, 0, 0, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("invalidArrayUtilsArguments")
    void shouldThrowExceptionForInvalidArguments(int[] input, int indexOfFirstElement, int indexOfSecondElement) {
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.swapElementsInArray(input, indexOfFirstElement, indexOfSecondElement));
    }

    static Stream<Arguments> invalidArrayUtilsArguments() {
        return Stream.of(
                Arguments.of(null, 1, 2),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, -1, 3),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, 5),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, -2, 4),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 1, 7),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, -1, -1),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 6, 7),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, -1, 7)
        );
    }
}
