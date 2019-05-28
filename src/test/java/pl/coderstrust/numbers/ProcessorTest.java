package pl.coderstrust.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        when(fileProcessor.readLinesFromFile("src/main/resources/forcheck.txt")).
                thenReturn(Arrays.asList("43 12 2 4 0 1", "asd 23 a 123 sads 1", "1 1 5"));
        when(numbersProcessor.processLine("43 12 2 4 0 1")).thenReturn("43+12+2+4+0+1=62");
        when(numbersProcessor.processLine("asd 23 a 123 sads 1")).thenReturn(null);
        when(numbersProcessor.processLine("1 1 5")).thenReturn("1+1+5=7");
        List<String> listForWrite = new ArrayList<>(Arrays.asList("43+12+2+4+0+1=62", null, "1+1+5=7"));

        // when
        processor.process("src/main/resources/forcheck.txt", "src/main/resources/checked.txt");

        // then
        verify(fileProcessor).writeLinesToFile(listForWrite, "src/main/resources/checked.txt");
    }
}
