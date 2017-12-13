package tech.lapsa.java.commons.function;

import java.util.Optional;
import java.util.function.Function;

public final class MyObjects {

    private static final String IS_A_NON_NULL_OBJECT = "Is not null";
    private static final String IS_A_NULL_OBJECT = "Is null";

    private MyObjects() {
    }

    //

    public static <T> boolean nonNull(final T obj) {
	return obj != null;
    }

    public static <T> T requireNonNull(final T obj) throws IllegalArgumentException {
	return requireNonNull(obj, null);
    }

    public static <T> T requireNonNull(final T obj, final String par) throws IllegalArgumentException {
	if (nonNull(obj))
	    return obj;
	throw MyExceptions.illegalArgumentException(IS_A_NULL_OBJECT, par);
    }

    public static <T> T requireNonNullMsg(final T obj, final String message, Object... args)
	    throws IllegalArgumentException {
	if (nonNull(obj))
	    return obj;
	throw MyExceptions.illegalArgumentFormat(message, args);
    }

    //

    public static <T> boolean isNull(final T obj) {
	return obj == null;
    }

    public static <T> T requireNull(final T obj) throws IllegalArgumentException {
	return requireNull(obj, null);
    }

    public static <T> T requireNull(final T obj, final String par) throws IllegalArgumentException {
	if (isNull(obj))
	    return obj;
	throw MyExceptions.illegalArgumentException(IS_A_NON_NULL_OBJECT, par);
    }

    public static <T> T requireNullMsg(final T obj, final String message, Object... args)
	    throws IllegalArgumentException {
	if (isNull(obj))
	    return obj;
	throw MyExceptions.illegalArgumentFormat(message, args);
    }

    //

    public static final boolean isA(final Object obj, final Class<?> clazz) {
	requireNonNull(clazz, "clazz");
	return obj != null && clazz.isAssignableFrom(obj.getClass());
    }

    public static final <T> Optional<T> optionalA(final Object obj, final Class<T> clazz) {
	if (isA(obj, clazz))
	    return MyOptionals.of(clazz.cast(obj));
	return Optional.empty();
    }

    public static final <T> T requireA(final Object obj, final Class<T> clazz) throws IllegalArgumentException {
	return requireA(obj, clazz, null);
    }

    public static final <T> T requireA(final Object obj, final Class<T> clazz, final String par)
	    throws IllegalArgumentException {
	if (isA(obj, clazz))
	    return clazz.cast(obj);
	throw MyExceptions.illegalArgumentException("Is not a " + clazz.getName(), par);
    }

    public static final <T> T requireAMsg(final Object obj, final Class<T> clazz, final String message,
	    Object... args) throws IllegalArgumentException {
	if (isA(obj, clazz))
	    return clazz.cast(obj);
	throw MyExceptions.illegalArgumentFormat(message, args);
    }

    //

    public static final boolean isNotA(final Object obj, final Class<?> clazz) {
	return !isA(obj, clazz);
    }

    public static final <T> T requireNotA(final T obj, final Class<?> clazz) throws IllegalArgumentException {
	return requireNotA(obj, clazz, null);
    }

    public static final <T> T requireNotA(final T obj, final Class<?> clazz, final String par)
	    throws IllegalArgumentException {
	if (isNotA(obj, clazz))
	    return obj;
	throw MyExceptions.illegalArgumentException("Is a " + clazz.getName(), par);
    }

    public static final <T> T requireNotAMsg(final T obj, final Class<?> clazz, final String message, Object... args)
	    throws IllegalArgumentException {
	if (isNotA(obj, clazz))
	    return obj;
	throw MyExceptions.illegalArgumentFormat(message, args);
    }

    //

    public static final <T> Function<Object, T> cast(final Class<T> clazz) {
	requireNonNull(clazz, "clazz");
	return clazz::cast;
    }

}
