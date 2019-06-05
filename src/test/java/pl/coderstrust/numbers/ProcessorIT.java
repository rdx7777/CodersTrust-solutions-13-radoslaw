package pl.coderstrust.numbers;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProcessorIT {

    @Test
    public void processorIntegrationTest() throws IOException {
        // given
        FileProcessor fileProcessor = new FileProcessor();
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);
        String inputFilePath = "src/test/resources/input.txt";
        String outputFilePath = "src/test/resources/output.txt";
        String expectedFilePath = "src/test/resources/expected.txt";

        // when
        processor.process(inputFilePath, outputFilePath);
        byte[] outputFileContent = Files.readAllBytes(Paths.get(outputFilePath));
        byte[] expectedFileContent = Files.readAllBytes(Paths.get(expectedFilePath));

        // then
        assertArrayEquals(expectedFileContent, outputFileContent);
    }
}
