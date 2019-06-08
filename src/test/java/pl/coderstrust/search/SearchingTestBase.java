package pl.coderstrust.search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class SearchingTestBase {

    public abstract SearchingMethod getSearchingMethod();

    @ParameterizedTest
    @ValueSource(ints = {1, 79, 500, 3_213, 21_111, 100_000, 1_200_000, 2_345_678, 4_999_777})
    void shouldSearch(int element) {
        // given
        int[] given = new int[5_000_000];
        for (int i = 0; i < given.length; i++) {
            given[i] = i;
        }
        System.out.print("Searched element " + element + " by <<" + getSearchingMethod().getClass() + ">> found in ");

        // when
        long startTime = System.nanoTime();
        int result = getSearchingMethod().search(given, element);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) + " nanoseconds.");

        // then
        assertThat(result).isEqualTo(element);
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 133, 5_555, 13_333, 99_777, 1_999_999, 4_999_999, 110_010_000})
    void shouldReturnMinusOneWhenElementNotFound(int element) {
        // given
        int[] given = new int[5_000_000];
        for (int i = 0; i < given.length; i++) {
            given[i] = i * 2;
        }
        System.out.print("Element " + element + " was searched by <<" + getSearchingMethod().getClass() + ">> for ");

        // when
        long startTime = System.nanoTime();
        int result = getSearchingMethod().search(given, element);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) + " nanoseconds.");

        // then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void shouldThrowExceptionForNullAsArray() {
        assertThrows(IllegalArgumentException.class, () -> getSearchingMethod().search(null, 1));
    }
}
