package pl.coderstrust.foobar;

import java.util.ArrayList;
import java.util.List;

public class FooBar {

    public static List<String> getFooBar(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Passed number cannot be lower than zero.");
        }
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= number; i++) {
            stringBuilder.setLength(0);
            stringBuilder.append(i);
            if (i % 3 == 0) {
                stringBuilder.append(" ").append("Foo");
            }
            if (i % 5 == 0) {
                if (stringBuilder.toString().contains("o")) {
                    stringBuilder.append("Bar");
                } else {
                    stringBuilder.append(" ").append("Bar");
                }
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }
}
