package pl.coderstrust.numbers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class ProcessorWithStreams {

    public void process() throws IOException {
        File file = new File("src/main/resources/forcheck.txt");
        try (Stream<String> stream = Files.lines(Paths.get(file.getPath()))) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/checked.txt", true))) {
                stream.filter(s -> LineValidator.isLineValid(s))
                    .map(s -> {
                        String adding = Arrays.stream(s.split("\\s+"))
                            .reduce((result, element) -> String.format("%s+%s", result, element))
                            .get();
                        int sum = Arrays.stream(adding.split("\\+"))
                            .mapToInt(a -> Integer.parseInt(a))
                            .sum();
                        return String.format("%s=%d", adding, sum);
                    })
                    .forEach(x -> writer.println(x));
            }
        }
    }
}
