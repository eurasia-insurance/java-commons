package test.function;

import static org.junit.Assert.*;

public final class Expeptions {

    private Expeptions() {
    }

    public static void expectException(Statement statement, Class<? extends Throwable> clazz) {
	try {
	    statement.call();
	} catch (Throwable e) {
	    System.out.println(e.getMessage());
	    if (clazz.isAssignableFrom(e.getClass()))
		return;
	}
	fail(clazz.getName() + " is expected");
    }

    public static void expectException(Statement statement) {
	try {
	    statement.call();
	} catch (Throwable e) {
	    System.out.println(e.getMessage());
	    return;
	}
	fail("Exception expected");
    }

    public static void unexpectException(Statement statement) {
	try {
	    statement.call();
	} catch (Throwable e) {
	    fail("Unexpected exception " + e.getMessage());
	}
    }

    @FunctionalInterface
    public static interface Statement {
	void call();
    }
}
