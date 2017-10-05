package test.assertion;

import static org.junit.Assert.*;

public final class Assertions {

    private Assertions() {
    }

    public static void expectException(Statement statement, Class<? extends Throwable> exceptionClazz) {
	try {
	    statement.call();
	} catch (Throwable e) {
	    if (exceptionClazz.isAssignableFrom(e.getClass()))
		return; // OK
	}
	fail(exceptionClazz.getName() + " exception is expected");
    }

    public static void expectException(Statement statement) {
	try {
	    statement.call();
	} catch (Throwable e) {
	    return; // OK
	}
	fail("Any exception expected");
    }

    public static void unexpectException(Statement statement) {
	try {
	    statement.call();
	} catch (Throwable e) {
	    fail("Unexpected exception thrown " + e.getClass().getName() + ": " + e.getMessage());
	}
    }

    @FunctionalInterface
    public static interface Statement {
	void call();
    }
}
