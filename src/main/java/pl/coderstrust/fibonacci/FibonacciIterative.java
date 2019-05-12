package pl.coderstrust.fibonacci;

public class FibonacciIterative {

    public long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder == 0) {
            return 0;
        } else if (fibonacciNumberInOrder == 1) {
            return 1;
        } else if (fibonacciNumberInOrder < 0) {
            return -1;
        }
        long[] results = new long[fibonacciNumberInOrder + 1];
        results[0] = 0;
        results[1] = 1;
        for (int i = 2; i <= fibonacciNumberInOrder; i++) {
            results[i] = results[i - 2] + results[i - 1];
        }
        return results[fibonacciNumberInOrder];
    }
}
