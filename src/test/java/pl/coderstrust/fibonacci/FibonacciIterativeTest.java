package pl.coderstrust.fibonacci;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciIterativeTest {

    private FibonacciIterative fibonacciIterative;

    @Before
    public void setup() {
        // given
        fibonacciIterative = new FibonacciIterative();
    }

    @Test
    public void shouldReturnMinus1ForNegativeIndex() {
        // then
        long fibonacci = fibonacciIterative.fibonacci(-5);

        // then
        assertThat(fibonacci).isEqualTo(-1);
    }

    @Test
    public void shouldReturn0ForFibonacciNumberWithIndex0() {
        // then
        long fibonacci = fibonacciIterative.fibonacci(0);

        // then
        assertThat(fibonacci).isEqualTo(0);
    }

    @Test
    public void shouldReturn1ForFibonacciNumberWithIndex1() {
        // when
        long fibonacci = fibonacciIterative.fibonacci(1);

        // then
        assertThat(fibonacci).isEqualTo(1);
    }

    @Test
    public void shouldReturn1ForFibonacciNumberWithIndex2() {
        // when
        long fibonacci = fibonacciIterative.fibonacci(2);

        // then
        assertThat(fibonacci).isEqualTo(1);
    }

    @Test
    public void shouldReturn2ForFibonacciNumberWithIndex3() {
        // when
        long fibonacci = fibonacciIterative.fibonacci(3);

        // then
        assertThat(fibonacci).isEqualTo(2);
    }

    @Test
    public void shouldReturn5ForFibonacciNumberWithIndex5() {
        // when
        long fibonacci = fibonacciIterative.fibonacci(5);

        // then
        assertThat(fibonacci).isEqualTo(5);
    }

    @Test
    public void shouldReturn55ForFibonacciNumberWithIndex10() {
        // when
        long fibonacci = fibonacciIterative.fibonacci(10);

        // then
        assertThat(fibonacci).isEqualTo(55);
    }
}
