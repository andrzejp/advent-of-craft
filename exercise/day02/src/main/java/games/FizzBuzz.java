package games;

public class FizzBuzz {
    private FizzBuzz() {
    }

    public static String convert(Integer input) throws OutOfRangeException {
        requireInRange(input);
        if (isFizz(input) && isBuzz(input)) {
            return "FizzBuzz";
        }
        if (isFizz(input)) {
            return "Fizz";
        }
        if (isBuzz(input)) {
            return "Buzz";
        }
        return input.toString();
    }

    private static void requireInRange(Integer input) throws OutOfRangeException {
        requireGreaterThanZero(input);
        requireLessThanOneHundred(input);
    }

    private static void requireGreaterThanZero(Integer input) throws OutOfRangeException {
        if (input <= 0) {
            throw new OutOfRangeException();
        }
    }

    private static void requireLessThanOneHundred(Integer input) throws OutOfRangeException {
        if (input > 100) {
            throw new OutOfRangeException();
        }
    }

    private static boolean isFizz(Integer input) {
        return input % 3 == 0;
    }

    private static boolean isBuzz(Integer input) {
        return input % 5 == 0;
    }
}
