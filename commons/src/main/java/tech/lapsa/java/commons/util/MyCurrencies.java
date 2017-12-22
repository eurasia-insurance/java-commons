package tech.lapsa.java.commons.util;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Locale.Category;

import tech.lapsa.java.commons.function.MyObjects;

public final class MyCurrencies {

    private MyCurrencies() {
    }

    public static final NumberFormat numberFormatFor(final Currency currency) throws IllegalArgumentException {
	return numberFormatFor(currency, Locale.getDefault(Category.FORMAT));
    }

    public static final NumberFormat numberFormatFor(final Currency currency, final Locale locale)
	    throws IllegalArgumentException {
	MyObjects.requireNonNull(currency, "currency");
	MyObjects.requireNonNull(locale, "locale");
	final NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
	nf.setCurrency(currency);
	return nf;
    }

    public static final String formatAmount(final Double amount, final Currency currency)
	    throws IllegalArgumentException {
	final double unboxed = MyObjects.requireNonNull(amount).doubleValue();
	return numberFormatFor(currency).format(unboxed);
    }

    public static final String formatAmount(final Double amount, final Currency currency, final Locale locale)
	    throws IllegalArgumentException {
	final double unboxed = MyObjects.requireNonNull(amount).doubleValue();
	return numberFormatFor(currency, locale).format(unboxed);
    }

}
