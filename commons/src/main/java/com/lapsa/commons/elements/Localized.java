package com.lapsa.commons.elements;

import java.util.Locale;
import java.util.function.Function;

public interface Localized {

    enum DisplayNameVariant {
	NORMAL, FULL, SHORT
    }

    //

    default String displayName(DisplayNameVariant variant) {
	return displayName(variant, Locale.getDefault());
    }

    String displayName(DisplayNameVariant variant, Locale locale);

    //

    default String displayName() {
	return displayName(Localized.DisplayNameVariant.NORMAL, Locale.getDefault());
    }

    default String displayNameFull() {
	return displayName(Localized.DisplayNameVariant.FULL, Locale.getDefault());
    }

    default String displayNameShort() {
	return displayName(Localized.DisplayNameVariant.SHORT, Locale.getDefault());
    }

    //

    default String displayName(final Locale locale) {
	return displayName(DisplayNameVariant.NORMAL, locale);
    }

    default String displayNameFull(final Locale locale) {
	return displayName(DisplayNameVariant.FULL, locale);
    }

    default String displayNameShort(final Locale locale) {
	return displayName(DisplayNameVariant.SHORT, locale);
    }

    //

    public static Function<? super Localized, ? extends String> toDisplayNameMapper(final DisplayNameVariant variant,
	    final Locale locale) {
	return x -> x.displayName(variant, locale);
    }

    public static Function<? super Localized, ? extends String> toDisplayNameMapper(final DisplayNameVariant variant) {
	return x -> x.displayName(variant);
    }

    public static Function<? super Localized, ? extends String> toDisplayNameFullMapper(final Locale locale) {
	return x -> x.displayNameFull(locale);
    }

    public static Function<? super Localized, ? extends String> toDisplayNameShortMapper(final Locale locale) {
	return x -> x.displayNameShort(locale);
    }

    public static Function<? super Localized, ? extends String> toDisplayNameMapper(final Locale locale) {
	return x -> x.displayName(locale);
    }

    public static Function<? super Localized, ? extends String> toDisplayNameFullMapper() {
	return x -> x.displayNameFull();
    }

    public static Function<? super Localized, ? extends String> toDisplayNameShortMapper() {
	return x -> x.displayNameShort();
    }

    public static Function<? super Localized, ? extends String> toDisplayNameMapper() {
	return x -> x.displayName();
    }
}