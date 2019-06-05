package pl.coderstrust.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersProcessorTest {

    @ParameterizedTest
    @MethodSource("invalidLineArguments")
    void shouldReturnEmptyStringForInvalidLine(String line) {
        assertThat(new NumbersProcessor().processLine(line)).isEqualTo("");
    }

    static Stream<Arguments> invalidLineArguments() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of("fdr 333 1 2    33 1##"),
                Arguments.of("!123 1 5     4"),
                Arguments.of("   22$2 1* 2@"));
    }

    @ParameterizedTest
    @MethodSource("validLineArguments")
    void shouldReturnCorrectResultForValidLine(String line, String expected) {
        assertThat(new NumbersProcessor().processLine(line)).isEqualTo(expected);
    }

    static Stream<Arguments> validLineArguments() {
        return Stream.of(
                Arguments.of("45 332 1 45   1      2", "45+332+1+45+1+2=426"),
                Arguments.of("1  2      123     43  87", "1+2+123+43+87=256"),
                Arguments.of("445 98 1 23", "445+98+1+23=567"),
                Arguments.of("   1   2   3 ", "1+2+3=6")
        );
    }
}
