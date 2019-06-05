package pl.coderstrust.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProcessorTest {

    @Mock
    NumbersProcessor numbersProcessor;

    @Mock
    FileProcessor fileProcessor;

    @InjectMocks
    Processor processor;

    @Test
    public void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() throws Exception {
        // given
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";
        doReturn(Arrays.asList("43 12 2 4 0 1", "asd 23 a 123 sads 1", "1 1 5")).when(fileProcessor).readLinesFromFile(inputFilePath);
        doReturn("43+12+2+4+0+1=62").when(numbersProcessor).processLine("43 12 2 4 0 1");
        doReturn("1+1+5=7").when(numbersProcessor).processLine("1 1 5");
        List<String> resultLines = Arrays.asList("43+12+2+4+0+1=62", "1+1+5=7");

        // when
        processor.process(inputFilePath, outputFilePath);

        // then
        verify(fileProcessor).readLinesFromFile(inputFilePath);
        verify(fileProcessor).writeLinesToFile(resultLines, outputFilePath);
        verify(numbersProcessor).processLine("43 12 2 4 0 1");
        verify(numbersProcessor).processLine("1 1 5");
        verify(numbersProcessor, times(2)).processLine(anyString());
    }

    @Test
    public void shouldThrowExceptionForNullAsNumbersProcessor() {
        assertThrows(IllegalArgumentException.class, () -> new Processor(null, new FileProcessor()));
    }

    @Test
    public void shouldThrowExceptionForNullAsFileProcessor() {
        assertThrows(IllegalArgumentException.class, () -> new Processor(new NumbersProcessor(), null));
    }

    @Test
    public void shouldThrowExceptionForNullAsInputFilePathInMethodProcess() {
        assertThrows(IllegalArgumentException.class, () -> processor.process(null, "output.txt"));
    }

    @Test
    public void shouldThrowExceptionForNullAsOutputFilePathInMethodProcess() {
        assertThrows(IllegalArgumentException.class, () -> processor.process("input.txt", null));
    }
}
