package tech.lapsa.java.commons.localization;

import static tech.lapsa.java.commons.function.MyCollectors.*;
import static tech.lapsa.java.commons.function.MyMaps.*;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.localization.Localized.LocalizationVariant;
import tech.lapsa.java.commons.util.MyResourceBundles;

class LocalizedElementResourceBundles {

    private LocalizedElementResourceBundles() {
    }

    //

    private static Map<LocalizationVariant, String> KEY_PATTERNS = Stream.of( //
	    entry(LocalizationVariant.FULL, "%1$s.%2$s.full"), //
	    entry(LocalizationVariant.SHORT, "%1$s.%2$s.short"), //
	    entry(LocalizationVariant.NORMAL, "%1$s.%2$s") //
    ).collect(unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));

    //

    static <T extends LocalizedElement> String getLocalized(final T entity,
	    final LocalizationVariant variant, final Locale locale) {
	final String baseName = entity.getClass().getCanonicalName();
	final ResourceBundle bundle = MyResourceBundles.of(entity.getClass(), baseName, locale);
	final String key = MyStrings.format(LocalizedElementResourceBundles.KEY_PATTERNS.get(variant), //
		entity.getClass().getName(), //
		entity.name());
	if (MyObjects.isNull(bundle) || MyStrings.empty(key))
	    return null;
	try {
	    return bundle.getString(key);
	} catch (final Exception e) {
	    return null;
	}
    }
}