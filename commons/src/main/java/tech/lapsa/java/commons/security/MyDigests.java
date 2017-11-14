package tech.lapsa.java.commons.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;

public final class MyDigests {

    private MyDigests() {
    }

    public static Optional<MessageDigest> ofAlgorithm(final String algorithmName) {
	if (MyStrings.empty(algorithmName))
	    return Optional.empty();
	return MyOptionals.of(algorithmName) //
		.map(x -> {
		    try {
			return MessageDigest.getInstance(x);
		    } catch (final NoSuchAlgorithmException e) {
			return null;
		    }
		});
    }
}
