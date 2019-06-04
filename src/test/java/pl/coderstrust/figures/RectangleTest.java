package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RectangleTest {

    @ParameterizedTest
    @MethodSource("rectangleTestInvalidArguments")
    void shouldThrowExceptionForInvalidArgument(double a, double b) {
        assertThatThrownBy(() -> new Rectangle(a, b).calculateArea()).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    static Stream rectangleTestInvalidArguments() {
        return Stream.of(
                Arguments.of(-3, 2),
                Arguments.arguments(-4.55, -2.8),
                Arguments.arguments(3.05, -2.87)
        );
    }
}
