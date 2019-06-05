package pl.coderstrust.numbers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {

    public List<String> readLinesFromFile(String filePath) throws FileNotFoundException {
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null.");
        }
        List<String> linesFromFile = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                linesFromFile.add(scanner.nextLine());
            }
        }
        return linesFromFile;
    }

    public void writeLinesToFile(List<String> lines, String filePath) throws IOException {
        if (lines == null) {
            throw new IllegalArgumentException("Lines cannot be null.");
        }
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null.");
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }
}
