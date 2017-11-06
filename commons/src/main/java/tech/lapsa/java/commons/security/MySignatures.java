package tech.lapsa.java.commons.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.Optional;

import tech.lapsa.java.commons.function.MyObjects;

public class MySignatures {

    private MySignatures() {
    }

    public static enum Algorithm {
	SHA1withRSA;

	private Algorithm() {
	    getInstance(); // check
	}

	Signature getInstance() {
	    try {
		return Signature.getInstance(name());
	    } catch (NoSuchAlgorithmException e) {
		throw new RuntimeException(e);
	    }

	}

    }

    public static Optional<Signature> ofAlgorithm(Algorithm algorithm) {
	if (MyObjects.isNull(algorithm))
	    return Optional.empty();
	return Optional.of(algorithm) //
		.map(Algorithm::getInstance);
    }

    public static Optional<SigningSignature> forSignature(PrivateKey key, Algorithm algorithm) {
	if (MyObjects.isNull(key))
	    return Optional.empty();
	if (MyObjects.isNull(algorithm))
	    return Optional.empty();

	return ofAlgorithm(algorithm) //
		.map(x -> {
		    try {
			x.initSign(key);
			return x;
		    } catch (InvalidKeyException e) {
			return null;
		    }
		}) //
		.map(SigningSignature::new);
    }

    public static Optional<VerifyingSignature> forVerification(PublicKey key, Algorithm algorithm) {
	if (MyObjects.isNull(key))
	    return Optional.empty();
	if (MyObjects.isNull(algorithm))
	    return Optional.empty();
	return ofAlgorithm(algorithm) //
		.map(x -> {
		    try {
			x.initVerify(key);
			return x;
		    } catch (InvalidKeyException e) {
			return null;
		    }
		}) //
		.map(VerifyingSignature::new);
    }

    public static Optional<VerifyingSignature> forVerification(X509Certificate cert, Algorithm algorithm) {
	if (MyObjects.isNull(cert))
	    return Optional.empty();
	if (MyObjects.isNull(algorithm))
	    return Optional.empty();
	return ofAlgorithm(algorithm) //
		.map(x -> {
		    try {
			x.initVerify(cert);
			return x;
		    } catch (InvalidKeyException e) {
			return null;
		    }
		}) //
		.map(VerifyingSignature::new);
    }

    public static final class VerifyingSignature {

	private final Signature sig;

	private VerifyingSignature(Signature sig) {
	    this.sig = MyObjects.requireNonNull(sig, "sig");
	}

	public boolean verify(byte[] data, byte[] digest) throws SignatureException {
	    sig.update(data);
	    return sig.verify(digest);
	}

    }

    public static final class SigningSignature {

	private final Signature sig;

	private SigningSignature(Signature sig) {
	    this.sig = MyObjects.requireNonNull(sig, "sig");
	}

	public byte[] sign(byte[] data) throws SignatureException {
	    sig.update(data);
	    return sig.sign();
	}
    }
}
