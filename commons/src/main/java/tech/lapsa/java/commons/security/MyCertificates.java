package tech.lapsa.java.commons.security;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.X509Certificate;
import java.util.Optional;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;

public final class MyCertificates {

    private MyCertificates() {
    }

    public static Optional<X509Certificate> from(final KeyStore keystore, final String alias) {
	if (MyObjects.isNull(keystore))
	    return Optional.empty();
	if (MyStrings.empty(alias))
	    return Optional.empty();
	try {
	    return MyOptionals.of(keystore.getCertificate(alias)) //
		    .filter(k -> MyObjects.isA(k, X509Certificate.class)) //
		    .map(MyObjects.cast(X509Certificate.class));
	} catch (final KeyStoreException e) {
	    return Optional.empty();
	}
    }

}
