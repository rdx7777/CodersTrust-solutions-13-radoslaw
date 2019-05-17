package pl.coderstrust.foobar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FooBarTest {

    @ParameterizedTest
    @MethodSource("fooBarArguments")
    void shouldReturnCorrectFooBar(int number, List<String> expected) {
        assertThat(FooBar.getFooBar(number)).isEqualTo(expected);
    }

    static Stream<Arguments> fooBarArguments() {
        List<String> expectedFor3 = Arrays.asList("0 FooBar", "1", "2", "3 Foo");
        List<String> expectedFor16 = Arrays.asList("0 FooBar", "1", "2", "3 Foo", "4", "5 Bar", "6 Foo", "7", "8",
                "9 Foo", "10 Bar", "11", "12 Foo", "13", "14", "15 FooBar", "16");
        return Stream.of(
                Arguments.of(3, expectedFor3),
                Arguments.of(16, expectedFor16)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-33, -5, -2})
    void shouldThrowExceptionForInvalidArgument(int number) {
        assertThrows(IllegalArgumentException.class, () -> FooBar.getFooBar(number));
    }
}
