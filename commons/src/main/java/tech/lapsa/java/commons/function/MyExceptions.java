package tech.lapsa.java.commons.function;

import java.util.StringJoiner;

public final class MyExceptions {

    private MyExceptions() {
    }

    //TODO needs to refactor

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
