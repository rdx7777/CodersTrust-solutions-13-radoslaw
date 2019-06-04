package pl.coderstrust.numbers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FileProcessorTest {

    @Test
    public void shouldThrowExceptionForNullAsFilePathInMethodReadLinesFromFile() {
        assertThrows(IllegalArgumentException.class, () -> new FileProcessor().readLinesFromFile(null));
    }

    @Test
    public void shouldThrowExceptionForNullAsLinesInMethodWriteLinesToFile() {
        assertThrows(IllegalArgumentException.class, () -> new FileProcessor().writeLinesToFile(null, "output.txt"));
    }

    @Test
    public void shouldThrowExceptionForNullAsFilePathInMethodWriteLinesToFile() {
        assertThrows(IllegalArgumentException.class, () -> new FileProcessor().writeLinesToFile(new ArrayList<>(), null));
    }
}
