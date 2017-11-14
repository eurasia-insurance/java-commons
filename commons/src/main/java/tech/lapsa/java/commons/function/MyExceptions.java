package tech.lapsa.java.commons.function;

import java.util.StringJoiner;

public final class MyExceptions {

    private MyExceptions() {
    }

    // TODO REFACTOR : Need to refactor

    public static <R, E extends Exception> R reThrowAsUnchecked(ReThrowingSupplier<R, E> function) throws E {
	try {
	    return function.get();
	} catch (IllegalArgument e) {
	    throw e.getRuntime();
	} catch (IllegalState e) {
	    throw e.getRuntime();
	}
    }

    public static <E extends Exception> void reThrowAsUnchecked(ReThrowingCallable<E> function) throws E {
	try {
	    function.call();
	} catch (IllegalArgument e) {
	    throw e.getRuntime();
	} catch (IllegalState e) {
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

    public static <R, E extends Exception> R reThrowAsChecked(ReThrowingSupplier<R, E> function)
	    throws IllegalArgument, IllegalState, E {
	try {
	    return function.get();
	} catch (IllegalArgumentException e) {
	    throw new IllegalArgument(e);
	} catch (IllegalStateException e) {
	    throw new IllegalState(e);
	}
    }

    public static <E extends Exception> void reThrowAsChecked(ReThrowingCallable<E> function)
	    throws IllegalArgument, IllegalState, E {
	try {
	    function.call();
	} catch (IllegalArgumentException e) {
	    throw new IllegalArgument(e);
	} catch (IllegalStateException e) {
	    throw new IllegalState(e);
	}
    }

    public static class IllegalArgument extends Exception {

	private static final long serialVersionUID = 1L;

	private final IllegalArgumentException runtime;

	public IllegalArgument(IllegalArgumentException cause) {
	    super(cause);
	    this.runtime = cause;
	}

	public IllegalArgumentException getRuntime() {
	    return runtime;
	}
    }

    public static class IllegalState extends Exception {

	private static final long serialVersionUID = 1L;

	private final IllegalStateException runtime;

	public IllegalState(IllegalStateException cause) {
	    super(cause);
	    this.runtime = cause;
	}

	public IllegalStateException getRuntime() {
	    return runtime;
	}
    }

    public static IllegalArgumentException illegalArgumentException(final String message, final String par,
	    final String value) {
	StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(value))
	    sj.add("'" + value + "'");
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	return new IllegalArgumentException(sj.toString());
    }

    public static IllegalArgumentException illegalArgumentException(String message, String par, final String value,
	    Throwable cause) {
	StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(value))
	    sj.add("'" + value + "'");
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	return new IllegalArgumentException(sj.toString(), cause);
    }

    public static IllegalArgumentException illegalArgumentException(final String message, final String par) {
	StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	return new IllegalArgumentException(sj.toString());
    }

    public static IllegalArgumentException illegalArgumentException(final String message) {
	return new IllegalArgumentException(message);
    }

    public static IllegalArgumentException illegalArgumentException(String message, String par,
	    Throwable cause) {
	StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	return new IllegalArgumentException(sj.toString(), cause);
    }

    public static IllegalArgumentException illegalArgumentFormat(String format, Object... args) {
	return new IllegalArgumentException(String.format(format, args));
    }
}
