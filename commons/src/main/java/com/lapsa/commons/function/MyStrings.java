package com.lapsa.commons.function;

import java.util.Locale;
import java.util.Objects;

public final class MyStrings {

    private MyStrings() {
    }

    //

    public static boolean empty(final String string) {
	return Objects.isNull(string) || string.trim().isEmpty();
    }

    public static boolean nonEmpty(final String string) {
	return !empty(string);
    }

    public static String requireNonEmpty(final String string) {
	if (empty(string))
	    throw new IllegalArgumentException("empty string");
	return string;
    }

    public static String requireNonEmpty(final String string, String message) {
	if (empty(string))
	    throw new IllegalArgumentException(message);
	return string;
    }

    public static String requireEmpty(final String string) {
	if (nonEmpty(string))
	    throw new IllegalArgumentException("non-empty string");
	return string;
    }

    public static String requireEmpty(final String string, String message) {
	if (nonEmpty(string))
	    throw new IllegalArgumentException(message);
	return string;
    }

    //

    public static String capitalizeFirstLetter(final String string, final Locale locale) {
	if (Objects.isNull(string))
	    return null;
	if (string.isEmpty())
	    return string;
	return string.substring(0, 1).toUpperCase(locale) + string.substring(1);
    }

    public static String capitalizeFirstLetter(final String string) {
	if (Objects.isNull(string))
	    return null;
	if (string.isEmpty())
	    return string;
	return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static String nullOnEmpty(final String string) {
	return empty(string) ? null : string;
    }
}
