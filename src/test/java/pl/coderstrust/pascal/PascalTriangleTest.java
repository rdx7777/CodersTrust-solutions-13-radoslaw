package pl.coderstrust.pascal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PascalTriangleTest {

    @ParameterizedTest
    @MethodSource("pascalTriangleArguments")
    void shouldReturnCorrectPascalTriangle(int number, List<String> expected) {
        assertThat(PascalTriangle.getPascalTriangle(number)).isEqualTo(expected);
    }

    static Stream<Arguments> pascalTriangleArguments() {
        List<String> expectedFor4 = Arrays.asList("                    1", "                 1     1",
                "              1     2     1", "           1     3     3     1");
        List<String> expectedFor7 = Arrays.asList("                             1", "                          1     1",
                "                       1     2     1", "                    1     3     3     1", "                 1     4     6     4     1",
                "              1     5    10    10     5     1", "           1     6    15    20    15     6     1");
        return Stream.of(
                Arguments.of(4, expectedFor4),
                Arguments.of(7, expectedFor7)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-12, -7, 0})
    void shouldThrowExceptionForInvalidArgument(int number) {
        assertThrows(IllegalArgumentException.class, () -> PascalTriangle.getPascalTriangle(number));
    }
}
