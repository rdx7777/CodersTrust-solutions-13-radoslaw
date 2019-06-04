package pl.coderstrust.numbers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Processor {

    public static void main(String args[]) throws Exception {
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        FileProcessor fileProcessor = new FileProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);
        processor.process("src/main/resources/forcheck.txt", "src/main/resources/checked.txt");
    }

    private NumbersProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        if (numbersProcessor == null) {
            throw new IllegalArgumentException("Numbers processor cannot be null.");
        }
        if (fileProcessor == null) {
            throw new IllegalArgumentException("Files processor cannot be null.");
        }
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(String inputFilePath, String outputFilePath) throws IOException {
        if (inputFilePath == null) {
            throw new IllegalArgumentException("Input file path cannot be null.");
        }
        if (outputFilePath == null) {
            throw new IllegalArgumentException("Output file path cannot be null.");
        }
        List<String> linesFromFile = fileProcessor.readLinesFromFile(inputFilePath);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile) {
            if (LineValidator.isLineValid(line)) {
                resultLines.add(numbersProcessor.processLine(line));
            }
        }
        fileProcessor.writeLinesToFile(resultLines, outputFilePath);
    }
}
