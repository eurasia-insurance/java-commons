package tech.lapsa.java.commons.function;

import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import tech.lapsa.java.commons.exceptions.IllegalArgument;

public final class MyPredicates {

    private MyPredicates() {
    }

    //

    public static final <T> Predicate<T> isA(final Class<?> clazz) {
	return x -> MyObjects.isA(x, clazz);
    }

    public static final <T> Predicate<T> isNotA(Class<?> clazz) {
	return x -> MyObjects.isNotA(x, clazz);
    }

    // String

    public static final Predicate<String> emptyString() {
	return MyStrings::empty;
    }

    public static final Predicate<String> nonEmptyString() {
	return MyStrings::nonEmpty;
    }

    // Number

    public static Predicate<? super Number> zeroNumber() {
	return MyNumbers::nonZero;
    }

    public static Predicate<? super Number> nonZeroNumber() {
	return MyNumbers::nonZero;
    }

    // int

    public static IntPredicate zeroInt() {
	return MyNumbers::zero;
    }

    public static IntPredicate nonZeroInt() {
	return MyNumbers::nonZero;
    }

    // double

    public static DoublePredicate zeroDouble() {
	return MyNumbers::zero;
    }

    public static DoublePredicate nonZeroDouble() {
	return MyNumbers::nonZero;
    }

    // long

    public static LongPredicate zeroLong() {
	return MyNumbers::zero;
    }

    public static LongPredicate nonZeroLong() {
	return MyNumbers::nonZero;
    }

    //

    @FunctionalInterface
    public static interface IllegalArgumentPredicate<T> {
	boolean test(T value) throws IllegalArgument;
    }

    public static <T> Predicate<T> wrapIllegalArgument(final IllegalArgumentPredicate<T> predicate) {
	return x -> {
	    try {
		return predicate.test(x);
	    } catch (final IllegalArgument e) {
		throw e.getRuntime();
	    }
	};
    }

    public static <T, X extends RuntimeException> Predicate<T> wrapIllegalArgument(
	    final IllegalArgumentPredicate<T> predicate,
	    final Function<IllegalArgument, X> runtimeCreator) {
	return x -> {
	    try {
		return predicate.test(x);
	    } catch (final IllegalArgument e) {
		throw runtimeCreator.apply(e);
	    }
	};
    }

    public static <T> Predicate<T> negate(Predicate<T> predicate) {
	return MyObjects.requireNonNull(predicate, "predicate").negate();
    }
}