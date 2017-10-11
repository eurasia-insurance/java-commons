package tech.lapsa.java.commons.function;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public final class MyStrings {

    private static final String NOT_VALID_URL = "Is not valid url";

    private static final String EMPTY_STRING = "Is empty";
    private static final String NON_EMPTY_STRING = "Is not empty";

    private MyStrings() {
    }

    //

    public static boolean validURL(final String url) {
	if (empty(url))
	    return false;
	try {
	    new URL(url);
	    return true;
	} catch (MalformedURLException e) {
	    return false;
	}
    }

    public static String requireValidURL(final String url) {
	return requireValidURL(url, null);
    }

    public static String requireValidURL(final String url, final String par) {
	try {
	    new URL(requireNonEmpty(url));
	} catch (MalformedURLException | IllegalArgumentException e) {
	    throw MyExceptions.illegalArgumentException(NOT_VALID_URL, par, String.valueOf(url), e);
	}
	return url;
    }

    //

    public static boolean empty(final String string) {
	return MyObjects.isNull(string) || string.trim().isEmpty();
    }

    public static String requireEmpty(final String string) {
	return requireEmpty(string, null);

    }

    public static String requireEmpty(final String string, String par) {
	if (empty(string))
	    return string;
	throw MyExceptions.illegalArgumentException(NON_EMPTY_STRING, par, String.valueOf(string));
    }

    //

    public static boolean nonEmpty(final String string) {
	return !empty(string);
    }

    public static String requireNonEmpty(final String string) {
	return requireNonEmpty(string, null);

    }

    public static String requireNonEmpty(final String string, String par) {
	if (nonEmpty(string))
	    return string;
	throw MyExceptions.illegalArgumentException(EMPTY_STRING, par, String.valueOf(string));
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

}
