package pl.coderstrust.numbers;

import java.util.regex.Pattern;

public class NumbersProcessor {

    public String processLine(String line) {
        Pattern pattern = Pattern.compile("([0-9]+ +)+[0-9]+ *");
        if (pattern.matcher(line).matches()) {
            int sum = 0;
            String resultLine = "";
            String splitString[] = line.split(" +");
            for (int i = 0; i < splitString.length; i++) {
                sum = sum + Integer.valueOf(splitString[i]);
                if (i != splitString.length - 1) {
                    resultLine = resultLine + splitString[i] + "+";
                } else {
                    resultLine = resultLine + splitString[i];
                }
            }
            resultLine = resultLine + "=" + sum;
            return resultLine;
        }
        return null;
    }
}
