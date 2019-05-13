package pl.coderstrust.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectionSortTest {

    @Test
    public void shouldSort() {
        // given
        int[] input = {3, 0, -2, 99, 2, 1, 3, 56, 43, 15, 12, 11, 10, -11, 43, 1, 12, 8, -3, -2};
        int[] expected = {-11, -3, -2, -2, 0, 1, 1, 2, 3, 3, 8, 10, 11, 12, 12, 15, 43, 43, 56, 99};

        // when
        int[] actual = SelectionSort.sort(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
