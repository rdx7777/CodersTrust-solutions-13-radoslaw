package pl.coderstrust.fibonacci;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciRecursiveTest {

    @Test
    public void shouldReturnCorrectValue() {
        // given
        int fibonacciNumberInOrder = 10;

        // when
        long expected = FibonacciRecursive.fibonacci(fibonacciNumberInOrder);

        // then
        assertThat(expected).isEqualTo(55);
    }

    @Test
    public void shouldThrowExceptionForInvalidArgument() {
        // given
        int fibonacciNumberInOrder = -10;

//        // when
//        FibonacciRecursive.fibonacci(fibonacciNumberInOrder);

        // then
        assertThrows(IllegalArgumentException.class, () -> FibonacciRecursive.fibonacci(fibonacciNumberInOrder));
    }
}
