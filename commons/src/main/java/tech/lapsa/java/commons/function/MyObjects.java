package com.lapsa.commons.function;

import java.util.function.Function;

public final class MyObjects {

    private static final String IS_A_NON_NULL_OBJECT = "Is not null";
    private static final String IS_A_NULL_OBJECT = "Is null";

    private MyObjects() {
    }

    //

    public static <T> boolean nonNull(T obj) {
	return obj != null;
    }

    public static <T> T requireNonNull(T obj) {
	return requireNonNull(obj, null);
    }

    public static <T> T requireNonNull(T obj, String par) {
	if (nonNull(obj))
	    return obj;
	throw MyExceptions.illegalArgumentException(IS_A_NULL_OBJECT, par);
    }

    //

    public static <T> boolean isNull(T obj) {
	return obj == null;
    }

    public static <T> T requireNull(T obj) {
	return requireNull(obj, null);
    }

    public static <T> T requireNull(T obj, String par) {
	if (isNull(obj))
	    return obj;
	throw MyExceptions.illegalArgumentException(IS_A_NON_NULL_OBJECT, par);
    }

    //

    public static final boolean isA(Object obj, Class<?> clazz) {
	requireNonNull(clazz, "clazz");
	return obj != null && clazz.isAssignableFrom(obj.getClass());
    }

    public static final <T> T requireA(T obj, Class<?> clazz) {
	requireNonNull(clazz, "clazz");
	return requireA(obj, clazz, null);
    }

    public static final <T> T requireA(T obj, Class<?> clazz, String par) {
	if (isA(obj, clazz))
	    return obj;
	throw MyExceptions.illegalArgumentException("Is not a " + clazz.getName(), par);
    }

    //

    public static final boolean isNotA(Object obj, Class<?> clazz) {
	return !isA(obj, clazz);
    }

    public static final <T> T requireNotA(T obj, Class<?> clazz) {
	requireNonNull(clazz);
	return requireNotA(obj, clazz, null);
    }

    public static final <T> T requireNotA(T obj, Class<?> clazz, String par) {
	if (isNotA(obj, clazz))
	    return obj;
	throw MyExceptions.illegalArgumentException("Is a " + clazz.getName(), par);
    }

    //

    public static final <T> Function<Object, T> cast(Class<T> clazz) {
	return clazz::cast;
    }

}
