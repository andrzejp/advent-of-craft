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
    void should_convert_numbers_to_themselves(Integer input, String expected) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"3", "66", "99"})
    void should_convert_numbers_divisible_by_three_to_Fizz(Integer input) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(input))
                .isEqualTo("Fizz");
    }

    @ParameterizedTest
    @CsvSource({"5", "50", "85"})
    void should_convert_numbers_divisible_by_five_to_Buzz(Integer input) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(input))
                .isEqualTo("Buzz");
    }

    @ParameterizedTest
    @CsvSource({"15", "30", "45"})
    void should_convert_numbers_divisible_by_three_and_five_to_FizzBuzz(Integer input) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(input))
                .isEqualTo("FizzBuzz");
    }

    @Test
    void should_disallow_input_of_0() {
        assertThatThrownBy(() -> FizzBuzz.convert(0))
                .isInstanceOf(OutOfRangeException.class);
    }

    @Test
    void should_disallow_input_greater_than_100() {
        assertThatThrownBy(() -> FizzBuzz.convert(101))
                .isInstanceOf(OutOfRangeException.class);
    }

    @Test
    void should_disallow_a_negative_input() {
        assertThatThrownBy(() -> FizzBuzz.convert(-1))
                .isInstanceOf(OutOfRangeException.class);
    }
}