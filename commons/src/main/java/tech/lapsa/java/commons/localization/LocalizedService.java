package tech.lapsa.java.commons.localization;

import java.util.Locale;

public interface LocalizedService<T extends Localized> {

    default String displayName(T entity) {
	return entity.regular();
    }

    default String displayNameShort(T entity) {
	return entity.few();
    }

    default String displayNameFull(T entity) {
	return entity.full();
    }

    //

    default String displayName(T entity, Locale locale) {
	return entity.regular(locale);
    }

    default String displayNameShort(T entity, Locale locale) {
	return entity.few(locale);
    }

    default String displayNameFull(T entity, Locale locale) {
	return entity.full(locale);
    }
}
