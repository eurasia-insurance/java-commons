package tech.lapsa.java.commons.localization;

import static tech.lapsa.java.commons.function.MyCollectors.*;
import static tech.lapsa.java.commons.function.MyMaps.*;

import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import tech.lapsa.java.commons.function.MyObjects;

public interface LocalizedElement extends Localized {

    //

    String name();

    //

    @Override
    default String displayName(final DisplayNameVariant variant, final Locale locale) {
	MyObjects.requireNonNull(variant, "Display name variant must be provided");
	MyObjects.requireNonNull(locale, "Locale must be provided");

	Builder<DisplayNameVariant> builder = Stream.<DisplayNameVariant> builder() //
		.add(variant);
	switch (variant) {
	case FULL:
	case SHORT:
	    builder.accept(DisplayNameVariant.NORMAL);
	    break;
	default:
	}

	return builder.build() //
		.map(x -> ResourceBundleUtil.getLocalized(this, x, locale)) //
		.filter(MyObjects::nonNull) //
		.findFirst()
		.orElseThrow(() -> new IllegalArgumentException("No ResourceBundle is supplied or key "
			+ "is not mapped correctly"));
    }

    //

    static class ResourceBundleUtil {

	private ResourceBundleUtil() {
	}

	//

	private static Map<DisplayNameVariant, String> KEY_PATTERNS = Stream.of( //
		entry(DisplayNameVariant.FULL, "%1$s.%2$s.full"), //
		entry(DisplayNameVariant.SHORT, "%1$s.%2$s.short"), //
		entry(DisplayNameVariant.NORMAL, "%1$s.%2$s") //
	).collect(unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));

	private static <T extends LocalizedElement> String getResourceKey(final T entity,
		final DisplayNameVariant variant) {
	    return String.format(ResourceBundleUtil.KEY_PATTERNS.get(variant), //
		    entity.getClass().getName(), //
		    entity.name());
	}

	//

	private static final ConcurrentMap<String, ConcurrentMap<Locale, ResourceBundle>> CACHE = new ConcurrentHashMap<>();

	private static <T extends LocalizedElement> ResourceBundle getCachedResourceBundle(final T entity,
		final Locale locale) {
	    return CACHE //
		    .computeIfAbsent(entity.getClass().getCanonicalName(), x -> new ConcurrentHashMap<>()) //
		    .computeIfAbsent(locale, x -> {
			try {
			    return ResourceBundle.getBundle(entity.getClass().getCanonicalName(), x);
			} catch (NullPointerException | MissingResourceException e) {
			    return null;
			}
		    }) //
	    ;
	}

	//

	private static <T extends LocalizedElement> String getLocalized(final T entity,
		final DisplayNameVariant variant, final Locale locale) {
	    ResourceBundle bundle = getCachedResourceBundle(entity, locale);
	    String key = getResourceKey(entity, variant);
	    try {
		return bundle.getString(key);
	    } catch (Exception e) {
		return null;
	    }
	}
    }
}