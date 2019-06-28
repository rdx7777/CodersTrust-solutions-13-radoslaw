package pl.coderstrust.regex;

import java.util.regex.Pattern;

public class IpAddressValidator {

    private static final String IP_ADDRESS_PATTERN = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
    private static Pattern pattern = Pattern.compile(IP_ADDRESS_PATTERN);

    public static boolean isIpAddress(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }
        return pattern.matcher(input).matches();
    }
}
