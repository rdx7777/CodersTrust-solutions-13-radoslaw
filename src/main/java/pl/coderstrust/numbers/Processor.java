package pl.coderstrust.numbers;

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
            throw new NullPointerException("Passed argument must be declared.");
        }
        if (fileProcessor.equals(null)) {
            throw new NullPointerException("Passed argument must be declared.");
        }
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(String inputFilePath, String outputFilePath) throws Exception {
        if (inputFilePath.equals("") || outputFilePath.equals("")) {
            throw new IllegalArgumentException("Passed file paths cannot be empty");
        }
        List<String> linesFromFile = fileProcessor.readLinesFromFile(inputFilePath);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile) {
            resultLines.add(numbersProcessor.processLine(line));
        }
        fileProcessor.writeLinesToFile(resultLines, outputFilePath);
    }
}
