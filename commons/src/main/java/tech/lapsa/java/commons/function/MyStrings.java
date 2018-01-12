package tech.lapsa.java.commons.function;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.IllegalFormatException;
import java.util.Locale;
import java.util.function.Function;

public final class MyStrings {

    private static final String DEFAULT_PAR = "string";

    private static final String NOT_VALID_URL = "Is not valid url";

    private static final String NON_EMPTY_STRING = "Is not empty";
    private static final String STRINGS_NOT_EQUALS = "Strings are not equals";

    private MyStrings() {
    }

    //

    public static boolean validURL(final String url) {
	if (empty(url))
	    return false;
	try {
	    new URL(url);
	    return true;
	} catch (final MalformedURLException e) {
	    return false;
	}
    }

    public static String requireValidURL(final String url) throws IllegalArgumentException {
	return requireValidURL(url, null);
    }

    public static String requireValidURL(final String url, final String par) throws IllegalArgumentException {
	try {
	    new URL(requireNonEmpty(url));
	} catch (MalformedURLException | IllegalArgumentException e) {
	    throw MyExceptions.illegalArgumentPar(NOT_VALID_URL, par, String.valueOf(url), e);
	}
	return url;
    }

    //

    public static boolean empty(final String string) {
	return MyObjects.isNull(string) || string.trim().isEmpty();
    }

    public static String requireEmpty(final String string) throws IllegalArgumentException {
	return requireEmpty(string, null);

    }

    public static String requireEmpty(final String string, final String par) throws IllegalArgumentException {
	if (empty(string))
	    return string;
	throw MyExceptions.illegalArgumentPar(NON_EMPTY_STRING, par, String.valueOf(string));
    }

    //

    public static boolean nonEmpty(final String string) {
	return !empty(string);
    }

    // reqs

    public static String requireNonEmpty(final String string) throws IllegalArgumentException {
	return requireNonEmpty(IllegalArgumentException::new, string);
    }

    public static String requireNonEmpty(final String string, final String par) throws IllegalArgumentException {
	return requireNonEmpty(IllegalArgumentException::new, string, par);
    }

    public static String requireNonEmptyMsg(final String string, final String message, final Object... args)
	    throws IllegalArgumentException {
	return requireNonEmptyMsg(IllegalArgumentException::new, string, message, args);
    }

    // with creators

    private static final String EMPTY_STRING = "%1$s is empty";

    public static <X extends Exception> String requireNonEmpty(final Function<String, X> creator, final String string)
	    throws X {
	return requireNonEmpty(creator, string, DEFAULT_PAR);
    }

    public static <X extends Exception> String requireNonEmpty(final Function<String, X> creator, final String string,
	    final String par) throws X {
	return requireNonEmptyMsg(creator, string, EMPTY_STRING, par);
    }

    public static <X extends Exception> String requireNonEmptyMsg(final Function<String, X> creator,
	    final String string, final String message, final Object... args) throws X {
	if (nonEmpty(string))
	    return string;
	throw MyExceptions.format(creator, message, args);
    }

    //

    public static String capitalizeFirstLetter(final String string, final Locale locale) {
	if (MyObjects.isNull(string))
	    return null;
	if (string.isEmpty())
	    return string;
	return string.substring(0, 1).toUpperCase(locale) + string.substring(1);
    }

    public static String capitalizeFirstLetter(final String string) {
	if (MyObjects.isNull(string))
	    return null;
	if (string.isEmpty())
	    return string;
	return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static String nullOnEmpty(final String string) {
	return empty(string) ? null : string;
    }

    //

    public static String format(final String format, final Object... args) {
	try {
	    return String.format(format, args);
	} catch (IllegalFormatException | NullPointerException e) {
	    return "" + format + " {" + e.getClass().getSimpleName() + " " + e.getMessage() + "}";
	}
    }

    //

    public static boolean equals(final String s1, final String s2) {
	return s1 != null && s2 != null && s1.equals(s2);
    }

    public static void requireEquals(final String s1, final String s2) throws IllegalArgumentException {
	if (!equals(s1, s2))
	    throw MyExceptions.illegalArgumentPar(STRINGS_NOT_EQUALS, "s1 and s2", "'" + s1 + "' and '" + s2 + "'");
    }

    public static void requireEqualsMsg(final String s1, final String s2, final String message, final Object... args)
	    throws IllegalArgumentException {
	requireEqualsMsg(IllegalArgumentException::new, s1, s2, message, args);
    }

    public static <X extends Exception> void requireEqualsMsg(final Function<String, X> creator, final String s1,
	    final String s2, final String message, final Object... args) throws X {
	if (!equals(s1, s2))
	    throw MyExceptions.format(creator, message, args);
    }
}
