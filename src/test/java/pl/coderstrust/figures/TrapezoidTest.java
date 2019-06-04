package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrapezoidTest {

    @ParameterizedTest
    @MethodSource("trapezoidTestInvalidArguments")
    void shouldThrowExceptionForInvalidArgument(double a, double b, double h) {
        assertThatThrownBy(() -> new Trapezoid(a, b, h).calculateArea()).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    static Stream trapezoidTestInvalidArguments() {
        return Stream.of(
                Arguments.of(-3, 2, 9),
                Arguments.of(-4.55, -2.8, 3),
                Arguments.of(-2.33, -4.11, -5),
                Arguments.of(-5.2, 3.05, -2.87),
                Arguments.of(4.5, -2, -9.7),
                Arguments.of(3, 8.75, -3),
                Arguments.of(2, -4.1, 8.23)
        );
    }
}
