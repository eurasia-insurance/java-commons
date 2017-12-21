package tech.lapsa.java.commons.exceptions;

public class IllegalState extends Exception {

    private static final long serialVersionUID = 1L;

    private final IllegalStateException runtime;

    public IllegalState(final IllegalStateException cause) {
	super(cause);
	runtime = cause;
    }

    public IllegalState(final String message) {
	super(message);
	runtime = new IllegalStateException(message);
    }

    public void reThrow() throws IllegalStateException {
	throw runtime;
    }

    public IllegalStateException getRuntime() {
	return runtime;
    }
}