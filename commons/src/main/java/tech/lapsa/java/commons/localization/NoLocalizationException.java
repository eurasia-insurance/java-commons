package tech.lapsa.java.commons.localization;

import java.util.Locale;

import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.localization.Localized.LocalizationVariant;

public class NoLocalizationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    NoLocalizationException(final LocalizedElement value, final LocalizationVariant variant,
	    final Locale locale) {
	this(MyStrings.format("Localization not found for '%1$s.%2$s' with variant '%3$s' and locale '%4$s'",
		value.getClass(), // 1
		value.name(), // 2
		variant, // 3
		locale // 4
	));
    }

    public NoLocalizationException() {
    }

    public NoLocalizationException(String message, Throwable cause, boolean enableSuppression,
	    boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public NoLocalizationException(String message, Throwable cause) {
	super(message, cause);
    }

    public NoLocalizationException(String message) {
	super(message);
    }

    public NoLocalizationException(Throwable cause) {
	super(cause);
    }
}
