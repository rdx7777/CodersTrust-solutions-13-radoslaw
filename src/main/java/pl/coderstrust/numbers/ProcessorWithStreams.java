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

    public static void main(String[] args) throws IOException {
        ProcessorWithStreams processor = new ProcessorWithStreams();
        processor.process();
    }

    public void process() throws IOException {
        File file = new File("src/main/resources/forcheck.txt");
        Stream<String> stream = Files.lines(Paths.get(file.getPath()));
        PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/checked.txt", true));
        stream.filter(s -> LineValidator.isLineValid(s))
            .map(s -> {
                String adding = Arrays.stream(s.split("\\s+"))
                    .reduce((result, element) -> String.format("%s+%s", result, element))
                    .get();
//                int sum = Arrays.stream(adding.split("\\+"))
//                    .map(s1 -> Integer.valueOf(s1)).reduce(0, (result, element) -> result + element);
                int sum = Arrays.stream(adding.split("\\+"))
                    .mapToInt(a -> Integer.parseInt(a))
                    .sum();
                return String.format("%s=%d", adding, sum);
            })
            .forEach(x -> {
                System.out.println(x);
                writer.println(x);
            });
    }
}
