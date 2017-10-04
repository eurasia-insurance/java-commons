package com.lapsa.commons.function;

import java.util.function.Function;

public final class MyObjects {

    private MyObjects() {
    }

    //

    public static <T> boolean nonNull(T obj) {
	return obj != null;
    }

    public static <T> T requireNonNull(T obj) {
	return requireNonNull(obj, "is a null object");
    }

    public static <T> T requireNonNull(T obj, String message) {
	if (nonNull(obj))
	    return obj;
	throw new IllegalArgumentException(message);
    }

    //

    public static <T> boolean isNull(T obj) {
	return obj == null;
    }

    public static <T> T requireNull(T obj) {
	return requireNull(obj, "is a non-null object");
    }

    public static <T> T requireNull(T obj, String message) {
	if (isNull(obj))
	    return obj;
	throw new IllegalArgumentException(message);
    }

    //

    public static final boolean isA(Object x, Class<?> clazz) {
	requireNonNull(clazz);
	return x != null && clazz.isAssignableFrom(x.getClass());
    }

    public static final <T> T requireA(T x, Class<?> clazz) {
	requireNonNull(clazz);
	return requireA(x, clazz, "is not a " + clazz.getName());
    }

    public static final <T> T requireA(T x, Class<?> clazz, String message) {
	if (isA(x, clazz))
	    return x;
	throw new IllegalArgumentException(message);
    }

    //

    public static final boolean isNotA(Object x, Class<?> clazz) {
	return !isA(x, clazz);
    }

    public static final <T> T requireNotA(T x, Class<?> clazz) {
	requireNonNull(clazz);
	return requireNotA(x, clazz, "is a " + clazz.getName());
    }

    public static final <T> T requireNotA(T x, Class<?> clazz, String message) {
	if (isNotA(x, clazz))
	    return x;
	throw new IllegalArgumentException(message);
    }

    //

    public static final <T> Function<Object, T> cast(Class<T> clazz) {
	return clazz::cast;
    }

}
