package pl.coderstrust.fibonacci;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciIterativeTest {

    @Test
    public void shouldReturnCorrectValue() {
        // given
        int fibonacciNumberInOrder = 10;

        // when
        long expected = FibonacciIterative.fibonacci(fibonacciNumberInOrder);

        // then
        assertThat(expected).isEqualTo(55);
    }

    @Test
    public void shouldThrowExceptionForInvalidArgument() {
        assertThrows(IllegalArgumentException.class, () -> FibonacciIterative.fibonacci(-10));
    }
}
