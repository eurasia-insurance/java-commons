package tech.lapsa.java.commons.security;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.util.Optional;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;

public final class MyPrivateKeys {

    private MyPrivateKeys() {
    }

    public static Optional<PrivateKey> from(final KeyStore keystore, final String alias, final String pass) {
	if (MyObjects.isNull(keystore))
	    return Optional.empty();
	if (MyStrings.empty(alias))
	    return Optional.empty();
	if (MyStrings.empty(pass))
	    return Optional.empty();
	try {
	    return MyOptionals.of(keystore.getKey(alias, pass.toCharArray())) //
		    .filter(k -> MyObjects.isA(k, PrivateKey.class)) //
		    .map(MyObjects.cast(PrivateKey.class));
	} catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException e) {
	    return Optional.empty();
	}
    }

}
