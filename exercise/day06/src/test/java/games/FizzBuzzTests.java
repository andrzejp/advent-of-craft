package games;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FizzBuzzTests {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "67, 67",
            "82, 82"
    })
    void should_return_number_as_string(int input, String expected) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"3", "66", "99"})
    void should_return_Fizz_for_multiples_of_3(int input) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(input))
                .isEqualTo("Fizz");
    }

    @ParameterizedTest
    @CsvSource({"5", "50", "85"})
    void should_return_Buzz_for_multiples_of_5(int input) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(input))
                .isEqualTo("Buzz");
    }

    @Test
    void returns_FizzBuzz_for_15() throws OutOfRangeException {
        assertThat(FizzBuzz.convert(15))
                .isEqualTo("FizzBuzz");
    }

    @Test
    void returns_FizzBuzz_for_30() throws OutOfRangeException {
        assertThat(FizzBuzz.convert(30))
                .isEqualTo("FizzBuzz");
    }

    @Test
    void returns_FizzBuzz_for_45() throws OutOfRangeException {
        assertThat(FizzBuzz.convert(45))
                .isEqualTo("FizzBuzz");
    }

    @Test
    void throws_an_exception_for_0() {
        assertThatThrownBy(() -> FizzBuzz.convert(0))
                .isInstanceOf(OutOfRangeException.class);
    }

    @Test
    void throws_an_exception_for_101() {
        assertThatThrownBy(() -> FizzBuzz.convert(101))
                .isInstanceOf(OutOfRangeException.class);
    }

    @Test
    void throws_an_exception_for_minus_1() {
        assertThatThrownBy(() -> FizzBuzz.convert(-1))
                .isInstanceOf(OutOfRangeException.class);
    }
}