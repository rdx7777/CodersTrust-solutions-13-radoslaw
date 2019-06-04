package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CircleTest {

    @ParameterizedTest
    @ValueSource(doubles = {-300, -5.25, -1})
    void shouldThrowExceptionForInvalidArgument(double r) {
        assertThatThrownBy(() -> new Circle(r).calculateArea()).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
