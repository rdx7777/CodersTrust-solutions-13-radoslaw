package pl.coderstrust.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"123 ds 34    @#$  23 d 333", "asd234 222 2    1", "1 aa         1 1 1", ""})
    void shouldReturnFalseForInvalidLine(String line) {
        assertThat(LineValidator.isLineValid(line)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"    123 34  23  333  ", "  222 2    1 ", "1  654         1  1 1", "       11        "})
    void shouldReturnTrueForValidLine(String line) {
        assertThat(LineValidator.isLineValid(line)).isTrue();
    }
}
