package pl.coderstrust.numbers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {

    public List<String> readLinesFromFile(String filePath) throws Exception {
        List<String> linesFromFile = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                linesFromFile.add(scanner.nextLine());
            }
        }
        return linesFromFile;
    }

    public void writeLinesToFile(List<String> lines, String filePath) throws Exception {
        if (lines.equals(null) || filePath.equals("")) {
            throw new NullPointerException("Passed arguments cannot be null.");
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            for (String line : lines) {
                if (line.length() > 0) {
                    writer.println(line);
                }
            }
        }
    }
}
