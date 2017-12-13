package tech.lapsa.java.commons.exceptions;

public class IllegalArgument extends Exception {

    private static final long serialVersionUID = 1L;

    private final IllegalArgumentException runtime;

    public IllegalArgument(final IllegalArgumentException cause) {
	super(cause);
	runtime = cause;
    }

    public void reThrow() throws IllegalArgumentException {
	throw runtime;
    }

    public IllegalArgumentException getRuntime() {
	return runtime;
    }
}