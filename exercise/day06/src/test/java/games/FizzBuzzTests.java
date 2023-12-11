package games;

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

    @ParameterizedTest
    @CsvSource({"15", "30", "45"})
    void should_return_FizzBuzz_for_multiples_of_both_3_and_5(int input) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(input))
                .isEqualTo("FizzBuzz");
    }

    @ParameterizedTest
    @CsvSource({"0", "101", "-1"})
    void should_only_accept_numbers_between_1_and_100(int input) {
        assertThatThrownBy(() -> FizzBuzz.convert(input))
                .isInstanceOf(OutOfRangeException.class);
    }
}