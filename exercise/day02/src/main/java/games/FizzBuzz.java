package games;

public class FizzBuzz {
    private FizzBuzz() {
    }

    public static String convert(Integer input) throws OutOfRangeException {
        requireGreaterThanZero(input);
        requireLessThanOneHundred(input);
        if (input % 3 == 0 && input % 5 == 0) {
            return "FizzBuzz";
        }
        if (input % 3 == 0) {
            return "Fizz";
        }
        if (input % 5 == 0) {
            return "Buzz";
        }
        return input.toString();
    }

    private static void requireLessThanOneHundred(Integer input) throws OutOfRangeException {
        if (input > 100) {
            throw new OutOfRangeException();
        }
    }

    private static void requireGreaterThanZero(Integer input) throws OutOfRangeException {
        if (input <= 0) {
            throw new OutOfRangeException();
        }
    }
}
