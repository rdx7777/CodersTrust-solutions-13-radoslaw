package pl.coderstrust.numbers;

import java.util.Scanner;

public class NumbersProcessor {

    public String processLine(String line) {
        if (!LineValidator.isLineValid(line)) {
            return "";
        }
        try (Scanner scanner = new Scanner(line)) {
            StringBuilder processedLine = new StringBuilder();
            int sum = 0;
            int number;
            while (scanner.hasNextInt()) {
                number = scanner.nextInt();
                processedLine.append(number);
                sum += number;
                if (scanner.hasNextInt()) {
                    processedLine.append("+");
                }
            }
            processedLine.append("=").append(sum);
            return processedLine.toString();
        }
    }
}
