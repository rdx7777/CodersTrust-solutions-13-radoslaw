package pl.coderstrust.foobar;

public class FooBar {

    public static void printFooBar(int number) {

        for (int i = 0; i <= number; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i + " ");
            if (i % 3 == 0) {
                stringBuilder.append("Foo");
            }
            if (i % 5 == 0) {
                stringBuilder.append("Bar");
            }
            System.out.println(stringBuilder);
        }
    }

    public static void main(String[] args) {

        printFooBar(100);
    }
}
