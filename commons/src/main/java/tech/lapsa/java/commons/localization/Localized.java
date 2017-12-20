package tech.lapsa.java.commons.localization;

import java.io.Serializable;
import java.util.Locale;
import java.util.function.Function;

public interface Localized extends Serializable {

    public enum LocalizationVariant {
	NORMAL, FULL, SHORT
    }

    //

    default String localized(final LocalizationVariant variant) {
	return localized(variant, Locale.getDefault());
    }

    String localized(LocalizationVariant variant, Locale locale);

    //

    default String regular() {
	return localized(Localized.LocalizationVariant.NORMAL, Locale.getDefault());
    }

    default String full() {
	return localized(Localized.LocalizationVariant.FULL, Locale.getDefault());
    }

    default String few() {
	return localized(Localized.LocalizationVariant.SHORT, Locale.getDefault());
    }

    //

    default String regular(final Locale locale) {
	return localized(LocalizationVariant.NORMAL, locale);
    }

    default String full(final Locale locale) {
	return localized(LocalizationVariant.FULL, locale);
    }

    default String few(final Locale locale) {
	return localized(LocalizationVariant.SHORT, locale);
    }

    //

    default Localized detached(final Locale... locales) {
	return new DetachedLocalized(this, locales);

    }

    default Localized detached() {
	return new DetachedLocalized(this, Locale.getDefault());

    }

    //

    public static Function<? super Localized, ? extends String> toLocalizedMapper(final LocalizationVariant variant,
	    final Locale locale) {
	return x -> x.localized(variant, locale);
    }

    public static Function<? super Localized, ? extends String> toLocalizedMapper(final LocalizationVariant variant) {
	return x -> x.localized(variant);
    }

    public static Function<? super Localized, ? extends String> toFullMapper(final Locale locale) {
	return x -> x.full(locale);
    }

    public static Function<? super Localized, ? extends String> toFewMapper(final Locale locale) {
	return x -> x.few(locale);
    }

    public static Function<? super Localized, ? extends String> toRegularMapper(final Locale locale) {
	return x -> x.regular(locale);
    }

    public static Function<? super Localized, ? extends String> toFullMapper() {
	return x -> x.full();
    }

    public static Function<? super Localized, ? extends String> toFewMapper() {
	return x -> x.few();
    }

    public static Function<? super Localized, ? extends String> toRegularMapper() {
	return x -> x.regular();
    }
}