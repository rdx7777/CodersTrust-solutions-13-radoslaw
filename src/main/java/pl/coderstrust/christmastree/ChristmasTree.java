package pl.coderstrust.christmastree;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTree {

    public static List<String> printChristmasTree(int size) {
        if (size < 3) {
            throw new IllegalArgumentException("Christmas Tree height cannot be lower than three.");
        }
        List<String> result = new ArrayList<>();
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
            result.add(christmasTree.toString());
        }
        // trunk
        christmasTree.setLength(0);
        for (int i = 0; i < (width - 1) / 2; i++) {
            christmasTree.append(space);
        }
        christmasTree.append(asterisk);
        result.add(christmasTree.toString());
        return result;
    }
}
