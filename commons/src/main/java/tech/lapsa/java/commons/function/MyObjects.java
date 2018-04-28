package tech.lapsa.java.commons.function;

import java.util.Optional;
import java.util.function.Function;

public final class MyObjects {

    private static final String DEFAULT_PAR = "object";

    private MyObjects() {
    }

    //

    public static <T> boolean nonNull(final T obj) {
	return obj != null;
    }

    // reqs

    public static <T> T requireNonNull(final T obj) throws IllegalArgumentException {
	return requireNonNull(IllegalArgumentException::new, obj);
    }

    public static <T> T requireNonNull(final T obj, final String par) throws IllegalArgumentException {
	return requireNonNull(IllegalArgumentException::new, obj, par);
    }

    public static <T> T requireNonNullMsg(final T obj, final String message, final Object... args)
	    throws IllegalArgumentException {
	return requireNonNullMsg(IllegalArgumentException::new, obj, message, args);
    }

    // with creators

    private static final String IS_A_NULL_OBJECT = "%1$s is null";

    public static <T, X extends Exception> T requireNonNull(final Function<String, X> creator, final T obj) throws X {
	return requireNonNull(creator, obj, DEFAULT_PAR);
    }

    public static <T, X extends Exception> T requireNonNull(final Function<String, X> creator, final T obj,
	    final String par) throws X {
	return requireNonNullMsg(creator, obj, IS_A_NULL_OBJECT, par);
    }

    public static <T, X extends Exception> T requireNonNullMsg(final Function<String, X> creator, final T obj,
	    final String message, final Object... args) throws X {
	if (nonNull(obj))
	    return obj;
	throw MyExceptions.format(creator, message, args);
    }

    //

    public static <T> boolean isNull(final T obj) {
	return obj == null;
    }

    // reqs

    public static <T> T requireNull(final T obj) throws IllegalArgumentException {
	return requireNull(IllegalArgumentException::new, obj);
    }

    public static <T> T requireNull(final T obj, final String par) throws IllegalArgumentException {
	return requireNull(IllegalArgumentException::new, obj, par);
    }

    public static <T> T requireNullMsg(final T obj, final String message, final Object... args)
	    throws IllegalArgumentException {
	return requireNullMsg(IllegalArgumentException::new, obj, message, args);
    }

    // with creators

    private static final String IS_A_NOT_NULL_OBJECT = "%1$s is not null";

    public static <T, X extends Exception> T requireNull(final Function<String, X> creator, final T obj) throws X {
	return requireNull(creator, obj, DEFAULT_PAR);
    }

    public static <T, X extends Exception> T requireNull(final Function<String, X> creator, final T obj,
	    final String par) throws X {
	return requireNullMsg(creator, obj, IS_A_NOT_NULL_OBJECT, par);
    }

    public static <T, X extends Exception> T requireNullMsg(final Function<String, X> creator, final T obj,
	    final String message, final Object... args) throws X {
	if (isNull(obj))
	    return obj;
	throw MyExceptions.format(creator, message, args);
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

    // reqs

    public static final <T> T requireA(final Object obj, final Class<T> clazz) throws IllegalArgumentException {
	return requireA(IllegalArgumentException::new, obj, clazz);
    }

    public static final <T> T requireA(final Object obj, final Class<T> clazz, final String par)
	    throws IllegalArgumentException {
	return requireA(IllegalArgumentException::new, obj, clazz, par);
    }

    public static final <T> T requireAMsg(final Object obj, final Class<T> clazz, final String message,
	    final Object... args) throws IllegalArgumentException {
	return requireAMsg(IllegalArgumentException::new, obj, clazz, message, args);
    }

    // with creators

    private static final String IS_NOT_A = "%1$s is not a %2$s";

    public static final <T, X extends Exception> T requireA(final Function<String, X> creator, final Object obj,
	    final Class<T> clazz) throws X {
	return requireA(creator, obj, clazz, DEFAULT_PAR);
    }

    public static final <T, X extends Exception> T requireA(final Function<String, X> creator, final Object obj,
	    final Class<T> clazz, final String par) throws X {
	return requireAMsg(creator, obj, clazz, IS_NOT_A, par, clazz);
    }

    public static final <T, X extends Exception> T requireAMsg(final Function<String, X> creator, final Object obj,
	    final Class<T> clazz, final String message, final Object... args) throws X {
	if (isA(obj, clazz))
	    return clazz.cast(obj);
	throw MyExceptions.format(creator, message, args);
    }

    //

    public static final boolean isNotA(final Object obj, final Class<?> clazz) {
	return !isA(obj, clazz);
    }

    // reqs

    public static final <T> T requireNotA(final T obj, final Class<?> clazz) throws IllegalArgumentException {
	return requireNotA(IllegalArgumentException::new, obj, clazz);
    }

    public static final <T> T requireNotA(final T obj, final Class<?> clazz, final String par)
	    throws IllegalArgumentException {
	return requireNotA(IllegalArgumentException::new, obj, clazz, par);
    }

    public static final <T> T requireNotAMsg(final T obj, final Class<?> clazz, final String message,
	    final Object... args) throws IllegalArgumentException {
	return requireNotAMsg(IllegalArgumentException::new, obj, clazz, message, args);
    }

    // with creators

    private static final String IS_A = "%1$s is a %2$s";

    public static final <T, X extends Exception> T requireNotA(final Function<String, X> creator, final T obj,
	    final Class<?> clazz) throws X {
	return requireNotA(creator, obj, clazz, DEFAULT_PAR);
    }

    public static final <T, X extends Exception> T requireNotA(final Function<String, X> creator, final T obj,
	    final Class<?> clazz, final String par) throws X {
	return requireNotAMsg(creator, obj, clazz, IS_A, par, clazz);
    }

    public static final <T, X extends Exception> T requireNotAMsg(final Function<String, X> creator, final T obj,
	    final Class<?> clazz, final String message, final Object... args) throws X {
	if (isNotA(obj, clazz))
	    return obj;
	throw MyExceptions.format(creator, message, args);
    }

    //

    public static final <T> Function<Object, T> cast(final Class<T> clazz) {
	requireNonNull(clazz, "clazz");
	return clazz::cast;
    }

    public static final <T> Function<Object, T> castOrNull(final Class<T> clazz) {
	requireNonNull(clazz, "clazz");
	return x -> MyOptionals.of(x) //
		.filter(xx -> clazz.isAssignableFrom(xx.getClass())) //
		.map(clazz::cast) //
		.orElse(null);
    }

    //

    public static <T, R> R nullOrGet(T value, final Function<T, R> function) {
	return isNull(value)
		? null
		: MyObjects.requireNonNull(function, "function").apply(value);
    }

}
