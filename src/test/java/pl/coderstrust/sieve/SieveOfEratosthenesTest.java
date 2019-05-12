package pl.coderstrust.sieve;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SieveOfEratosthenesTest {

    @Test
    public void shouldReturnArrayOfPrimeNumberTill0() {
        // given
        int maximumNumber = 0;
        int[] expected = {};

        // when
        int[] actual = SieveOfEratosthenes.sieve(maximumNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnArrayOfPrimeNumberTill1() {
        // given
        int maximumNumber = 1;
        int[] expected = {};

        // when
        int[] actual = SieveOfEratosthenes.sieve(maximumNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnArrayOfPrimeNumberTill30() {
        // given
        int maximumNumber = 30;
        int[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        // when
        int[] actual = SieveOfEratosthenes.sieve(maximumNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnArrayOfPrimeNumberTill100() {
        // given
        int maximumNumber = 100;
        int[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        // when
        int[] actual = SieveOfEratosthenes.sieve(maximumNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
