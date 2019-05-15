package pl.coderstrust.fibonacci;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciRecursiveTest {

    @ParameterizedTest
    @MethodSource("dataForTests")
    void shouldReturnCorrectValue(int fibonacciNumberInOrder, long expected) {
        assertThat(FibonacciRecursive.fibonacci(fibonacciNumberInOrder)).isEqualTo(expected);
    }

    static Stream<Arguments> dataForTests() {
        int firstNumber = 0;
        long firstExpected = 0L;
        int secondNumber = 1;
        long secondExpected = 1L;
        int thirdNumber = 2;
        long thirdExpected = 1L;
        int fourthNumber = 5;
        long fourthExpected = 5L;
        int fifthNumber = 10;
        long fifthExpected = 55L;
        int sixthNumber = 19;
        long sixthExpected = 4181L;
        return Stream.of(Arguments.of(firstNumber, firstExpected), Arguments.of(secondNumber, secondExpected),
                Arguments.of(thirdNumber, thirdExpected), Arguments.of(fourthNumber, fourthExpected),
                Arguments.of(fifthNumber, fifthExpected), Arguments.of(sixthNumber, sixthExpected));
    }

    @ParameterizedTest
    @MethodSource("dataForThrowExceptionTests")
    void shouldThrowExceptionForInvalidArgument(int fibonacciNumberInOrder) {
        assertThrows(IllegalArgumentException.class, () -> FibonacciRecursive.fibonacci(fibonacciNumberInOrder));
    }

    static Stream<Arguments> dataForThrowExceptionTests() {
        return Stream.of(Arguments.of(-1), Arguments.of(-20), Arguments.of(-123));
    }
}
