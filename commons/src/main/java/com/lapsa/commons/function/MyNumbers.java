package com.lapsa.commons.function;

public final class MyNumbers {

    private static final String DEFAULT_EXCEPTION_NON_ZERO_NUMBER = "non-zero number";
    private static final String DEFAULT_EXCEPTION_ZERO_NUMBER = "zero number";

    private MyNumbers() {
    }

    // Number

    public static <T extends Number> boolean zero(final T number) {
	return MyObjects.isNull(number) || zero(number.doubleValue()); // double
								       // is the
								       // widest
								       // numeric
								       // type
    }

    public static <T extends Number> boolean nonZero(final T number) {
	return !zero(number);
    }

    public static <T extends Number> T requireNonZero(final T number) {
	if (nonZero(number))
	    return number;
	throw new IllegalArgumentException(DEFAULT_EXCEPTION_ZERO_NUMBER);
    }

    public static <T extends Number> T requireNonZero(final T number, String message) {
	if (nonZero(number))
	    return number;
	throw new IllegalArgumentException(message);
    }

    public static <T extends Number> T requireZero(final T number) {
	if (zero(number))
	    return number;
	throw new IllegalArgumentException(DEFAULT_EXCEPTION_NON_ZERO_NUMBER);
    }

    public static <T extends Number> T requireZero(final T number, String message) {
	if (zero(number))
	    return number;
	throw new IllegalArgumentException(message);
    }

    // long

    public static boolean zero(final long number) {
	return number == 0;
    }

    public static boolean nonZero(final long number) {
	return !zero(number);
    }

    public static long requireNonZero(final long number) {
	if (nonZero(number))
	    return number;
	throw new IllegalArgumentException(DEFAULT_EXCEPTION_ZERO_NUMBER);
    }

    public static long requireNonZero(final long number, String message) {
	if (nonZero(number))
	    return number;
	throw new IllegalArgumentException(message);
    }

    public static long requireZero(final long number) {
	if (zero(number))
	    return number;
	throw new IllegalArgumentException(DEFAULT_EXCEPTION_NON_ZERO_NUMBER);
    }

    public static long requireZero(final long number, String message) {
	if (zero(number))
	    return number;
	throw new IllegalArgumentException(message);
    }

    // double

    public static boolean zero(final double number) {
	return number == 0;
    }

    public static boolean nonZero(final double number) {
	return !zero(number);
    }

    public static double requireNonZero(final double number) {
	if (nonZero(number))
	    return number;
	throw new IllegalArgumentException(DEFAULT_EXCEPTION_ZERO_NUMBER);

    }

    public static double requireNonZero(final double number, String message) {
	if (nonZero(number))
	    return number;
	throw new IllegalArgumentException(message);
    }

    public static double requireZero(final double number) {
	if (zero(number))
	    return number;
	throw new IllegalArgumentException(DEFAULT_EXCEPTION_NON_ZERO_NUMBER);
    }

    public static double requireZero(final double number, String message) {
	if (zero(number))
	    return number;
	throw new IllegalArgumentException(message);
    }

    // int

    public static boolean zero(final int number) {
	return number == 0;
    }

    public static boolean nonZero(final int number) {
	return !zero(number);
    }

    public static int requireNonZero(final int number) {
	if (nonZero(number))
	    return number;
	throw new IllegalArgumentException(DEFAULT_EXCEPTION_ZERO_NUMBER);
    }

    public static int requireNonZero(final int number, String message) {
	if (nonZero(number))
	    return number;
	throw new IllegalArgumentException(message);
    }

    public static int requireZero(final int number) {
	if (zero(number))
	    return number;
	throw new IllegalArgumentException(DEFAULT_EXCEPTION_NON_ZERO_NUMBER);
    }

    public static int requireZero(final int number, String message) {
	if (zero(number))
	    return number;
	throw new IllegalArgumentException(message);
    }

}
