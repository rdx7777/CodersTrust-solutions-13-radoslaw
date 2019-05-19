package pl.coderstrust.multiplication;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MultiplicationTableTest {

    @ParameterizedTest
    @MethodSource("multiplicationTableArguments")
    void testPrintMultiplicationTable(int size, List<String> expected) {
        assertThat(MultiplicationTable.getMultiplicationTable(size)).isEqualTo(expected);
    }

    static Stream<Arguments> multiplicationTableArguments() {
        List<String> expectedListFor3 = new ArrayList<>();
        expectedListFor3.add("  1 2 3");
        expectedListFor3.add("1 1 2 3");
        expectedListFor3.add("2 2 4 6");
        expectedListFor3.add("3 3 6 9");
        List<String> expectedListFor12 = new ArrayList<>();
        expectedListFor12.add("     1   2   3   4   5   6   7   8   9  10  11  12");
        expectedListFor12.add(" 1   1   2   3   4   5   6   7   8   9  10  11  12");
        expectedListFor12.add(" 2   2   4   6   8  10  12  14  16  18  20  22  24");
        expectedListFor12.add(" 3   3   6   9  12  15  18  21  24  27  30  33  36");
        expectedListFor12.add(" 4   4   8  12  16  20  24  28  32  36  40  44  48");
        expectedListFor12.add(" 5   5  10  15  20  25  30  35  40  45  50  55  60");
        expectedListFor12.add(" 6   6  12  18  24  30  36  42  48  54  60  66  72");
        expectedListFor12.add(" 7   7  14  21  28  35  42  49  56  63  70  77  84");
        expectedListFor12.add(" 8   8  16  24  32  40  48  56  64  72  80  88  96");
        expectedListFor12.add(" 9   9  18  27  36  45  54  63  72  81  90  99 108");
        expectedListFor12.add("10  10  20  30  40  50  60  70  80  90 100 110 120");
        expectedListFor12.add("11  11  22  33  44  55  66  77  88  99 110 121 132");
        expectedListFor12.add("12  12  24  36  48  60  72  84  96 108 120 132 144");
        return Stream.of(
                Arguments.of(3, expectedListFor3),
                Arguments.of(12, expectedListFor12)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -3, -15})
    void shouldThrowExceptionForInvalidArgument(int size) {
        assertThatThrownBy(() -> MultiplicationTable.getMultiplicationTable(size))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("multiplicationTableUsingTwoDimensionalArrayArguments")
    void testPrintMultiplicationTableUsingTwoDimensionalArray(int size, int[][] expected) {
        assertThat(MultiplicationTable.getMultiplicationTableUsingTwoDimensionalArray(size)).isEqualTo(expected);
    }

    static Stream<Arguments> multiplicationTableUsingTwoDimensionalArrayArguments() {
        return Stream.of(
                Arguments.of(3, new int[][]{{1, 2, 3}, {2, 4, 6}, {3, 6, 9}}),
                Arguments.of(7, new int[][]{{1, 2, 3, 4, 5, 6, 7}, {2, 4, 6, 8, 10, 12, 14}, {3, 6, 9, 12, 15, 18, 21},
                        {4, 8, 12, 16, 20, 24, 28}, {5, 10, 15, 20, 25, 30, 35}, {6, 12, 18, 24, 30, 36, 42},
                        {7, 14, 21, 28, 35, 42, 49}})
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -3, -15})
    void shouldThrowExceptionForInvalidArgumentInMethodUsingTwoDimensionalArray(int size) {
        assertThatThrownBy(() -> MultiplicationTable.getMultiplicationTableUsingTwoDimensionalArray(size))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
