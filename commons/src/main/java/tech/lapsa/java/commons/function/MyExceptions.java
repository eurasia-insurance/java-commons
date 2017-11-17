package tech.lapsa.java.commons.function;

import java.util.StringJoiner;
import java.util.function.Supplier;

public final class MyExceptions {

    private MyExceptions() {
    }

    // TODO REFACTOR : Need to refactor

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

    public static class IllegalArgument extends Exception {

	private static final long serialVersionUID = 1L;

	private final IllegalArgumentException runtime;

	public IllegalArgument(final IllegalArgumentException cause) {
	    super(cause);
	    runtime = cause;
	}

	public IllegalArgumentException getRuntime() {
	    return runtime;
	}
    }

    public static class IllegalState extends Exception {

	private static final long serialVersionUID = 1L;

	private final IllegalStateException runtime;

	public IllegalState(final IllegalStateException cause) {
	    super(cause);
	    runtime = cause;
	}

	public IllegalStateException getRuntime() {
	    return runtime;
	}
    }

    public static IllegalArgumentException illegalArgumentException(final String message, final String par,
	    final String value) {
	final StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(value))
	    sj.add("'" + value + "'");
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	return new IllegalArgumentException(sj.toString());
    }

    public static IllegalArgumentException illegalArgumentException(final String message, final String par,
	    final String value, final Throwable cause) {
	final StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(value))
	    sj.add("'" + value + "'");
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	return new IllegalArgumentException(sj.toString(), cause);
    }

    public static IllegalArgumentException illegalArgumentException(final String message, final String par) {
	final StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	return new IllegalArgumentException(sj.toString());
    }

    public static IllegalArgumentException illegalArgumentException(final String message, final String par,
	    final Throwable cause) {
	final StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	return new IllegalArgumentException(sj.toString(), cause);
    }

    // format

    public static IllegalArgumentException illegalArgumentFormat(final String format, final Object... args) {
	return new IllegalArgumentException(MyStrings.format(format, args));
    }

    public static IllegalStateException illegalStateFormat(final String format, final Object... args) {
	return new IllegalStateException(MyStrings.format(format, args));
    }

    // supplier

    public static Supplier<IllegalArgumentException> illegalArgumentSupplierFormat(final String format,
	    final Object... args) {
	return () -> illegalArgumentFormat(format, args);
    }

    public static Supplier<IllegalStateException> illegalStateSupplierFormat(final String format,
	    final Object... args) {
	return () -> illegalStateFormat(format, args);
    }
}
