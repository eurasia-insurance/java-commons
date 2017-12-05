package tech.lapsa.java.commons.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.lang.MyClassLoaderBased;

public final class MyResourceBundles {

    private MyResourceBundles() {
    }

    public static Optional<ResourceBundle> optOf(final Class<?> thisClazz, final String baseName, final Locale locale) {
	MyObjects.requireNonNull(thisClazz, "thisClazz");
	MyStrings.requireNonEmpty(baseName, "baseName");
	MyObjects.requireNonNull(locale, "locale");

	return MyClassLoaderBased.optOf(thisClazz, cl -> {
	    try {
		return ResourceBundle.getBundle(baseName, locale, cl);
	    } catch (MissingResourceException e) {
		return null;
	    }
	});
    }

    public static ResourceBundle of(final Class<?> thisClazz, final String baseName, final Locale locale) {
	return optOf(thisClazz, baseName, locale).orElse(null);
    }
}
