package pl.coderstrust.fibonacci;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciRecursiveTest {

    private FibonacciRecursive fibonacciRecursive;

    @Before
    public void setup() {
        // given
        fibonacciRecursive = new FibonacciRecursive();
    }

    @Test
    public void shouldReturnMinus1ForNegativeIndex() {
        // then
        long fibonacci = fibonacciRecursive.fibonacci(-5);

        // then
        assertThat(fibonacci).isEqualTo(-1);
    }

    @Test
    public void shouldReturn0ForFibonacciNumberWithIndex0() {
        // then
        long fibonacci = fibonacciRecursive.fibonacci(0);

        // then
        assertThat(fibonacci).isEqualTo(0);
    }

    @Test
    public void shouldReturn1ForFibonacciNumberWithIndex1() {
        // when
        long fibonacci = fibonacciRecursive.fibonacci(1);

        // then
        assertThat(fibonacci).isEqualTo(1);
    }

    @Test
    public void shouldReturn1ForFibonacciNumberWithIndex2() {
        // when
        long fibonacci = fibonacciRecursive.fibonacci(2);

        // then
        assertThat(fibonacci).isEqualTo(1);
    }

    @Test
    public void shouldReturn2ForFibonacciNumberWithIndex3() {
        // when
        long fibonacci = fibonacciRecursive.fibonacci(3);

        // then
        assertThat(fibonacci).isEqualTo(2);
    }

    @Test
    public void shouldReturn5ForFibonacciNumberWithIndex5() {
        // when
        long fibonacci = fibonacciRecursive.fibonacci(5);

        // then
        assertThat(fibonacci).isEqualTo(5);
    }

    @Test
    public void shouldReturn55ForFibonacciNumberWithIndex10() {
        // when
        long fibonacci = fibonacciRecursive.fibonacci(10);

        // then
        assertThat(fibonacci).isEqualTo(55);
    }
}
