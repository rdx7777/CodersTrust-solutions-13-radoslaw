package pl.coderstrust.sieve;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SieveOfEratosthenesTest {

    @ParameterizedTest
    @MethodSource("dataForTests")
    void shouldSieve(int maximumNumber, int[] expected) {
        assertThat(SieveOfEratosthenes.sieve(maximumNumber)).isEqualTo(expected);
    }

    static Stream<Arguments> dataForTests() {
        int numberLowerThanZero = -5;
        int[] arrayExpectedForNumberLowerThanZero = new int[0];
        int numberLowerThanTwo = 1;
        int[] arrayExpectedForNumberLowerThanTwo = new int[0];
        int numberGreaterThanTwo = 100;
        int[] arrayExpectedForNumberGreaterThanTwo = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        return Stream.of(Arguments.of(numberLowerThanZero, arrayExpectedForNumberLowerThanZero),
                Arguments.of(numberLowerThanTwo, arrayExpectedForNumberLowerThanTwo),
                Arguments.of(numberGreaterThanTwo, arrayExpectedForNumberGreaterThanTwo));
    }
}
