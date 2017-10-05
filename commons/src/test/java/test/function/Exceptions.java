package test.function;

import static org.junit.Assert.*;

final class Exceptions {

    private Exceptions() {
    }

    static void expectException(Statement statement, Class<? extends Throwable> clazz) {
	try {
	    statement.call();
	} catch (Throwable e) {
	    System.out.println(e.getMessage());
	    if (clazz.isAssignableFrom(e.getClass()))
		return;
	}
	fail(clazz.getName() + " is expected");
    }

    static void expectException(Statement statement) {
	try {
	    statement.call();
	} catch (Throwable e) {
	    System.out.println(e.getMessage());
	    return;
	}
	fail("Exception expected");
    }

    static void unexpectException(Statement statement) {
	try {
	    statement.call();
	} catch (Throwable e) {
	    fail("Unexpected exception " + e.getMessage());
	}
    }

    @FunctionalInterface
    static interface Statement {
	void call();
    }
}
