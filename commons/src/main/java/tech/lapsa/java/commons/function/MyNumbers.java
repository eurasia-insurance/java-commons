package tech.lapsa.java.commons.function;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public final class MyNumbers {

    private static final String NON_ZERO_NUMBER = "Is not zero";
    private static final String ZERO_NUMBER = "Is zero";
    private static final String NON_POSITIVE_NUMBER = "Is not positive or zero";

    private MyNumbers() {
    }

    // Number

    public static <T extends Number> boolean zero(final T number) {
	return number == null || zero(number.doubleValue());  // double is the widest numeric type
    }

    public static <T extends Number> T requireZero(final T number) {
	return requireZero(number, null);
    }

    public static <T extends Number> T requireZero(final T number, String par) {
	if (zero(number))
	    return number;
	throw MyExceptions.illegalArgumentException(NON_ZERO_NUMBER, par, String.valueOf(number));
    }

    public static <T extends Number> boolean nonZero(final T number) {
	return number != null && nonZero(number.doubleValue()); // double is the widest numeric type
    }

    public static <T extends Number> T requireNonZero(final T number) {
	return requireNonZero(number, null);
    }

    public static <T extends Number> T requireNonZero(final T number, String par) {
	if (nonZero(number))
	    return number;
	throw MyExceptions.illegalArgumentException(ZERO_NUMBER, par, String.valueOf(number));
    }

    public static <T extends Number> boolean positive(final T number) {
	return number != null && positive(number.doubleValue()); // double is the widest numeric type
    }

    public static <T extends Number> T requirePositive(final T number) {
	return requirePositive(number, null);
    }

    public static <T extends Number> T requirePositive(final T number, String par) {
	if (positive(number))
	    return number;
	throw MyExceptions.illegalArgumentException(NON_POSITIVE_NUMBER, par, String.valueOf(number));
    }

    // long

    public static boolean zero(final long number) {
	return number == 0;
    }

    public static long requireZero(final long number) {
	return requireZero(number, null);
    }

    public static long requireZero(final long number, String par) {
	if (zero(number))
	    return number;
	throw MyExceptions.illegalArgumentException(NON_ZERO_NUMBER, par, String.valueOf(number));
    }

    public static boolean nonZero(final long number) {
	return number != 0;
    }

    public static long requireNonZero(final long number) {
	return requireNonZero(number, null);
    }

    public static long requireNonZero(final long number, String par) {
	if (nonZero(number))
	    return number;
	throw MyExceptions.illegalArgumentException(ZERO_NUMBER, par, String.valueOf(number));
    }

    public static boolean positive(final long number) {
	return number > 0;
    }

    public static long requirePositive(final long number) {
	return requirePositive(number, null);
    }

    public static long requirePositive(final long number, String par) {
	if (positive(number))
	    return number;
	throw MyExceptions.illegalArgumentException(NON_POSITIVE_NUMBER, par, String.valueOf(number));
    }
    
    // double

    public static boolean zero(final double number) {
	return number == 0;
    }

    public static double requireZero(final double number) {
	return requireZero(number, null);
    }

    public static double requireZero(final double number, String par) {
	if (zero(number))
	    return number;
	throw MyExceptions.illegalArgumentException(NON_ZERO_NUMBER, par, String.valueOf(number));
    }

    public static boolean nonZero(final double number) {
	return number != 0;
    }

    public static double requireNonZero(final double number) {
	return requireNonZero(number, null);
    }

    public static double requireNonZero(final double number, String par) {
	if (nonZero(number))
	    return number;
	throw MyExceptions.illegalArgumentException(ZERO_NUMBER, par, String.valueOf(number));
    }

    public static boolean positive(final double number) {
	return number > 0;
    }

    public static double requirePositive(final double number) {
	return requirePositive(number, null);
    }

    public static double requirePositive(final double number, String par) {
	if (positive(number))
	    return number;
	throw MyExceptions.illegalArgumentException(NON_POSITIVE_NUMBER, par, String.valueOf(number));
    }

    // int

    public static boolean zero(final int number) {
	return number == 0;
    }

    public static int requireZero(final int number) {
	return requireZero(number, null);
    }

    public static int requireZero(final int number, String par) {
	if (zero(number))
	    return number;
	throw MyExceptions.illegalArgumentException(NON_ZERO_NUMBER, par, String.valueOf(number));
    }

    public static boolean nonZero(final int number) {
	return number != 0;
    }

    public static int requireNonZero(final int number) {
	return requireNonZero(number, null);
    }

    public static int requireNonZero(final int number, String par) {
	if (nonZero(number))
	    return number;
	throw MyExceptions.illegalArgumentException(ZERO_NUMBER, par, String.valueOf(number));
    }

    public static boolean positive(final int number) {
	return number > 0;
    }

    public static int requirePositive(final int number) {
	return requirePositive(number, null);
    }

    public static int requirePositive(final int number, String par) {
	if (positive(number))
	    return number;
	throw MyExceptions.illegalArgumentException(NON_POSITIVE_NUMBER, par, String.valueOf(number));
    }

    //

    public static <N1 extends Number, N2 extends Number> boolean numbericEquals(N1 n1, N2 n2) {
	return n1 != null && n2 != null && n1.doubleValue() == n2.doubleValue();
    }

    public static <N extends Number> boolean equals(N n1, N n2) {
	return n1 != null && n2 != null && n1.equals(n2);
    }

    // parsers

    // int

    // primitive

    public static OptionalInt parseInt(String s) {
	try {
	    return OptionalInt.of(Integer.parseInt(s));
	} catch (NumberFormatException e) {
	    return OptionalInt.empty();
	}
    }

    public static OptionalInt parseNonZeroInt(String s) {
	try {
	    return OptionalInt.of(requireNonZero(Integer.parseInt(s)));
	} catch (IllegalArgumentException e) {
	    // also catches NumberFormatException
	    return OptionalInt.empty();
	}
    }

    public static OptionalInt parseInt(String s, int radix) {
	try {
	    return OptionalInt.of(Integer.parseInt(s, radix));
	} catch (NumberFormatException e) {
	    return OptionalInt.empty();
	}
    }

    public static OptionalInt parseNonZeroInt(String s, int radix) {
	try {
	    return OptionalInt.of(requireNonZero(Integer.parseInt(s, radix)));
	} catch (IllegalArgumentException e) {
	    // also catches NumberFormatException
	    return OptionalInt.empty();
	}
    }

    // boxed

    public static Optional<Integer> valueOfInt(String s) {
	try {
	    return Optional.of(Integer.valueOf(s));
	} catch (NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Integer> nonZeroValueOfInt(String s) {
	try {
	    return MyOptionals.of(Integer.valueOf(s));
	} catch (NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Integer> valueOfInt(String s, int radix) {
	try {
	    return Optional.of(Integer.valueOf(s, radix));
	} catch (NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Integer> nonZeroValueOfInt(String s, int radix) {
	try {
	    return MyOptionals.of(Integer.valueOf(s, radix));
	} catch (NumberFormatException e) {
	    return Optional.empty();
	}
    }

    // double

    // primitive

    public static OptionalDouble parseDbl(String s) {
	try {
	    return OptionalDouble.of(Double.parseDouble(s));
	} catch (NumberFormatException e) {
	    return OptionalDouble.empty();
	}
    }

    public static OptionalDouble parseNonZeroDbl(String s) {
	try {
	    return OptionalDouble.of(requireNonZero(Double.parseDouble(s)));
	} catch (IllegalArgumentException e) {
	    // also catches NumberFormatException
	    return OptionalDouble.empty();
	}
    }

    // boxed

    public static Optional<Double> valueOfDbl(String doubleStr) {
	try {
	    return Optional.of(Double.valueOf(doubleStr));
	} catch (NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Double> nonZeroValueOfDbl(String s) {
	try {
	    return MyOptionals.of(Double.valueOf(s));
	} catch (NumberFormatException e) {
	    return Optional.empty();
	}
    }

    // long

    // primitive

    public static OptionalLong parseLng(String s) {
	try {
	    return OptionalLong.of(Long.parseLong(s));
	} catch (NumberFormatException e) {
	    return OptionalLong.empty();
	}
    }

    public static OptionalLong parseNonZeroLng(String s) {
	try {
	    return OptionalLong.of(requireNonZero(Long.parseLong(s)));
	} catch (IllegalArgumentException e) {
	    // also catches NumberFormatException
	    return OptionalLong.empty();
	}
    }

    public static OptionalLong parseLng(String s, int radix) {
	try {
	    return OptionalLong.of(Long.parseLong(s, radix));
	} catch (NumberFormatException e) {
	    return OptionalLong.empty();
	}
    }

    public static OptionalLong parseNonZeroLng(String s, int radix) {
	try {
	    return OptionalLong.of(requireNonZero(Long.parseLong(s, radix)));
	} catch (IllegalArgumentException e) {
	    // also catches NumberFormatException
	    return OptionalLong.empty();
	}
    }

    // boxed

    public static Optional<Long> valueOfLng(String s) {
	try {
	    return Optional.of(Long.valueOf(s));
	} catch (NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Long> nonZeroValueOfLng(String s) {
	try {
	    return MyOptionals.of(Long.valueOf(s));
	} catch (NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Long> valueOfLng(String s, int radix) {
	try {
	    return Optional.of(Long.valueOf(s, radix));
	} catch (NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Long> nonZeroValueOfLng(String s, int radix) {
	try {
	    return MyOptionals.of(Long.valueOf(s, radix));
	} catch (NumberFormatException e) {
	    return Optional.empty();
	}
    }
}
