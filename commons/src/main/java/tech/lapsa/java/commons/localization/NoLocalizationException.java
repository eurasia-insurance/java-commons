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

    public NoLocalizationException(final String message, final Exception cause, final boolean enableSuppression,
	    final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public NoLocalizationException(final String message, final Exception cause) {
	super(message, cause);
    }

    public NoLocalizationException(final String message) {
	super(message);
    }

    public NoLocalizationException(final Exception cause) {
	super(cause);
    }
}
