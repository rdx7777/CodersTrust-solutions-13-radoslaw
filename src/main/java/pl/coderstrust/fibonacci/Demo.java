package pl.coderstrust.fibonacci;

public class Demo {

    public static void main(String[] args) {
        long[] numbersForCheck = new long[]{3, 4, 5, 8, 13, 15, 2, 4, 19, 21, 40, 99, 5, 300, 987, 15, 1597, 6400, 13, 6765, 12111, 1999999999};
        for (long number : numbersForCheck) {
            System.out.println(number + " -> " + FibonacciChecker.isFibonacciNumber(number));
        }
    }
}
