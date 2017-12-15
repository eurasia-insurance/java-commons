package tech.lapsa.java.commons.function;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.Function;

public final class MyNumbers {

    private static final String DEFAULT_PAR = "number";

    private static final String NUMBERS_NOT_EQUALS = "Numbers are not equals";

    private MyNumbers() {
    }

    // Number

    public static <T extends Number> boolean zero(final T number) {
	return number == null || zero(number.doubleValue()); // double is the
							     // widest numeric
							     // type
    }

    // reqs

    public static <T extends Number> T requireZero(final T number) throws IllegalArgumentException {
	return requireZero(IllegalArgumentException::new, number);
    }

    public static <T extends Number> T requireZero(final T number, final String par) throws IllegalArgumentException {
	return requireZero(IllegalArgumentException::new, number, par);
    }

    public static <T extends Number> T requireZeroMsg(final T number, final String message, Object... args)
	    throws IllegalArgumentException {
	return requireZeroMsg(IllegalArgumentException::new, number, message, args);
    }

    // with creators

    private static final String NON_ZERO_NUMBER = "%1$s is not zero (=%2$s)";

    public static <T extends Number, X extends Throwable> T requireZero(final Function<String, X> creator,
	    final T number) throws X {
	return requireZero(creator, number, DEFAULT_PAR);
    }

    public static <T extends Number, X extends Throwable> T requireZero(final Function<String, X> creator,
	    final T number, final String par) throws X {
	return requireZeroMsg(creator, number, NON_ZERO_NUMBER, par, String.valueOf(number));
    }

    public static <T extends Number, X extends Throwable> T requireZeroMsg(final Function<String, X> creator,
	    final T number, final String message, Object... args) throws X {
	if (zero(number))
	    return number;
	throw MyExceptions.format(creator, NON_ZERO_NUMBER, args);
    }

    //

    public static <T extends Number> boolean nonZero(final T number) {
	return number != null && nonZero(number.doubleValue()); // double is the
								// widest
								// numeric type
    }

    // reqs

    public static <T extends Number> T requireNonZero(final T number) throws IllegalArgumentException {
	return requireNonZero(IllegalArgumentException::new, number);
    }

    public static <T extends Number> T requireNonZero(final T number, final String par)
	    throws IllegalArgumentException {
	return requireNonZero(IllegalArgumentException::new, number, par);
    }

    public static <T extends Number> T requireNonZeroMsg(final T number, final String message, Object... args)
	    throws IllegalArgumentException {
	return requireNonZeroMsg(IllegalArgumentException::new, number, message, args);
    }

    // with creators

    private static final String ZERO_NUMBER = "%1$s is zero";

    public static <T extends Number, X extends Throwable> T requireNonZero(final Function<String, X> creator,
	    final T number) throws X {
	return requireNonZero(creator, number, DEFAULT_PAR);
    }

    public static <T extends Number, X extends Throwable> T requireNonZero(final Function<String, X> creator,
	    final T number, final String par) throws X {
	return requireNonZeroMsg(creator, number, ZERO_NUMBER, par);
    }

    public static <T extends Number, X extends Throwable> T requireNonZeroMsg(final Function<String, X> creator,
	    final T number, final String message, Object... args) throws X {
	if (nonZero(number))
	    return number;
	throw MyExceptions.format(creator, message, args);
    }

    //

    public static <T extends Number> boolean positive(final T number) {
	return number != null && positive(number.doubleValue()); // double is
								 // the widest
								 // numeric type
    }

    // reqs

    public static <T extends Number> T requirePositive(final T number) throws IllegalArgumentException {
	return requirePositive(IllegalArgumentException::new, number);
    }

    public static <T extends Number> T requirePositive(final T number, final String par)
	    throws IllegalArgumentException {
	return requirePositive(IllegalArgumentException::new, number, par);
    }

    public static <T extends Number> T requirePositiveMsg(final T number, final String message, Object... args)
	    throws IllegalArgumentException {
	return requirePositiveMsg(IllegalArgumentException::new, number, message, args);
    }

    // with creators

    private static final String NON_POSITIVE_NUMBER = "%1$s is not positive, zero or null";

    public static <T extends Number, X extends Throwable> T requirePositive(final Function<String, X> creator,
	    final T number) throws X {
	return requirePositive(creator, number, DEFAULT_PAR);
    }

    public static <T extends Number, X extends Throwable> T requirePositive(final Function<String, X> creator,
	    final T number, final String par) throws X {
	return requirePositiveMsg(creator, number, NON_POSITIVE_NUMBER, par);
    }

    public static <T extends Number, X extends Throwable> T requirePositiveMsg(final Function<String, X> creator,
	    final T number, final String message, Object... args) throws X {
	if (positive(number))
	    return number;
	throw MyExceptions.format(creator, message, args);
    }

    // long

    public static boolean zero(final long number) {
	return number == 0;
    }

    public static long requireZero(final long number) throws IllegalArgumentException {
	return requireZero(number, null);
    }

    public static long requireZero(final long number, final String par) throws IllegalArgumentException {
	if (zero(number))
	    return number;
	throw MyExceptions.illegalArgumentPar(NON_ZERO_NUMBER, par, String.valueOf(number));
    }

    public static boolean nonZero(final long number) {
	return number != 0;
    }

    public static long requireNonZero(final long number) throws IllegalArgumentException {
	return requireNonZero(number, null);
    }

    public static long requireNonZero(final long number, final String par) throws IllegalArgumentException {
	if (nonZero(number))
	    return number;
	throw MyExceptions.illegalArgumentPar(ZERO_NUMBER, par, String.valueOf(number));
    }

    public static boolean positive(final long number) {
	return number > 0;
    }

    public static long requirePositive(final long number) throws IllegalArgumentException {
	return requirePositive(number, null);
    }

    public static long requirePositive(final long number, final String par) throws IllegalArgumentException {
	if (positive(number))
	    return number;
	throw MyExceptions.illegalArgumentPar(NON_POSITIVE_NUMBER, par, String.valueOf(number));
    }

    // TODOs IMPLEMENT : Implement requirers with creator

    // double

    public static boolean zero(final double number) {
	return number == 0;
    }

    public static double requireZero(final double number) throws IllegalArgumentException {
	return requireZero(number, null);
    }

    public static double requireZero(final double number, final String par) throws IllegalArgumentException {
	if (zero(number))
	    return number;
	throw MyExceptions.illegalArgumentPar(NON_ZERO_NUMBER, par, String.valueOf(number));
    }

    public static boolean nonZero(final double number) {
	return number != 0;
    }

    public static double requireNonZero(final double number) throws IllegalArgumentException {
	return requireNonZero(number, null);
    }

    public static double requireNonZero(final double number, final String par) throws IllegalArgumentException {
	if (nonZero(number))
	    return number;
	throw MyExceptions.illegalArgumentPar(ZERO_NUMBER, par, String.valueOf(number));
    }

    public static boolean positive(final double number) {
	return number > 0;
    }

    public static double requirePositive(final double number) throws IllegalArgumentException {
	return requirePositive(number, null);
    }

    public static double requirePositive(final double number, final String par) throws IllegalArgumentException {
	if (positive(number))
	    return number;
	throw MyExceptions.illegalArgumentPar(NON_POSITIVE_NUMBER, par, String.valueOf(number));
    }

    // int

    public static boolean zero(final int number) {
	return number == 0;
    }

    public static int requireZero(final int number) throws IllegalArgumentException {
	return requireZero(number, null);
    }

    public static int requireZero(final int number, final String par) throws IllegalArgumentException {
	if (zero(number))
	    return number;
	throw MyExceptions.illegalArgumentPar(NON_ZERO_NUMBER, par, String.valueOf(number));
    }

    public static boolean nonZero(final int number) {
	return number != 0;
    }

    public static int requireNonZero(final int number) throws IllegalArgumentException {
	return requireNonZero(number, null);
    }

    public static int requireNonZero(final int number, final String par) throws IllegalArgumentException {
	if (nonZero(number))
	    return number;
	throw MyExceptions.illegalArgumentPar(ZERO_NUMBER, par, String.valueOf(number));
    }

    public static boolean positive(final int number) {
	return number > 0;
    }

    public static int requirePositive(final int number) throws IllegalArgumentException {
	return requirePositive(number, null);
    }

    public static int requirePositive(final int number, final String par) throws IllegalArgumentException {
	if (positive(number))
	    return number;
	throw MyExceptions.illegalArgumentPar(NON_POSITIVE_NUMBER, par, String.valueOf(number));
    }

    //

    public static <N1 extends Number, N2 extends Number> boolean numbericEquals(final N1 n1, final N2 n2) {
	return n1 != null && n2 != null && n1.doubleValue() == n2.doubleValue();
    }

    public static <N extends Number> boolean equals(final N n1, final N n2) {
	return n1 != null && n2 != null && n1.equals(n2);
    }

    public static <N extends Number> void requireEquals(final N n1, final N n2) throws IllegalArgumentException {
	if (!numbericEquals(n1, n2))
	    throw MyExceptions.illegalArgumentPar(NUMBERS_NOT_EQUALS, "n1 and n2",
		    "'" + n1 + "' and '" + n2 + "'");
    }

    public static <N extends Number> void requireEqualsMsg(final N n1, final N n2, final String message,
	    Object... args) throws IllegalArgumentException {
	requireEqualsMsg(IllegalArgumentException::new, n1, n2, message, args);
    }

    public static <N extends Number, X extends Throwable> void requireEqualsMsg(final Function<String, X> creator,
	    final N n1, final N n2, final String message,
	    Object... args) throws X {
	if (!numbericEquals(n1, n2))
	    throw MyExceptions.format(creator, message, args);
    }

    // parsers

    // int

    // primitive

    public static OptionalInt parseInt(final String s) {
	try {
	    return OptionalInt.of(Integer.parseInt(s));
	} catch (final NumberFormatException e) {
	    return OptionalInt.empty();
	}
    }

    public static OptionalInt parseNonZeroInt(final String s) {
	try {
	    return OptionalInt.of(requireNonZero(Integer.parseInt(s)));
	} catch (final IllegalArgumentException e) {
	    // also catches NumberFormatException
	    return OptionalInt.empty();
	}
    }

    public static OptionalInt parseInt(final String s, final int radix) {
	try {
	    return OptionalInt.of(Integer.parseInt(s, radix));
	} catch (final NumberFormatException e) {
	    return OptionalInt.empty();
	}
    }

    public static OptionalInt parseNonZeroInt(final String s, final int radix) {
	try {
	    return OptionalInt.of(requireNonZero(Integer.parseInt(s, radix)));
	} catch (final IllegalArgumentException e) {
	    // also catches NumberFormatException
	    return OptionalInt.empty();
	}
    }

    // boxed

    public static Optional<Integer> valueOfInt(final String s) {
	try {
	    return Optional.of(Integer.valueOf(s));
	} catch (final NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Integer> nonZeroValueOfInt(final String s) {
	try {
	    return MyOptionals.of(Integer.valueOf(s));
	} catch (final NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Integer> valueOfInt(final String s, final int radix) {
	try {
	    return Optional.of(Integer.valueOf(s, radix));
	} catch (final NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Integer> nonZeroValueOfInt(final String s, final int radix) {
	try {
	    return MyOptionals.of(Integer.valueOf(s, radix));
	} catch (final NumberFormatException e) {
	    return Optional.empty();
	}
    }

    // double

    // primitive

    public static OptionalDouble parseDbl(final String s) {
	try {
	    return OptionalDouble.of(Double.parseDouble(s));
	} catch (final NumberFormatException e) {
	    return OptionalDouble.empty();
	}
    }

    public static OptionalDouble parseNonZeroDbl(final String s) {
	try {
	    return OptionalDouble.of(requireNonZero(Double.parseDouble(s)));
	} catch (final IllegalArgumentException e) {
	    // also catches NumberFormatException
	    return OptionalDouble.empty();
	}
    }

    // boxed

    public static Optional<Double> valueOfDbl(final String doubleStr) {
	try {
	    return Optional.of(Double.valueOf(doubleStr));
	} catch (final NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Double> nonZeroValueOfDbl(final String s) {
	try {
	    return MyOptionals.of(Double.valueOf(s));
	} catch (final NumberFormatException e) {
	    return Optional.empty();
	}
    }

    // long

    // primitive

    public static OptionalLong parseLng(final String s) {
	try {
	    return OptionalLong.of(Long.parseLong(s));
	} catch (final NumberFormatException e) {
	    return OptionalLong.empty();
	}
    }

    public static OptionalLong parseNonZeroLng(final String s) {
	try {
	    return OptionalLong.of(requireNonZero(Long.parseLong(s)));
	} catch (final IllegalArgumentException e) {
	    // also catches NumberFormatException
	    return OptionalLong.empty();
	}
    }

    public static OptionalLong parseLng(final String s, final int radix) {
	try {
	    return OptionalLong.of(Long.parseLong(s, radix));
	} catch (final NumberFormatException e) {
	    return OptionalLong.empty();
	}
    }

    public static OptionalLong parseNonZeroLng(final String s, final int radix) {
	try {
	    return OptionalLong.of(requireNonZero(Long.parseLong(s, radix)));
	} catch (final IllegalArgumentException e) {
	    // also catches NumberFormatException
	    return OptionalLong.empty();
	}
    }

    // boxed

    public static Optional<Long> valueOfLng(final String s) {
	try {
	    return Optional.of(Long.valueOf(s));
	} catch (final NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Long> nonZeroValueOfLng(final String s) {
	try {
	    return MyOptionals.of(Long.valueOf(s));
	} catch (final NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Long> valueOfLng(final String s, final int radix) {
	try {
	    return Optional.of(Long.valueOf(s, radix));
	} catch (final NumberFormatException e) {
	    return Optional.empty();
	}
    }

    public static Optional<Long> nonZeroValueOfLng(final String s, final int radix) {
	try {
	    return MyOptionals.of(Long.valueOf(s, radix));
	} catch (final NumberFormatException e) {
	    return Optional.empty();
	}
    }

    //

    public static double safeUnbox(final Double boxed) {
	return boxed == null ? 0 : boxed.doubleValue();
    }

    public static int safeUnbox(final Integer boxed) {
	return boxed == null ? 0 : boxed.intValue();
    }

    public static long safeUnbox(final Long boxed) {
	return boxed == null ? 0 : boxed.longValue();
    }
}
