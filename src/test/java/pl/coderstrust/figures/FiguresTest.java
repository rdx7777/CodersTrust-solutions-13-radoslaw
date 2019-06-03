package pl.coderstrust.figures;

import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FiguresTest {

    @ParameterizedTest
    @MethodSource("figuresArguments")
    void shouldCalculateFiguresArea(Figure testFigure, double expectedArea) {
        assertThat(testFigure.calculateArea()).isCloseTo(expectedArea, Offset.offset(0.001));

    }

    static Stream<Arguments> figuresArguments() {
        return Stream.of(
                Arguments.of(new Circle(2.5), 19.635),
                Arguments.of(new Rectangle(2.5, 4), 10),
                Arguments.of(new Rectangle(3.45, 2.81), 9.695),
                Arguments.of(new Square(3.55), 12.602),
                Arguments.of(new Trapezoid(3, 6, 2.15), 9.675),
                Arguments.of(new Triangle(2, 4), 4),
                Arguments.of(new Triangle(3), 3.897)
        );
    }
}
