package pl.coderstrust.search;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class SearchingTestBase {

    public abstract SearchingMethod getSearchingMethod();

    private static int[] arrayToSearch;

    @BeforeAll
    private static void setup() {
        arrayToSearch = new int[6_000_000];
        for (int i = 0; i < 6_000_000; i++) {
            arrayToSearch[i] = i;
        }
    }

    @Test
    void shouldSearchFirstElement() {
        // given
        System.out.print("First element searched by <<" + getSearchingMethod().getClass() + ">> found in ");

        // when
        long startTime = System.nanoTime();
        int result = getSearchingMethod().search(arrayToSearch, 0);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) + " nanoseconds.");

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void shouldSearchMiddleElement() {
        // given
        System.out.print("Middle element searched by <<" + getSearchingMethod().getClass() + ">> found in ");

        // when
        long startTime = System.nanoTime();
        int result = getSearchingMethod().search(arrayToSearch, 2_999_999);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) + " nanoseconds.");

        // then
        assertThat(result).isEqualTo(2_999_999);
    }

    @Test
    void shouldSearchLastElement() {
        // given
        System.out.print("Last element searched by <<" + getSearchingMethod().getClass() + ">> found in ");

        // when
        long startTime = System.nanoTime();
        int result = getSearchingMethod().search(arrayToSearch, 5_999_999);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) + " nanoseconds.");

        // then
        assertThat(result).isEqualTo(5_999_999);
    }

    @Test
    void shouldSearchNotExistingElement() {
        // given
        System.out.print("Not existing element was searched by <<" + getSearchingMethod().getClass() + ">> for ");

        // when
        long startTime = System.nanoTime();
        int result = getSearchingMethod().search(arrayToSearch, 6_000_000);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) + " nanoseconds.");

        // then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void shouldThrowExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class, () -> getSearchingMethod().search(null, 1));
    }
}
