package pl.coderstrust.multiplication;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationTable {

    public static void main(String[] args) {
        List<String> multiplicationTable = printMultiplicationTable(3);
        for (int i = 0; i < multiplicationTable.size(); i++) {
            System.out.println(multiplicationTable.get(i));
        }
//        List<String> multiplicationTable2 = printMultiplicationTable(12);
//        for (int i = 0; i < multiplicationTable2.size(); i++) {
//            System.out.println(multiplicationTable2.get(i));
//        }
//        List<String> multiplicationTable3 = printMultiplicationTable(32);
//        for (int i = 0; i < multiplicationTable3.size(); i++) {
//            System.out.println(multiplicationTable3.get(i));
//        }
        System.out.println();
        int size = 6;
        int[][] multiplicationArray = printMultiplicationTableUsingTwoDimensionalArray(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(multiplicationArray[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static List<String> printMultiplicationTable(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Multiplication table can be printed only for numbers greater than zero.");
        }
        List<String> result = new ArrayList<>();
        StringBuilder multiplicationTable = new StringBuilder();
        String singleNumberPattern = getFormattingPatternForSingleNumber(size);
        String multiplicationPattern = getFormattingPatternForMultiplication(size);
        multiplicationTable.append(String.format(singleNumberPattern, ""));
        for (int i = 1; i <= size; i++) {
            multiplicationTable.append(String.format(multiplicationPattern, i));
        }
        result.add(multiplicationTable.toString());
        for (int i = 1; i <= size; i++) {
            multiplicationTable.setLength(0);
            multiplicationTable.append(String.format(singleNumberPattern, i));
            for (int j = 1; j <= size; j++) {
                multiplicationTable.append(String.format(multiplicationPattern, i * j));
            }
            result.add(multiplicationTable.toString());
        }
        return result;
    }

    private static String getFormattingPatternForSingleNumber(int number) {
        int width = String.valueOf(number).length();
        return "%" + width + "s";
    }

    private static String getFormattingPatternForMultiplication(int number) {
        int width = String.valueOf(number * number).length() + 1;
        return "%" + width + "s";
    }

    public static int[][] printMultiplicationTableUsingTwoDimensionalArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Multiplication table can be printed only for numbers greater than zero.");
        }
        int[][] resultArray = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                resultArray[i][j] = (i + 1) * (j + 1);
            }
        }
        return resultArray;
    }
}
