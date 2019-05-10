package pl.coderstrust.pascal;

public class PascalTriangle {
    public static void main(String[] args) {
        printPascalTriangle(10);
    }

    private static void printPascalTriangle(int number) {
        long term;
        for (int n = 0; n < number; n++) {
            for (int i = n; i <= number; i++)
                System.out.print(" ".repeat(3));
            for (int k = 0; k <= n; k++) {
                term = factorial(n) / (factorial(k) * factorial(n - k));
                System.out.print(String.format("%6d", term));
            }
            System.out.println();
        }
    }

    public static long factorial(int number) {
        long factorial = 1L;
        while (number >= 1) {
            factorial *= number--;
        }
        return factorial;
    }
}
