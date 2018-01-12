package tech.lapsa.java.commons.function;

import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import tech.lapsa.java.commons.exceptions.IllegalArgument;
import tech.lapsa.java.commons.exceptions.IllegalState;

public final class MyExceptions {

    private MyExceptions() {
    }

    // general

    // format

    public static <X extends Exception> X format(final Function<String, X> creator,
	    final String format,
	    final Object... args) {
	return creator.apply(MyStrings.format(format, args));
    }

    public static <X extends Exception> X format(final BiFunction<String, Exception, X> creator,
	    final Exception cause,
	    final String format,
	    final Object... args) {
	return creator.apply(MyStrings.format(format, args), cause);
    }

    // supplier

    public static <X extends Exception> Supplier<X> supplier(final Function<String, X> creator,
	    final String format,
	    final Object... args) {
	return () -> format(creator, format, args);
    }

    public static <X extends Exception> Supplier<X> supplier(final BiFunction<String, Exception, X> creator,
	    final Exception cause,
	    final String format,
	    final Object... args) {
	return () -> format(creator, cause, format, args);
    }

    // par

    public static <X extends Exception> X par(final Function<String, X> creator,
	    final String message,
	    final String par,
	    final String value) {
	final String msg = parMessage(message, par, value);
	return creator.apply(msg);
    }

    public static <X extends Exception> X par(final BiFunction<String, Exception, X> creator,
	    final Exception cause,
	    final String message,
	    final String par,
	    final String value) {
	final String msg = parMessage(message, par, value);
	return creator.apply(msg, cause);
    }

    public static <X extends Exception> X par(final Function<String, X> creator,
	    final String message,
	    final String par) {
	final String msg = parMessage(message, par);
	return creator.apply(msg);
    }

    public static <X extends Exception> X par(final BiFunction<String, Exception, X> creator,
	    final Exception cause,
	    final String message,
	    final String par) {
	final String msg = parMessage(message, par);
	return creator.apply(msg, cause);
    }

    // specifiers

    // format

    public static IllegalArgumentException illegalArgumentFormat(final String format,
	    final Object... args) {
	return format(IllegalArgumentException::new, format, args);
    }

    public static IllegalStateException illegalStateFormat(final String format,
	    final Object... args) {
	return format(IllegalStateException::new, format, args);
    }

    // supplier

    public static Supplier<IllegalArgumentException> illegalArgumentSupplier(final String format,
	    final Object... args) {
	return supplier(IllegalArgumentException::new, format, args);
    }

    public static Supplier<IllegalStateException> illegalStateSupplier(final String format,
	    final Object... args) {
	return supplier(IllegalStateException::new, format, args);
    }

    // par

    public static IllegalArgumentException illegalArgumentPar(final String message, final String par,
	    final String value) {
	return par(IllegalArgumentException::new, message, par, value);
    }

    public static IllegalArgumentException illegalArgumentPar(final String message, final String par,
	    final String value, final Exception cause) {
	return par(IllegalArgumentException::new, cause, message, par, value);
    }

    public static IllegalArgumentException illegalArgumentPar(final String message, final String par) {
	return par(IllegalArgumentException::new, message, par);
    }

    public static IllegalArgumentException illegalArgumentPar(final String message, final String par,
	    final Exception cause) {
	return par(IllegalArgumentException::new, cause, message, par);
    }

    // rethrowers

    public static <R, E extends Exception> R reThrowAsUnchecked(final ReThrowingSupplier<R, E> function) throws E {
	try {
	    return function.get();
	} catch (final IllegalArgument e) {
	    throw e.getRuntime();
	} catch (final IllegalState e) {
	    throw e.getRuntime();
	}
    }

    public static <E extends Exception> void reThrowAsUnchecked(final ReThrowingCallable<E> function) throws E {
	try {
	    function.call();
	} catch (final IllegalArgument e) {
	    throw e.getRuntime();
	} catch (final IllegalState e) {
	    throw e.getRuntime();
	}
    }

    @FunctionalInterface
    public static interface ReThrowingSupplier<T, E extends Exception> {
	T get() throws IllegalArgument, IllegalState, E;
    }

    @FunctionalInterface
    public static interface CheckedExceptionThrowingSupplier<T, E extends Exception> {
	T get() throws E;
    }

    @FunctionalInterface
    public static interface CheckedExceptionThrowingCallable<E extends Exception> {
	void call() throws E;
    }

    @FunctionalInterface
    public static interface ReThrowingCallable<E extends Exception> {
	void call() throws IllegalArgument, IllegalState, E;
    }

    public static <R, E extends Exception> R reThrowAsChecked(final ReThrowingSupplier<R, E> function)
	    throws IllegalArgument, IllegalState, E {
	try {
	    return function.get();
	} catch (final IllegalArgumentException e) {
	    throw new IllegalArgument(e);
	} catch (final IllegalStateException e) {
	    throw new IllegalState(e);
	}
    }

    public static <E extends Exception> void reThrowAsChecked(final ReThrowingCallable<E> function)
	    throws IllegalArgument, IllegalState, E {
	try {
	    function.call();
	} catch (final IllegalArgumentException e) {
	    throw new IllegalArgument(e);
	} catch (final IllegalStateException e) {
	    throw new IllegalState(e);
	}
    }

    //

    @FunctionalInterface
    public interface ThrowingConsumer<T> {
	void accept(T t) throws Exception;
    }

    public static <T> Consumer<T> consumerToRuntime(final ThrowingConsumer<T> consumer) {
	return t -> {
	    try {
		consumer.accept(t);
	    } catch (final Exception e) {
		throw new RuntimeException(e);
	    }
	};
    }

    @FunctionalInterface
    public interface ThrowigFunction<T, R> {
	R apply(T t) throws Exception;
    }

    public static <T, R> Function<T, R> functionToRuntime(final ThrowigFunction<T, R> function) {
	return t -> {
	    try {
		return function.apply(t);
	    } catch (final Exception e) {
		throw new RuntimeException(e);
	    }
	};
    }

    public static <T, R> Function<T, R> functionToException(final ThrowigFunction<T, R> function,
	    final Function<Exception, ? extends RuntimeException> creator) {
	return t -> {
	    try {
		return function.apply(t);
	    } catch (final Exception e) {
		throw creator.apply(e);
	    }
	};
    }

    public static <T, R> Function<T, R> functionToNull(final ThrowigFunction<T, R> function) {
	return t -> {
	    try {
		return function.apply(t);
	    } catch (final Exception e) {
		return null;
	    }
	};
    }

    @FunctionalInterface
    public interface ThrowigPredicate<T> {
	boolean test(T t) throws Exception;
    }

    public static <T> Predicate<T> predicateToRuntime(final ThrowigPredicate<T> predicate) {
	return t -> {
	    try {
		return predicate.test(t);
	    } catch (final Exception e) {
		throw new RuntimeException(e);
	    }
	};
    }

    public static <T> Predicate<T> predicateToException(final ThrowigPredicate<T> predicate,
	    final Function<Exception, ? extends RuntimeException> creator) {
	return t -> {
	    try {
		return predicate.test(t);
	    } catch (final Exception e) {
		throw creator.apply(e);
	    }
	};
    }

    public static <T> Predicate<T> predicateToFalse(final ThrowigPredicate<T> predicate) {
	return t -> {
	    try {
		return predicate.test(t);
	    } catch (final Exception e) {
		return false;
	    }
	};
    }

    public static <T> Predicate<T> predicateToTrue(final ThrowigPredicate<T> predicate) {
	return t -> {
	    try {
		return predicate.test(t);
	    } catch (final Exception e) {
		return true;
	    }
	};
    }

    @FunctionalInterface
    public interface ThrowigSupplier<T> {
	T get() throws Exception;
    }

    public static <T> Supplier<T> supplierToRuntime(final ThrowigSupplier<T> supplier) {
	return () -> {
	    try {
		return supplier.get();
	    } catch (final Exception e) {
		throw new RuntimeException(e);
	    }
	};
    }

    public static <T> Supplier<T> supplierToException(final ThrowigSupplier<T> supplier,
	    final Function<Exception, ? extends RuntimeException> creator) {
	return () -> {
	    try {
		return supplier.get();
	    } catch (final Exception e) {
		throw creator.apply(e);
	    }
	};
    }

    public static <T> Supplier<T> supplierToNull(final ThrowigSupplier<T> supplier) {
	return () -> {
	    try {
		return supplier.get();
	    } catch (final Exception e) {
		return null;
	    }
	};
    }

    // PRIVATE

    private static String parMessage(final String message, final String par, final String value) {
	final StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(value))
	    sj.add("'" + value + "'");
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	final String msg = sj.toString();
	return msg;
    }

    private static String parMessage(final String message, final String par) {
	final StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	final String msg = sj.toString();
	return msg;
    }

    // DEPRECATED

    @Deprecated
    public static <X extends IllegalArgumentException> X illegalArgumentFormat(final Function<String, X> creator,
	    final String format, final Object... args) {
	return format(creator, format, args);
    }

    @Deprecated
    public static <X extends IllegalStateException> X illegalStateFormat(final Function<String, X> creator,
	    final String format, final Object... args) {
	return format(creator, format, args);
    }

    @Deprecated
    public static <X extends RuntimeException> X runtimeExceptionFormat(final Function<String, X> creator,
	    final String format, final Object... args) {
	return format(creator, format, args);
    }

    @Deprecated
    public static Supplier<IllegalArgumentException> illegalArgumentSupplierFormat(final String format,
	    final Object... args) {
	return supplier(IllegalArgumentException::new, format, args);
    }

    @Deprecated
    public static Supplier<IllegalStateException> illegalStateSupplierFormat(final String format,
	    final Object... args) {
	return supplier(IllegalStateException::new, format, args);
    }

    @Deprecated
    public static <X extends RuntimeException> Supplier<X> runtimeExceptionSupplierFormat(
	    final Function<String, X> creator, final String format, final Object... args) {
	return supplier(creator, format, args);
    }

    @Deprecated
    public static IllegalArgumentException illegalArgumentException(final String message, final String par,
	    final String value) {
	return par(IllegalArgumentException::new, message, par, value);
    }

    @Deprecated
    public static IllegalArgumentException illegalArgumentException(final String message, final String par,
	    final String value, final Exception cause) {
	return par(IllegalArgumentException::new, cause, message, par, value);
    }

    @Deprecated
    public static IllegalArgumentException illegalArgumentException(final String message, final String par) {
	return par(IllegalArgumentException::new, message, par);
    }

    @Deprecated
    public static IllegalArgumentException illegalArgumentException(final String message, final String par,
	    final Exception cause) {
	return par(IllegalArgumentException::new, cause, message, par);
    }
}
