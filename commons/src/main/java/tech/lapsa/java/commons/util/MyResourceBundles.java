package tech.lapsa.java.commons.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.lang.MyClassLoaderBased;
import tech.lapsa.java.commons.logging.MyLogger;

public final class MyResourceBundles {

    private MyResourceBundles() {
    }

    private static final MyLogger LOGGER = MyLogger.newBuilder() //
	    .withNameOf(MyResourceBundles.class) //
	    .build();

    public static Optional<ResourceBundle> optOf(final Class<?> thisClazz, final String baseName, final Locale locale) {
	MyObjects.requireNonNull(thisClazz, "thisClazz");
	MyStrings.requireNonEmpty(baseName, "baseName");
	MyObjects.requireNonNull(locale, "locale");

	return MyClassLoaderBased.optOf(thisClazz, cl -> {
	    LOGGER.DEBUG.log("Searching for resource bundle for '%1$s', locale %2$s", baseName, locale);
	    try {
		final ResourceBundle rb = ResourceBundle.getBundle(baseName, locale, cl);
		if (rb != null)
		    LOGGER.SUPER_TRACE.log("Resource bundle found %1$s", rb.keySet());
		return rb;
	    } catch (MissingResourceException e) {
		LOGGER.SEVERE.log(e);
		return null;
	    }
	});
    }

    public static ResourceBundle of(final Class<?> thisClazz, final String baseName, final Locale locale) {
	return optOf(thisClazz, baseName, locale).orElse(null);
    }
}
