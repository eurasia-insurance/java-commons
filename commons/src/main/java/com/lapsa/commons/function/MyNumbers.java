package com.lapsa.commons.function;

import java.util.Objects;

public final class MyNumbers {

    private static final String DEFAULT_EXCEPTION_NON_ZERO_NUMBER = "non-zero number";
    private static final String DEFAULT_EXCEPTION_ZERO_NUMBER = "zero number";

    private MyNumbers() {
    }

    // Number

    public static <T extends Number> boolean zero(final T number) {
	return Objects.isNull(number) || zero(number.doubleValue()); // double
								     // is the
								     // widest
								     // numeric
								     // type
    }

    public static <T extends Number> boolean nonZero(final T number) {
	return !zero(number);
    }

    public static <T extends Number> T requireNonZero(final T number) {
	if (zero(number))
	    throw new IllegalArgumentException(DEFAULT_EXCEPTION_ZERO_NUMBER);
	return number;
    }

    public static <T extends Number> T requireNonZero(final T number, String message) {
	if (zero(number))
	    throw new IllegalArgumentException(message);
	return number;
    }

    public static <T extends Number> T requireZero(final T number) {
	if (nonZero(number))
	    throw new IllegalArgumentException(DEFAULT_EXCEPTION_NON_ZERO_NUMBER);
	return number;
    }

    public static <T extends Number> T requireZero(final T number, String message) {
	if (nonZero(number))
	    throw new IllegalArgumentException(message);
	return number;
    }

    // long

    public static boolean zero(final long number) {
	return number == 0;
    }

    public static boolean nonZero(final long number) {
	return !zero(number);
    }

    public static long requireNonZero(final long number) {
	if (zero(number))
	    throw new IllegalArgumentException(DEFAULT_EXCEPTION_ZERO_NUMBER);
	return number;
    }

    public static long requireNonZero(final long number, String message) {
	if (zero(number))
	    throw new IllegalArgumentException(message);
	return number;
    }

    public static long requireZero(final long number) {
	if (nonZero(number))
	    throw new IllegalArgumentException(DEFAULT_EXCEPTION_NON_ZERO_NUMBER);
	return number;
    }

    public static long requireZero(final long number, String message) {
	if (nonZero(number))
	    throw new IllegalArgumentException(message);
	return number;
    }

    // double

    public static boolean zero(final double number) {
	return number == 0;
    }

    public static boolean nonZero(final double number) {
	return !zero(number);
    }

    public static double requireNonZero(final double number) {
	if (zero(number))
	    throw new IllegalArgumentException(DEFAULT_EXCEPTION_ZERO_NUMBER);
	return number;
    }

    public static double requireNonZero(final double number, String message) {
	if (zero(number))
	    throw new IllegalArgumentException(message);
	return number;
    }

    public static double requireZero(final double number) {
	if (nonZero(number))
	    throw new IllegalArgumentException(DEFAULT_EXCEPTION_NON_ZERO_NUMBER);
	return number;
    }

    public static double requireZero(final double number, String message) {
	if (nonZero(number))
	    throw new IllegalArgumentException(message);
	return number;
    }

    // int

    public static boolean zero(final int number) {
	return number == 0;
    }

    public static boolean nonZero(final int number) {
	return !zero(number);
    }

    public static int requireNonZero(final int number) {
	if (zero(number))
	    throw new IllegalArgumentException(DEFAULT_EXCEPTION_ZERO_NUMBER);
	return number;
    }

    public static int requireNonZero(final int number, String message) {
	if (zero(number))
	    throw new IllegalArgumentException(message);
	return number;
    }

    public static int requireZero(final int number) {
	if (nonZero(number))
	    throw new IllegalArgumentException(DEFAULT_EXCEPTION_NON_ZERO_NUMBER);
	return number;
    }

    public static int requireZero(final int number, String message) {
	if (nonZero(number))
	    throw new IllegalArgumentException(message);
	return number;
    }

}
