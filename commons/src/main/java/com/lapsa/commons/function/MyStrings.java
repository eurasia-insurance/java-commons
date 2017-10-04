package com.lapsa.commons.function;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public final class MyStrings {

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
	return requireValidURL(url, "not valid url");
    }

    public static String requireValidURL(final String url, String message) {
	try {
	    new URL(requireNonEmpty(url));
	} catch (MalformedURLException e) {
	    throw new IllegalArgumentException(message, e);
	}
	return url;
    }

    //

    public static boolean empty(final String string) {
	return MyObjects.isNull(string) || string.trim().isEmpty();
    }

    public static String requireEmpty(final String string) {
	return requireEmpty(string, "non-empty string");

    }

    public static String requireEmpty(final String string, String message) {
	if (empty(string))
	    return string;
	throw new IllegalArgumentException(message);

    }

    //

    public static boolean nonEmpty(final String string) {
	return !empty(string);
    }

    public static String requireNonEmpty(final String string) {
	return requireNonEmpty(string, "empty string");

    }

    public static String requireNonEmpty(final String string, String message) {
	if (nonEmpty(string))
	    return string;
	throw new IllegalArgumentException(message);
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
