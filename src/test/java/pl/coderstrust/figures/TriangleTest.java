package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TriangleTest {

    @ParameterizedTest
    @MethodSource("triangleTestInvalidArguments")
    void shouldThrowExceptionForInvalidArgument(double a, double h) {
        assertThatThrownBy(() -> new Triangle(a, h).calculateArea()).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    static Stream triangleTestInvalidArguments() {
        return Stream.of(
                Arguments.of(-11.4, 2),
                Arguments.arguments(-9.15, -3),
                Arguments.arguments(2.000055, -1.2)
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {-25, -11.8, -3.0009})
    void shouldThrowExceptionForInvalidArgument(double a) {
        assertThatThrownBy(() -> new Triangle(a).calculateArea()).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
