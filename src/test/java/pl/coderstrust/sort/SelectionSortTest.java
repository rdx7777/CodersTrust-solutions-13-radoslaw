package pl.coderstrust.sort;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectionSortTest {

    @Test
    public void shouldSortUniquePositiveNumbers() {
        // given
        int[] input = {3, 99, 2, 56, 43, 15, 11, 10, 1, 12, 8};
        int[] expected = {1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99};

        // when
        int[] actual = SelectionSort.sort(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldSortUniqueNegativeNumbers() {
        // given
        int[] input = {-2, -11, -3, -67, -24, -99, -5, -43};
        int[] expected = {-99, -67, -43, -24, -11, -5, -3, -2};

        // when
        int[] actual = SelectionSort.sort(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldSortUniquePositiveAndNegativeNumbers() {
        // given
        int[] input = {3, 0, -2, 99, 2, 56, 15, 12, 11, 10, -11, 43, 1, 8, -3};
        int[] expected = {-11, -3, -2, 0, 1, 2, 3, 8, 10, 11, 12, 15, 43, 56, 99};

        // when
        int[] actual = SelectionSort.sort(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldSortRepeatingNumbers() {
        // given
        int[] input = {3, 0, -2, 99, 2, 1, 3, 56, 43, 15, 12, 11, 10, -11, 43, 1, 12, 8, -3, -2};
        int[] expected = {-11, -3, -2, -2, 0, 1, 1, 2, 3, 3, 8, 10, 11, 12, 12, 15, 43, 43, 56, 99};

        // when
        int[] actual = SelectionSort.sort(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldSortTheSameNumbers() {
        // given
        int[] input = {5, 5, 5, 5, 5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5, 5, 5, 5, 5};

        // when
        int[] actual = SelectionSort.sort(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
