package pl.coderstrust.multiplication;

public class MultiplicationTable {

    public static void main(String[] args) {
        printMultiplicationTable(3);
        System.out.println();
        printMultiplicationTable(12);
        System.out.println();
        printMultiplicationTable(32);
    }

    private static void printMultiplicationTable(int size) {
        String singleNumberPattern = getFormattingPatternForSingleNumber(size);
        String multiplicationPattern = getFormattingPatternForMultiplication(size);
        System.out.printf(singleNumberPattern, "");
        for (int i = 1; i <= size; i++) {
            System.out.printf(multiplicationPattern, i);
        }
        System.out.println();
        for (int i = 1; i <= size; i++) {
            System.out.printf(singleNumberPattern, i);
            for (int j = 1; j <= size; j++) {
                System.out.printf(multiplicationPattern, i * j);
            }
            System.out.println();
        }
    }

    private static String getFormattingPatternForSingleNumber(int number) {
        int width = String.valueOf(number).length();
        return "%" + width + "s";
    }

    private static String getFormattingPatternForMultiplication(int number) {
        int width = String.valueOf(number * number).length() + 1;
        return "%" + width + "s";
    }
}
