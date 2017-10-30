package tech.lapsa.java.commons.localization;

import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import tech.lapsa.java.commons.function.MyOptionals;

public class DetachedLocalized implements Localized {

    private static final long serialVersionUID = 1L;

    private final Map<String, Map<LocalizationVariant, String>> cache;

    public DetachedLocalized(Localized localized, Locale... locales) {

	class Entry {
	    Entry(Locale locale, LocalizationVariant variant, String string) {
		this.locale = locale;
		this.variant = variant;
		this.string = string;
	    }

	    Locale locale;
	    LocalizationVariant variant;
	    String string;
	}

	Builder<Entry> z = Stream.builder();
	for (Locale locale : locales)
	    for (LocalizationVariant variant : LocalizationVariant.values())
		z.accept(new Entry(locale, variant, localized.localized(variant, locale)));
	cache = z.build() //
		.collect(Collectors.groupingBy(e -> e.locale.getLanguage(),
			Collectors.toMap(e -> e.variant, e -> e.string)));
    }

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	return MyOptionals.of(cache) //
		.map(x -> x.get(locale.getLanguage())) //
		.map(x -> x.get(variant)) //
		.orElse(null);
    }

}
