package tech.lapsa.java.commons.localization;

import static tech.lapsa.java.commons.function.MyCollectors.*;
import static tech.lapsa.java.commons.function.MyMaps.*;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.util.MyResourceBundles;

public interface LocalizedElement extends Localized {

    //

    String name();

    //

    @Override
    default String localized(final LocalizationVariant variant, final Locale locale) {
	MyObjects.requireNonNullMsg(variant, "Display name variant must be provided");
	MyObjects.requireNonNullMsg(locale, "Locale must be provided");

	final Builder<LocalizationVariant> builder = Stream.<LocalizationVariant> builder() //
		.add(variant);
	switch (variant) {
	case FULL:
	case SHORT:
	    builder.accept(LocalizationVariant.NORMAL);
	    break;
	default:
	}

	return builder.build() //
		.map(x -> ResourceBundleUtil.getLocalized(this, x, locale)) //
		.filter(MyObjects::nonNull) //
		.findFirst()
		.orElseThrow(() -> new NoLocalizationException(this, variant, locale));
    }

    //

    static class ResourceBundleUtil {

	private ResourceBundleUtil() {
	}

	//

	private static Map<LocalizationVariant, String> KEY_PATTERNS = Stream.of( //
		entry(LocalizationVariant.FULL, "%1$s.%2$s.full"), //
		entry(LocalizationVariant.SHORT, "%1$s.%2$s.short"), //
		entry(LocalizationVariant.NORMAL, "%1$s.%2$s") //
	).collect(unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));

	private static <T extends LocalizedElement> String getResourceKey(final T entity,
		final LocalizationVariant variant) {
	    return MyStrings.format(ResourceBundleUtil.KEY_PATTERNS.get(variant), //
		    entity.getClass().getName(), //
		    entity.name());
	}

	//

	private static <T extends LocalizedElement> ResourceBundle getCachedResourceBundle(final T entity,
		final Locale locale) {
	    final String baseName = entity.getClass().getCanonicalName();
	    return MyResourceBundles.optOf(entity.getClass(), baseName, locale).orElseGet(null);
	}

	//

	private static <T extends LocalizedElement> String getLocalized(final T entity,
		final LocalizationVariant variant, final Locale locale) {
	    final ResourceBundle bundle = getCachedResourceBundle(entity, locale);
	    final String key = getResourceKey(entity, variant);
	    try {
		return bundle.getString(key);
	    } catch (final Exception e) {
		return null;
	    }
	}
    }
}