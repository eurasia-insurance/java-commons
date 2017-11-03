package tech.lapsa.java.commons.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.util.Optional;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;

public class MySignatures {

    private MySignatures() {
    }

    public static Optional<Signature> ofAlgorithm(String algorithm) {
	if (MyStrings.empty(algorithm))
	    return Optional.empty();
	return Optional.of(algorithm) //
		.map(x -> {
		    try {
			return Signature.getInstance(algorithm);
		    } catch (NoSuchAlgorithmException e) {
			return null;
		    }
		});
    }

    public static Optional<Signature> forSignature(PrivateKey key, String algorithm) {
	if (MyObjects.isNull(key))
	    return Optional.empty();
	if (MyStrings.empty(algorithm))
	    return Optional.empty();

	return ofAlgorithm(algorithm) //
		.map(x -> {
		    try {
			x.initSign(key);
			return x;
		    } catch (InvalidKeyException e) {
			return null;
		    }
		});
    }

    public static Optional<Signature> forVerification(PublicKey key, String algorithm) {
	if (MyObjects.isNull(key))
	    return Optional.empty();
	if (MyStrings.empty(algorithm))
	    return Optional.empty();
	return ofAlgorithm(algorithm) //
		.map(x -> {
		    try {
			x.initVerify(key);
			return x;
		    } catch (InvalidKeyException e) {
			return null;
		    }
		});
    }

    public static Optional<Signature> forVerification(X509Certificate cert, String algorithm) {
	if (MyObjects.isNull(cert))
	    return Optional.empty();
	if (MyStrings.empty(algorithm))
	    return Optional.empty();
	return ofAlgorithm(algorithm) //
		.map(x -> {
		    try {
			x.initVerify(cert);
			return x;
		    } catch (InvalidKeyException e) {
			return null;
		    }
		});
    }

}
