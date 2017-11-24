package test.assertion;

import static org.junit.Assert.*;

public final class Assertions {

    private Assertions() {
    }

    public static void expectException(Statement statement, Class<? extends Throwable> expectingException)
	    throws Exception {
	try {
	    statement.call();
	} catch (Exception e) {
	    if (expectingException.isAssignableFrom(e.getClass()))
		return; // OK
	    throw e;
	}
	fail(expectingException.getName() + " exception is expected");
    }

    public static void expectException(Statement statement) {
	try {
	    statement.call();
	} catch (Exception e) {
	    return; // OK
	}
	fail("Any exception expected");
    }

    public static void unexpectException(Statement statement) {
	try {
	    statement.call();
	} catch (Exception e) {
	    fail("Unexpected exception thrown " + e.getClass().getName() + ": " + e.getMessage());
	}
    }

    @FunctionalInterface
    public static interface Statement {
	void call() throws Exception;
    }
}
