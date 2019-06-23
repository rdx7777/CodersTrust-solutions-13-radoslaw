package pl.coderstrust.regex;

import java.util.regex.Pattern;

public class IPChecker {

//    private static Pattern pattern = Pattern.compile("(\\d{1,3}\\.){3}\\d{1,3}");
    private static Pattern pattern = Pattern
        .compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");

    public static boolean isIPAddress(String input) {
        return pattern.matcher(input).matches();
    }
}
