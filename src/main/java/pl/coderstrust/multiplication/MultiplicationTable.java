package pl.coderstrust.multiplication;

public class MultiplicationTable {

    public static void main(String[] args) {

        printMultiplicationTable(3);
        System.out.println();
        printMultiplicationTable(9);
        System.out.println();
        printMultiplicationTable(12);
    }

    public static void printMultiplicationTable(int size) {

        String space = " ";
        int product;
        int sizeSpacing = Integer.toString(size*size).length();
        StringBuilder stringBuilder = new StringBuilder();
        if (size < 1 || size > 12) {
            System.out.println("Sorry!");
        } else {
            // first row
            stringBuilder.append(beginningOfTheLine(1, space));
            for (int i = 1; i < size + 1; i++) {
                stringBuilder.append(spaceBetweenProducts(i, space, sizeSpacing)).append(i);
            }
            System.out.println(stringBuilder);
            // multiplication table
            for (int i = 1; i <= size; i++) {
                stringBuilder.setLength(0);
                stringBuilder.append(beginningOfTheLine(i + 1, space));
                for (int j = 1; j <= size; j++) {
                    product = (i) * j;
                    stringBuilder.append(spaceBetweenProducts(product, space, sizeSpacing)).append(product);
                }
                System.out.println(stringBuilder);
            }
        }
    }

    public static String beginningOfTheLine(int number, String space) {

        StringBuilder stringBuilder = new StringBuilder();
        int counter = 3 - Integer.toString(number - 1).length();
        for (int i = counter; i > 0; i--) {
            stringBuilder.append(space);
        }
        if (number == 1) {
            stringBuilder.append(" ");
        } else {
            stringBuilder.append(number - 1);

        }
        return stringBuilder.toString();
    }

    public static String spaceBetweenProducts(int product, String space, int sizeSpacing) {

        int counter = sizeSpacing + 2 - Integer.toString(product).length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = counter; i > 0; i--) {
            stringBuilder.append(space);
        }
        return stringBuilder.toString();
    }
}
