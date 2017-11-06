package tech.lapsa.java.commons.security;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Optional;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;

public final class MyKeyStores {

    private MyKeyStores() {
    }

    public static Optional<KeyStore> ofType(String storetype) {
	if (MyStrings.empty(storetype))
	    return Optional.empty();
	return Optional.of(storetype)
		.map(x -> {
		    try {
			return KeyStore.getInstance(storetype);
		    } catch (KeyStoreException e) {
			return null;
		    }
		});
    }

    public static Optional<KeyStore> from(InputStream inputStream, String storetype, String storepass) {
	if (MyObjects.isNull(inputStream))
	    return Optional.empty();
	if (MyStrings.empty(storetype))
	    return Optional.empty();
	if (MyStrings.empty(storepass))
	    return Optional.empty();
	return ofType(storetype) //
		.map(x -> {
		    try {
			x.load(inputStream, storepass.toCharArray());
			return x;
		    } catch (Exception e) {
			return null;
		    }
		});
    }

}
