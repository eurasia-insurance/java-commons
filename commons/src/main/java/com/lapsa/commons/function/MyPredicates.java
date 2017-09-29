package com.lapsa.commons.function;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public final class MyPredicates {

    private MyPredicates() {
    }

    //

    public static final <T> Predicate<T> isA(Class<?> clazz) {
	return x -> MyObjects.isA(x, clazz);
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
}
