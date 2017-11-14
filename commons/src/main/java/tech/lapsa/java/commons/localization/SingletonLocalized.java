package tech.lapsa.java.commons.localization;

import java.util.Locale;

import tech.lapsa.java.commons.function.MyStrings;

public class SingletonLocalized implements Localized {

    private static final long serialVersionUID = 1L;

    public final String string;

    public SingletonLocalized(final String string) {
	this.string = MyStrings.requireNonEmpty(string, "string");
    }

    @Override
    public String localized(final LocalizationVariant variant, final Locale locale) {
	return string;
    }
}
