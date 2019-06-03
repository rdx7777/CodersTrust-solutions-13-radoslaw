package pl.coderstrust.numbers;

import java.util.regex.Pattern;

public class NumbersProcessor {

    public String processLine(String line) {
        StringBuilder processedLine = new StringBuilder();
        processedLine.setLength(0);
        if (isLineValid(line)) {
            int sum = 0;
            String splitString[] = line.split(" +");
            for (int i = 0; i < splitString.length; i++) {
                sum = sum + Integer.valueOf(splitString[i]);
                if (i != splitString.length - 1) {
                    processedLine.append(splitString[i]).append("+");
                } else {
                    processedLine.append(splitString[i]);
                }
            }
            processedLine.append("=").append(sum);
        }
        return processedLine.toString();
    }

    private static boolean isLineValid(String line) {
        Pattern pattern = Pattern.compile("^[\\d\\s]+");
        return pattern.matcher(line).matches();
    }
}
