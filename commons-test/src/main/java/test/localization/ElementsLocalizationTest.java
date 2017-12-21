package test.localization;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.localization.Localized;
import tech.lapsa.java.commons.localization.LocalizedElement;

public abstract class ElementsLocalizationTest<T extends LocalizedElement> {

    public static final Locale LOCALE_RUSSIAN = Locale.forLanguageTag("ru");
    public static final Locale LOCALE_ENGLISH = Locale.forLanguageTag("en");
    public static final Locale LOCALE_KAZAKH = Locale.forLanguageTag("kk");

    private final T[] values;
    protected final Locale locale;
    protected final Class<T> clazz;

    protected ElementsLocalizationTest(final T[] values, final Class<T> clazz, final Locale locale) {
	this.values = values;
	this.clazz = clazz;
	this.locale = locale;
    }

    private ResourceBundle getResourceBundle() {
	final ResourceBundle resourceBundle = ResourceBundle.getBundle(clazz.getCanonicalName(), locale);
	assertThat(MyStrings.format("Resource bundle for '%1$s' is not present", locale), resourceBundle,
		not(nullValue()));
	return resourceBundle;
    }

    @Test
    public void testDisplayNames() {
	Stream.of(values) //
		.flatMap(x -> Stream.of(Localized.LocalizationVariant.values()) //
			.map(y -> x.localized(y, locale)))
		.forEach(Assert::assertNotNull);
    }

    @Test
    public void testEveryValueHasLocalization() {
	final ResourceBundle resourceBundle = getResourceBundle();
	for (final T value : values) {
	    final String key = MyStrings.format("%s.%s", value.getClass().getName(), value.name());
	    try {
		final String name = resourceBundle.getString(key);
		assertThat(MyStrings.format("Localization for key '%1$s' is null", key), name, not(nullValue()));
	    } catch (final MissingResourceException e) {
		fail(MyStrings.format("Localization string for value '%1$s.%2$s' is missing",
			value.getClass().getCanonicalName(), value.name(), key));
	    }
	}
    }

    @Test
    public void testNoExtraLocalization() {
	final ResourceBundle resourceBundle = getResourceBundle();
	final Enumeration<String> keys = resourceBundle.getKeys();
	while (keys.hasMoreElements()) {
	    final String key = keys.nextElement();
	    final T value = valueFor(key);
	    assertThat(MyStrings.format("Key '%1$s' associated value is missing", key), value, not(nullValue()));
	}
    }

    private T valueFor(final String key) {
	for (final T value : values) {
	    if (MyStrings.format("%s.%s", value.getClass().getName(), value.name()).equals(key))
		return value;
	    if (MyStrings.format("%s.%s.full", value.getClass().getName(), value.name()).equals(key))
		return value;
	    if (MyStrings.format("%s.%s.short", value.getClass().getName(), value.name()).equals(key))
		return value;
	}
	return null;
    }

    protected Stream<T> stream() {
	return Stream.of(values);
    }
}
