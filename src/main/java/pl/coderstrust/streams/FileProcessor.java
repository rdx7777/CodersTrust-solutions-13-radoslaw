package pl.coderstrust.streams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileProcessor {

    public List<String> readLinesFromFile(String filePath) throws IOException {
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null.");
        }
        File file = new File(filePath);
        List<String> linesFromFile = new ArrayList<>();
        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))) {
            fileLines.forEach(linesFromFile::add);
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
            lines.forEach(writer::println);
        }
    }
}
