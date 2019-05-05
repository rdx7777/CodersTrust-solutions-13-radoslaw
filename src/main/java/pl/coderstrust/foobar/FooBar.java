package pl.coderstrust.foobar;

public class FooBar {

    public static void main(String[] args) {
        printFooBar(100);
    }

    public static void printFooBar(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= number; i++) {
            stringBuilder.setLength(0);
            stringBuilder.append(i).append(" ");
            if (i % 3 == 0) {
                stringBuilder.append("Foo");
            }
            if (i % 5 == 0) {
                stringBuilder.append("Bar");
            }
            System.out.println(stringBuilder);
        }
    }
}
