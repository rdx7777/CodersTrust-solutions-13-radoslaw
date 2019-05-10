package pl.coderstrust.christmastree;

public class ChristmasTree {

    public static void main(String[] args) {
        printChristmasTree(8);
    }

    public static void printChristmasTree(int size) {
        int width = 2 * size - 1;
        String space = " ";
        String asterisk = "*";
        StringBuilder christmasTree = new StringBuilder();
        // tree
        for (int i = 0; i < size; i++) {
            christmasTree.setLength(0);
            for (int j = 0; j < (width - 1 - 2 * i) / 2; j++) {
                christmasTree.append(space);
            }
            for (int j = 0; j < (2 * i + 1); j++) {
                christmasTree.append(asterisk);
            }
            System.out.println(christmasTree);
        }
        // trunk
        christmasTree.setLength(0);
        for (int i = 0; i < (width - 1) / 2; i++) {
            christmasTree.append(space);
        }
        christmasTree.append(asterisk);
        System.out.println(christmasTree);
    }
}
