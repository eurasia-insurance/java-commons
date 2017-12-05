package tech.lapsa.java.commons.localization;

import java.util.Locale;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import tech.lapsa.java.commons.function.MyObjects;

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
		.map(x -> LocalizedElementResourceBundles.getLocalized(this, x, locale)) //
		.filter(MyObjects::nonNull) //
		.findFirst()
		.orElseThrow(() -> new NoLocalizationException(this, variant, locale));
    }
}