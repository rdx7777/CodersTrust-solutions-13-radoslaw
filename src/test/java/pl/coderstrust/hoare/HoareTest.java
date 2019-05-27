package pl.coderstrust.hoare;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class HoareTest {

    @ParameterizedTest
    @MethodSource("shouldSortArguments")
    void shouldSort(int[] input, int[] expected) {
        assertThat(Hoare.hoareQuickSort(input, 0, input.length - 1)).isEqualTo(expected);
    }

    static Stream<Arguments> shouldSortArguments() {
        return Stream.of(
                Arguments.of(new int[]{3}, new int[]{3}),
                Arguments.of(new int[]{3, 3}, new int[]{3, 3}),
                Arguments.of(new int[]{3, 4, 5, 3}, new int[]{3, 3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{3, 4, 1, 3, 2, 5, 3}, new int[]{1, 2, 3, 3, 3, 4, 5}),
                Arguments.of(new int[]{1, 7, 9, 4, 3, 2, 8, 5}, new int[]{1, 2, 3, 4, 5, 7, 8, 9}),
                Arguments.of(new int[]{2, 1, -2, 4, 13, 5, 7, 8, 4, 10, 3, 17, 9}, new int[]{-2, 1, 2, 3, 4, 4, 5, 7, 8, 9, 10, 13, 17})
        );
    }
}