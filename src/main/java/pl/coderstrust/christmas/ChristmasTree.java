package pl.coderstrust.christmas;

public class ChristmasTree {

    public static void main(String[] args) {
        printChristmasTree(8);
    }

    public static void printChristmasTree(int size) {
        int width = 2 * size - 1;
        String space = " ";
        String star = "*";
        StringBuilder stringBuilder = new StringBuilder();
        // tree
        for (int i = 0; i < size; i++) {
            stringBuilder.setLength(0);
            for (int j = 0; j < (width - 1 - 2 * i) / 2; j++) {
                stringBuilder.append(space);
            }
            for (int j = 0; j < (2 * i + 1); j++) {
                stringBuilder.append(star);
            }
            for (int j = 0; j < (width - 1 - 2 * i) / 2; j++) {
                stringBuilder.append(space);
            }
            System.out.println(stringBuilder);
        }
        // trunk
        stringBuilder.setLength(0);
        for (int i = 0; i < (width - 1) / 2; i++) {
            stringBuilder.append(space);
        }
        stringBuilder.append(star);
        System.out.println(stringBuilder);
    }
}
