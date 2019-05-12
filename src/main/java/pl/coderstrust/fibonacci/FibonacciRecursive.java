package pl.coderstrust.fibonacci;

public class FibonacciRecursive {

    public static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            throw new IllegalArgumentException("Fibonacci number in order cannot be lower than zero.");
        } else if (fibonacciNumberInOrder < 2) {
            return fibonacciNumberInOrder;
        }
        return fibonacci(fibonacciNumberInOrder - 2)
                + fibonacci(fibonacciNumberInOrder - 1);
    }
}
