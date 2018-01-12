package test.function;

import static org.junit.Assert.*;

final class Exceptions {

    private Exceptions() {
    }

    public static void expectException(final Statement statement, final Class<? extends Exception> exceptionClazz) {
	try {
	    statement.call();
	} catch (final Exception e) {
	    if (exceptionClazz.isAssignableFrom(e.getClass()))
		return; // OK
	}
	fail(exceptionClazz.getName() + " exception is expected");
    }

    public static void expectException(final Statement statement) {
	try {
	    statement.call();
	} catch (final Exception e) {
	    return; // OK
	}
	fail("Any exception expected");
    }

    public static void unexpectException(final Statement statement) {
	try {
	    statement.call();
	} catch (final Exception e) {
	    fail("Unexpected exception thrown " + e.getClass().getName() + ": " + e.getMessage());
	}
    }

    @FunctionalInterface
    public static interface Statement {
	void call();
    }
}
