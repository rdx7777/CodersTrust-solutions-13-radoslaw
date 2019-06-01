package pl.coderstrust.fibonacci;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FibonacciCheckerTest {

    @ParameterizedTest
    @MethodSource("fibonacciCheckerArguments")
    void shouldCheckProvidedNumberIsFibonacciNumber(long number, boolean result) {
        assertThat(FibonacciChecker.isFibonacciNumber(number)).isEqualTo(result);
    }

    static Stream<Arguments> fibonacciCheckerArguments() {
        return Stream.of(
                Arguments.of(13, true),
                Arguments.of(3, true),
                Arguments.of(4, false),
                Arguments.of(5, true),
                Arguments.of(8, true),
                Arguments.of(13, true),
                Arguments.of(15, false),
                Arguments.of(2, true),
                Arguments.of(4, false),
                Arguments.of(19, false),
                Arguments.of(21, true),
                Arguments.of(40, false),
                Arguments.of(99, false),
                Arguments.of(5, true),
                Arguments.of(300, false),
                Arguments.of(987, true),
                Arguments.of(15, false),
                Arguments.of(1597, true),
                Arguments.of(6400, false),
                Arguments.of(13, true),
                Arguments.of(6765, true),
                Arguments.of(12111, false),
                Arguments.of(1999999999, false)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 2000000999})
    void shouldThrowExceptionForInvalidArgument(long number) {
        assertThatThrownBy(() -> FibonacciChecker.isFibonacciNumber(number)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
