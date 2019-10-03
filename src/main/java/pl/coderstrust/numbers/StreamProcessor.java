package pl.coderstrust.numbers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamProcessor {

    public void process(String inputFilePath, String outputFilePath) throws IOException {
        if (inputFilePath == null) {
            throw new IllegalArgumentException("Input file path cannot be null.");
        }
        if (outputFilePath == null) {
            throw new IllegalArgumentException("Output file path cannot be null.");
        }
        try (Stream<String> stream = Files.lines(Paths.get(inputFilePath))) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
                stream.filter(LineValidator::isLineValid)
                    .map(line -> line.split("\\s+"))
                    .map(arrayOfNumbers -> {
                        String numbers = Arrays.stream(arrayOfNumbers)
                            .reduce((result, element) -> String.format("%s+%s", result, element))
                            .get();
                        int sumOfNumbers = Arrays.stream(arrayOfNumbers)
                            .mapToInt(Integer::parseInt)
                            .sum();
                        return String.format("%s=%d", numbers, sumOfNumbers);
                    })
                    .forEach(writer::println);
            }
        }
    }
}
