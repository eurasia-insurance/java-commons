package com.lapsa.commons.function;

import java.util.StringJoiner;

final class MyExceptions {

    private MyExceptions() {
    }

    static IllegalArgumentException illegalArgumentException(final String message, final String par,
	    final String value) {
	StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(value))
	    sj.add("'" + value + "'");
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	return new IllegalArgumentException(sj.toString());
    }

    static IllegalArgumentException illegalArgumentException(String message, String par, final String value,
	    Throwable cause) {
	StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(value))
	    sj.add("'" + value + "'");
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	return new IllegalArgumentException(sj.toString(), cause);
    }

    static IllegalArgumentException illegalArgumentException(final String message, final String par) {
	StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	return new IllegalArgumentException(sj.toString());
    }

    static IllegalArgumentException illegalArgumentException(String message, String par,
	    Throwable cause) {
	StringJoiner sj = new StringJoiner(" ");
	sj.add(message);
	if (MyStrings.nonEmpty(par))
	    sj.add("(" + par + ")");
	return new IllegalArgumentException(sj.toString(), cause);
    }
}
