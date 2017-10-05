package com.lapsa.commons.function;

public final class MyNumbers {

    private static final String NON_ZERO_NUMBER = "Is not zero";
    private static final String ZERO_NUMBER = "Is zero";

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
	return requireNonZero(number, null);
    }

    public static <T extends Number> T requireNonZero(final T number, String par) {
	if (nonZero(number))
	    return number;
	throw Exceptions.illegalArgumentException(ZERO_NUMBER, par, String.valueOf(number));
    }

    public static <T extends Number> T requireZero(final T number) {
	return requireZero(number, null);
    }

    public static <T extends Number> T requireZero(final T number, String par) {
	if (zero(number))
	    return number;
	throw Exceptions.illegalArgumentException(NON_ZERO_NUMBER, par, String.valueOf(number));
    }

    // long

    public static boolean zero(final long number) {
	return number == 0;
    }

    public static boolean nonZero(final long number) {
	return !zero(number);
    }

    public static long requireNonZero(final long number) {
	return requireNonZero(number, null);
    }

    public static long requireNonZero(final long number, String par) {
	if (nonZero(number))
	    return number;
	throw Exceptions.illegalArgumentException(ZERO_NUMBER, par, String.valueOf(number));
    }

    public static long requireZero(final long number) {
	return requireZero(number, null);
    }

    public static long requireZero(final long number, String par) {
	if (zero(number))
	    return number;
	throw Exceptions.illegalArgumentException(NON_ZERO_NUMBER, par, String.valueOf(number));
    }

    // double

    public static boolean zero(final double number) {
	return number == 0;
    }

    public static boolean nonZero(final double number) {
	return !zero(number);
    }

    public static double requireNonZero(final double number) {
	return requireNonZero(number, null);
    }

    public static double requireNonZero(final double number, String par) {
	if (nonZero(number))
	    return number;
	throw Exceptions.illegalArgumentException(ZERO_NUMBER, par, String.valueOf(number));
    }

    public static double requireZero(final double number) {
	return requireZero(number, null);
    }

    public static double requireZero(final double number, String par) {
	if (zero(number))
	    return number;
	throw Exceptions.illegalArgumentException(NON_ZERO_NUMBER, par, String.valueOf(number));
    }

    // int

    public static boolean zero(final int number) {
	return number == 0;
    }

    public static boolean nonZero(final int number) {
	return !zero(number);
    }

    public static int requireNonZero(final int number) {
	return requireNonZero(number, null);
    }

    public static int requireNonZero(final int number, String par) {
	if (nonZero(number))
	    return number;
	throw Exceptions.illegalArgumentException(ZERO_NUMBER, par, String.valueOf(number));
    }

    public static int requireZero(final int number) {
	return requireZero(number, null);
    }

    public static int requireZero(final int number, String par) {
	if (zero(number))
	    return number;
	throw Exceptions.illegalArgumentException(NON_ZERO_NUMBER, par, String.valueOf(number));
    }

}
