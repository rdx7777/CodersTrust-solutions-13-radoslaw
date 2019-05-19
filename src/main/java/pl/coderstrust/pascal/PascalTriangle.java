package pl.coderstrust.pascal;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<String> getPascalTriangle(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Passed number cannot be lower than one.");
        }
        List<String> result = new ArrayList<>();
        StringBuilder pascalTriangle = new StringBuilder();
        long term;
        for (int n = 0; n < number; n++) {
            for (int i = n; i <= number; i++)
                pascalTriangle.append(" ".repeat(3));
            for (int k = 0; k <= n; k++) {
                term = factorial(n) / (factorial(k) * factorial(n - k));
                pascalTriangle.append(String.format("%6d", term));
            }
            result.add(pascalTriangle.toString());
            pascalTriangle.setLength(0);
        }
        return result;
    }

    public static long factorial(int number) {
        long factorial = 1L;
        while (number >= 1) {
            factorial *= number--;
        }
        return factorial;
    }
}
