package com.lapsa.commons.function;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final class MyArrays {

    private MyArrays() {
    }

    private static final String ARRAY_IS_EMPTY = "Array is empty";
    private static final String ARRAY_IS_NOT_EMPTY = "Array is not empty";

    private static final String SOME_ELEMENTS_ARE_ZEROED = "Some elements are zeroed";
    private static final String SOME_ELEMENTS_ARE_NOT_ZEROED = "Some elements are not zero";

    private static final String SOME_ELEMENTS_ARE_NULL = "Some elements are null";
    private static final String SOME_ELEMENTS_ARE_NOT_NULL = "Some elements are not null";

    // LONG

    public static boolean empty(final long[] array) {
	return MyObjects.isNull(array) || array.length == 0;
    }

    public static long[] requireEmpty(final long[] array) {
	return requireEmpty(array, ARRAY_IS_NOT_EMPTY);
    }

    public static long[] requireEmpty(final long[] array, final String message) {
	if (empty(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    //

    public static boolean nonEmpty(final long[] array) {
	return !empty(array);
    }

    public static long[] requireNonEmpty(final long[] array) {
	return requireNonEmpty(array, ARRAY_IS_EMPTY);
    }

    public static long[] requireNonEmpty(final long[] array, final String message) {
	if (nonEmpty(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    //

    public static boolean nonZeroElements(final long[] array) {
	return LongStream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyNumbers::nonZero);
    }

    public static long[] requireNonZeroElements(final long[] array) {
	return requireNonZeroElements(array, SOME_ELEMENTS_ARE_ZEROED);
    }

    public static long[] requireNonZeroElements(final long[] array, final String message) {
	if (nonZeroElements(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    //

    public static boolean zeroElements(final long[] array) {
	return LongStream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyNumbers::zero);
    }

    public static long[] requireZeroElements(final long[] array) {
	return requireZeroElements(array, SOME_ELEMENTS_ARE_NOT_ZEROED);
    }

    public static long[] requireZeroElements(final long[] array, final String message) {
	if (zeroElements(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    // INT

    public static boolean empty(final int[] array) {
	return MyObjects.isNull(array) || array.length == 0;
    }

    public static int[] requireEmpty(final int[] array) {
	return requireEmpty(array, ARRAY_IS_NOT_EMPTY);
    }

    public static int[] requireEmpty(final int[] array, final String message) {
	if (empty(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    //

    public static boolean nonEmpty(final int[] array) {
	return !empty(array);
    }

    public static int[] requireNonEmpty(final int[] array) {
	return requireNonEmpty(array, ARRAY_IS_EMPTY);
    }

    public static int[] requireNonEmpty(final int[] array, final String message) {
	if (nonEmpty(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    //

    public static boolean nonZeroElements(final int[] array) {
	return IntStream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyNumbers::nonZero);
    }

    public static int[] requireNonZeroElements(final int[] array) {
	return requireNonZeroElements(array, SOME_ELEMENTS_ARE_ZEROED);
    }

    public static int[] requireNonZeroElements(final int[] array, final String message) {
	if (nonZeroElements(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    //

    public static boolean zeroElements(final int[] array) {
	return IntStream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyNumbers::zero);
    }

    public static int[] requireZeroElements(final int[] array) {
	return requireZeroElements(array, SOME_ELEMENTS_ARE_NOT_ZEROED);
    }

    public static int[] requireZeroElements(final int[] array, final String message) {
	if (zeroElements(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    // DOUBLE

    public static boolean empty(final double[] array) {
	return MyObjects.isNull(array) || array.length == 0;
    }

    public static double[] requireEmpty(final double[] array) {
	return requireEmpty(array, ARRAY_IS_NOT_EMPTY);
    }

    public static double[] requireEmpty(final double[] array, final String message) {
	if (empty(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    //

    public static boolean nonEmpty(final double[] array) {
	return !empty(array);
    }

    public static double[] requireNonEmpty(final double[] array) {
	return requireNonEmpty(array, ARRAY_IS_EMPTY);
    }

    public static double[] requireNonEmpty(final double[] array, final String message) {
	if (nonEmpty(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    //

    public static boolean nonZeroElements(final double[] array) {
	return DoubleStream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyNumbers::nonZero);
    }

    public static double[] requireNonZeroElements(final double[] array) {
	return requireNonZeroElements(array, SOME_ELEMENTS_ARE_ZEROED);
    }

    public static double[] requireNonZeroElements(final double[] array, final String message) {
	if (nonZeroElements(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    //

    public static boolean zeroElements(final double[] array) {
	return DoubleStream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyNumbers::zero);
    }

    public static double[] requireZeroElements(final double[] array) {
	return requireZeroElements(array, SOME_ELEMENTS_ARE_NOT_ZEROED);
    }

    public static double[] requireZeroElements(final double[] array, final String message) {
	if (zeroElements(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    // T

    public static <T> boolean empty(final T[] array) {
	return MyObjects.isNull(array) || array.length == 0;
    }

    public static <T> T[] requireEmpty(final T[] array) {
	return requireEmpty(array, ARRAY_IS_NOT_EMPTY);
    }

    public static <T> T[] requireEmpty(final T[] array, final String message) {
	if (empty(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    //

    public static <T> boolean nonEmpty(final T[] array) {
	return !empty(array);
    }

    public static <T> T[] requireNonEmpty(final T[] array) {
	return requireNonEmpty(array, ARRAY_IS_EMPTY);
    }

    public static <T> T[] requireNonEmpty(final T[] array, final String message) {
	if (nonEmpty(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    //

    public static <T> boolean nonNullElements(final T[] array) {
	return Stream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyObjects::nonNull);
    }

    public static <T> T[] requireNonNullElements(final T[] array) {
	return requireNonNullElements(array, SOME_ELEMENTS_ARE_NULL);
    }

    public static <T> T[] requireNonNullElements(final T[] array, final String message) {
	if (nonNullElements(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }

    //

    public static <T> boolean nullElements(final T[] array) {
	return Stream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyObjects::isNull);
    }

    public static <T> T[] requireNullElements(final T[] array) {
	return requireNullElements(array, SOME_ELEMENTS_ARE_NOT_NULL);
    }

    public static <T> T[] requireNullElements(final T[] array, final String message) {
	if (nullElements(array)) //
	    return array;
	throw new IllegalArgumentException(message);
    }
}
