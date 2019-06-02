package pl.coderstrust.fibonacci;

import java.util.*;

public class FibonacciChecker {

    private static Map<Long, Boolean> cache = new HashMap<>();

    public static boolean isFibonacciNumber(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Fibonacci number cannot be lower than zero.");
        }
        if (number > 2000000000) {
            throw new IllegalArgumentException("Number out of supported range. The maximum supported number is 2000000000.");
        }
        if (cache.containsKey(number)) {
            return cache.get(number);
        }
        long formula1 = 5 * (number * number) + 4;
        long formula2 = 5 * (number * number) - 4;
        boolean isFibonacciNumber = isPerfectSquare(formula1) || isPerfectSquare(formula2);
        cache.put(number, isFibonacciNumber);
        return isFibonacciNumber;
    }

    public static boolean isPerfectSquare(long number) {
        double root = Math.sqrt(number);
        return root == Math.round(root);
    }
}
