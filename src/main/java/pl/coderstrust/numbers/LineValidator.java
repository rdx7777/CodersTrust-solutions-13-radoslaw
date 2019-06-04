package pl.coderstrust.numbers;

import java.util.regex.Pattern;

public class LineValidator {

    private static Pattern pattern = Pattern.compile("^[\\d\\s]+");

    public static boolean isLineValid(String line) {
        if (line == null || line.trim().isEmpty()) {
            return false;
        }
        return pattern.matcher(line).matches();
    }
}
