package pl.coderstrust.numbers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileProcessor {

    public List<String> readLinesFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        List<String> linesFromFile = new ArrayList<>();
        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))) {
            fileLines.forEach(linesFromFile::add);
        } catch (IOException e) {
            throw new Exception();
        }
        return linesFromFile;
    }

    public void writeLinesToFile(List<String> resultLines, String resultFileName) throws Exception {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(resultFileName, true), "UTF-8"))) {
            for (String line : resultLines) {
                if (line != null) {
                    writer.append(line);
                    ((BufferedWriter) writer).newLine();
                }
            }
        } catch (IOException e) {
            throw new Exception();
        }
    }
}
