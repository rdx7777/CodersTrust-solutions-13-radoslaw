package pl.coderstrust.multiplication;

public class MultiplicationTable {

    private static int spaceRepeater;

    public static void main(String[] args) {
        printMultiplicationTable(3);
        System.out.println();
        printMultiplicationTable(12);
        System.out.println();
        printMultiplicationTable(32);
    }

    public static void printMultiplicationTable(int size) {
        // header
        for (int i = 1; i <= size; i++) {
            printFirstRow(i, size);
        }
        System.out.print("\n".repeat(2));
        // table
        for (int i = 1; i <= size; i++) {
            printNumberInFirstColumn(i, size);
            for (int j = 1; j <= size; j++) {
                printResultOfMultiplication(i, j, size);
            }
            System.out.print("\n".repeat(2));
        }
    }

    public static void printFirstRow(int i, int size) {
        spaceRepeater = Integer.toString(size * size).length() + 2 - Integer.toString(i).length();
        switch (i) {
            case 1:
                System.out.print(String.format(" ".repeat(Integer.toString(size).length() + 1)));
                System.out.print(String.format("%s%d", " ".repeat(spaceRepeater), i));
                break;
            default:
                System.out.print(String.format("%s%d", " ".repeat(spaceRepeater), i));
        }
    }

    public static void printNumberInFirstColumn(int i, int size) {
        spaceRepeater = Integer.toString(size).length() + 1 - Integer.toString(i).length();
        System.out.print(String.format("%s%d", " ".repeat(spaceRepeater), i));
    }

    public static void printResultOfMultiplication(int i, int j, int size) {
        spaceRepeater = Integer.toString(size * size).length() + 2 - Integer.toString(i * j).length();
        System.out.print(String.format("%s%d", " ".repeat(spaceRepeater), i * j));
    }
}
