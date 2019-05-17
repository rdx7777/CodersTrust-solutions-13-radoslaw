package pl.coderstrust.christmastree;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTree {

    public static List<String> getChristmasTree(int size) {
        if (size < 3) {
            throw new IllegalArgumentException("Size cannot be lower than three.");
        }
        List<String> result = new ArrayList<>();
        String space = " ";
        String asterisk = "*";
        StringBuilder christmasTree = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            for (int j = size; j > i; j--) {
                christmasTree.append(space);
            }
            for (int j = 1; j < (2 * i); j++) {
                christmasTree.append(asterisk);
            }
            result.add(christmasTree.toString());
            christmasTree.setLength(0);
        }
        for (int i = 0; i < size - 1; i++) {
            christmasTree.append(space);
        }
        christmasTree.append(asterisk);
        result.add(christmasTree.toString());
        christmasTree.setLength(0);
        return result;
    }
}
