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

    public static enum StoreType {
	JKS;

	private StoreType() {
	    getInstance(); // check
	}

	KeyStore getInstance() {
	    try {
		return KeyStore.getInstance(name());
	    } catch (KeyStoreException e) {
		throw new RuntimeException(e);
	    }

	}
    }

    public static Optional<KeyStore> ofType(StoreType storetype) {
	if (MyObjects.isNull(storetype))
	    return Optional.empty();
	return Optional.of(storetype)
		.map(StoreType::getInstance); //
    }

    public static Optional<KeyStore> from(InputStream inputStream, StoreType storetype, String storepass) {
	if (MyObjects.isNull(inputStream))
	    return Optional.empty();
	if (MyObjects.isNull(storetype))
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
