package pl.coderstrust.christmastree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChristmasTreeTest {

    @ParameterizedTest
    @MethodSource("christmasTreeArguments")
    void shouldPrint(int size, List<String> expected) {
        assertThat(ChristmasTree.getChristmasTree(size)).isEqualTo(expected);
    }

    static Stream<Arguments> christmasTreeArguments() {
        List<String> expectedFor5 = Arrays.asList("    *", "   ***", "  *****", " *******", "*********", "    *");
        List<String> expectedFor10 = Arrays.asList("         *", "        ***", "       *****", "      *******",
                "     *********", "    ***********", "   *************", "  ***************", " *****************",
                "*******************", "         *");
        return Stream.of(
                Arguments.of(5, expectedFor5),
                Arguments.of(10, expectedFor10)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 0, -3})
    void shouldThrowExceptionForInvalidArgument(int size) {
        assertThrows(IllegalArgumentException.class, () -> ChristmasTree.getChristmasTree(size));
    }
}
