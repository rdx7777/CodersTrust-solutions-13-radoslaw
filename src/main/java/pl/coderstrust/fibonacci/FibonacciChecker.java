package pl.coderstrust.fibonacci;

import java.util.*;

public class FibonacciChecker {

    private static Map<Long, Boolean> checkedNumbers = new HashMap<>();

    public static boolean isFibonacciNumber(long number) {
        if (number < 0 || number > 2000000000) {
            throw new IllegalArgumentException("Number out of supported range.");
        }
        if (checkedNumbers.containsKey(number)) {
            return checkedNumbers.get(number);
        }
        double sqrtPlus4 = Math.sqrt(5 * number * number + 4);
        double sqrtMinus4 = Math.sqrt(5 * number * number - 4);
        if (sqrtPlus4 == Math.round(sqrtPlus4) || sqrtMinus4 == Math.round(sqrtMinus4)) {
            checkedNumbers.put(number, true);
            return true;
        }
        checkedNumbers.put(number, false);
        return false;
    }
}
