package tech.lapsa.java.commons.function;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final class MyArrays {

    private MyArrays() {
    }

    private static final String ARRAY_IS_EMPTY = "Is empty";
    private static final String ARRAY_IS_NOT_EMPTY = "Is not empty";

    private static final String SOME_ELEMENTS_ARE_ZEROED = "Has some zero elements";
    private static final String SOME_ELEMENTS_ARE_NOT_ZEROED = "Has some non-zero element";

    private static final String SOME_ELEMENTS_ARE_NULL = "Has some null elements";
    private static final String SOME_ELEMENTS_ARE_NOT_NULL = "Has some non-null element";

    // LONG

    public static boolean empty(final long[] array) {
	return MyObjects.isNull(array) || array.length == 0;
    }

    public static long[] requireEmpty(final long[] array) throws IllegalArgumentException {
	return requireEmpty(array, null);
    }

    public static long[] requireEmpty(final long[] array, final String parameter) throws IllegalArgumentException {
	if (empty(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(ARRAY_IS_NOT_EMPTY, parameter);
    }

    //

    public static boolean nonEmpty(final long[] array) {
	return !empty(array);
    }

    public static long[] requireNonEmpty(final long[] array) throws IllegalArgumentException {
	return requireNonEmpty(array, null);
    }

    public static long[] requireNonEmpty(final long[] array, final String parameter) throws IllegalArgumentException {
	if (nonEmpty(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(ARRAY_IS_EMPTY, parameter);
    }

    //

    public static boolean nonZeroElements(final long[] array) throws IllegalArgumentException {
	return LongStream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyNumbers::nonZero);
    }

    public static long[] requireNonZeroElements(final long[] array) throws IllegalArgumentException {
	return requireNonZeroElements(array, null);
    }

    public static long[] requireNonZeroElements(final long[] array, final String parameter)
	    throws IllegalArgumentException {
	if (nonZeroElements(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(SOME_ELEMENTS_ARE_ZEROED, parameter);
    }

    //

    public static boolean zeroElements(final long[] array) throws IllegalArgumentException {
	return LongStream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyNumbers::zero);
    }

    public static long[] requireZeroElements(final long[] array) throws IllegalArgumentException {
	return requireZeroElements(array, null);
    }

    public static long[] requireZeroElements(final long[] array, final String parameter)
	    throws IllegalArgumentException {
	if (zeroElements(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(SOME_ELEMENTS_ARE_NOT_ZEROED, parameter);
    }

    // INT

    public static boolean empty(final int[] array) {
	return MyObjects.isNull(array) || array.length == 0;
    }

    public static int[] requireEmpty(final int[] array) throws IllegalArgumentException {
	return requireEmpty(array, null);
    }

    public static int[] requireEmpty(final int[] array, final String parameter) throws IllegalArgumentException {
	if (empty(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(ARRAY_IS_NOT_EMPTY, parameter);
    }

    //

    public static boolean nonEmpty(final int[] array) {
	return !empty(array);
    }

    public static int[] requireNonEmpty(final int[] array) throws IllegalArgumentException {
	return requireNonEmpty(array, null);
    }

    public static int[] requireNonEmpty(final int[] array, final String parameter) throws IllegalArgumentException {
	if (nonEmpty(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(ARRAY_IS_EMPTY, parameter);
    }

    //

    public static boolean nonZeroElements(final int[] array) throws IllegalArgumentException {
	return IntStream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyNumbers::nonZero);
    }

    public static int[] requireNonZeroElements(final int[] array) throws IllegalArgumentException {
	return requireNonZeroElements(array, null);
    }

    public static int[] requireNonZeroElements(final int[] array, final String parameter)
	    throws IllegalArgumentException {
	if (nonZeroElements(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(SOME_ELEMENTS_ARE_ZEROED, parameter);
    }

    //

    public static boolean zeroElements(final int[] array) throws IllegalArgumentException {
	return IntStream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyNumbers::zero);
    }

    public static int[] requireZeroElements(final int[] array) throws IllegalArgumentException {
	return requireZeroElements(array, null);
    }

    public static int[] requireZeroElements(final int[] array, final String parameter) throws IllegalArgumentException {
	if (zeroElements(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(SOME_ELEMENTS_ARE_NOT_ZEROED, parameter);
    }

    // DOUBLE

    public static boolean empty(final double[] array) {
	return MyObjects.isNull(array) || array.length == 0;
    }

    public static double[] requireEmpty(final double[] array) {
	return requireEmpty(array, null);
    }

    public static double[] requireEmpty(final double[] array, final String parameter) {
	if (empty(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(ARRAY_IS_NOT_EMPTY, parameter);
    }

    //

    public static boolean nonEmpty(final double[] array) {
	return !empty(array);
    }

    public static double[] requireNonEmpty(final double[] array) throws IllegalArgumentException {
	return requireNonEmpty(array, null);
    }

    public static double[] requireNonEmpty(final double[] array, final String parameter)
	    throws IllegalArgumentException {
	if (nonEmpty(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(ARRAY_IS_EMPTY, parameter);
    }

    //

    public static boolean nonZeroElements(final double[] array) throws IllegalArgumentException {
	return DoubleStream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyNumbers::nonZero);
    }

    public static double[] requireNonZeroElements(final double[] array) throws IllegalArgumentException {
	return requireNonZeroElements(array, null);
    }

    public static double[] requireNonZeroElements(final double[] array, final String parameter)
	    throws IllegalArgumentException {
	if (nonZeroElements(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(SOME_ELEMENTS_ARE_ZEROED, parameter);
    }

    //

    public static boolean zeroElements(final double[] array) throws IllegalArgumentException {
	return DoubleStream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyNumbers::zero);
    }

    public static double[] requireZeroElements(final double[] array) throws IllegalArgumentException {
	return requireZeroElements(array, null);
    }

    public static double[] requireZeroElements(final double[] array, final String parameter)
	    throws IllegalArgumentException {
	if (zeroElements(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(SOME_ELEMENTS_ARE_NOT_ZEROED, parameter);
    }

    // T

    public static <T> boolean empty(final T[] array) {
	return MyObjects.isNull(array) || array.length == 0;
    }

    public static <T> T[] requireEmpty(final T[] array) throws IllegalArgumentException {
	return requireEmpty(array, null);
    }

    public static <T> T[] requireEmpty(final T[] array, final String parameter) throws IllegalArgumentException {
	if (empty(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(ARRAY_IS_NOT_EMPTY, parameter);
    }

    //

    public static <T> boolean nonEmpty(final T[] array) {
	return !empty(array);
    }

    public static <T> T[] requireNonEmpty(final T[] array) throws IllegalArgumentException {
	return requireNonEmpty(array, null);
    }

    public static <T> T[] requireNonEmpty(final T[] array, final String parameter) throws IllegalArgumentException {
	if (nonEmpty(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(ARRAY_IS_EMPTY, parameter);
    }

    //

    public static <T> boolean nonNullElements(final T[] array) throws IllegalArgumentException {
	return Stream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyObjects::nonNull);
    }

    public static <T> T[] requireNonNullElements(final T[] array) throws IllegalArgumentException {
	return requireNonNullElements(array, null);
    }

    public static <T> T[] requireNonNullElements(final T[] array, final String parameter)
	    throws IllegalArgumentException {
	if (nonNullElements(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(SOME_ELEMENTS_ARE_NULL, parameter);
    }

    //

    public static <T> boolean nullElements(final T[] array) throws IllegalArgumentException {
	return Stream.of(MyObjects.requireNonNull(array)) //
		.allMatch(MyObjects::isNull);
    }

    public static <T> T[] requireNullElements(final T[] array) throws IllegalArgumentException {
	return requireNullElements(array, null);
    }

    public static <T> T[] requireNullElements(final T[] array, final String parameter) throws IllegalArgumentException {
	if (nullElements(array)) //
	    return array;
	throw MyExceptions.illegalArgumentPar(SOME_ELEMENTS_ARE_NOT_NULL, parameter);
    }

    //

    public static byte[] reverse(final byte[] array) throws IllegalArgumentException {
	MyObjects.requireNonNull(array, "array");
	for (int i = 0; i < array.length / 2; i++) {
	    final byte t = array[i];
	    array[i] = array[array.length - i - 1];
	    array[array.length - i - 1] = t;
	}
	return array;
    }

    public static int[] reverse(final int[] array) throws IllegalArgumentException {
	MyObjects.requireNonNull(array, "array");
	for (int i = 0; i < array.length / 2; i++) {
	    final int t = array[i];
	    array[i] = array[array.length - i - 1];
	    array[array.length - i - 1] = t;
	}
	return array;
    }

    public static double[] reverse(final double[] array) throws IllegalArgumentException {
	MyObjects.requireNonNull(array, "array");
	for (int i = 0; i < array.length / 2; i++) {
	    final double t = array[i];
	    array[i] = array[array.length - i - 1];
	    array[array.length - i - 1] = t;
	}
	return array;
    }

    public static long[] reverse(final long[] array) throws IllegalArgumentException {
	MyObjects.requireNonNull(array, "array");
	for (int i = 0; i < array.length / 2; i++) {
	    final long t = array[i];
	    array[i] = array[array.length - i - 1];
	    array[array.length - i - 1] = t;
	}
	return array;
    }

    public static <T> T[] reverse(final T[] array) throws IllegalArgumentException {
	MyObjects.requireNonNull(array, "array");
	for (int i = 0; i < array.length / 2; i++) {
	    final T t = array[i];
	    array[i] = array[array.length - i - 1];
	    array[array.length - i - 1] = t;
	}
	return array;
    }
}
