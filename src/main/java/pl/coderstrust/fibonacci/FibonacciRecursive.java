package pl.coderstrust.fibonacci;

public class FibonacciRecursive {

    public long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            return -1;
        } else if (fibonacciNumberInOrder == 0) {
            return 0;
        } else if (fibonacciNumberInOrder == 1) {
            return 1;
        }
        return fibonacci(fibonacciNumberInOrder - 2)
                + fibonacci(fibonacciNumberInOrder - 1);
    }
}
