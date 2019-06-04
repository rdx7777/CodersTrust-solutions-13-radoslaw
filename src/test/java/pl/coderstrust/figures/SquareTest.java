package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SquareTest {

    @ParameterizedTest
    @ValueSource(doubles = {-14.5, -3, -1.5})
    void shouldThrowExceptionForInvalidArgument(double a) {
        assertThatThrownBy(() -> new Square(a).calculateArea()).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
