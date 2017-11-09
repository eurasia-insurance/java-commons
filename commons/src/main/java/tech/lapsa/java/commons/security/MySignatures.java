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
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;

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
	return MyOptionals.of(algorithm) //
		.map(Algorithm::getInstance);
    }

    public static Optional<Signature> ofAlgorithm(String algorithmName) {
	if (MyStrings.empty(algorithmName))
	    return Optional.empty();
	return MyOptionals.of(algorithmName) //
		.map(x -> {
		    try {
			return Signature.getInstance(x);
		    } catch (NoSuchAlgorithmException e) {
			return null;
		    }
		});
    }

    public static Optional<SigningSignature> forSignature(PrivateKey key, String algorithmName) {
	if (MyObjects.isNull(key))
	    return Optional.empty();
	if (MyStrings.empty(algorithmName))
	    return Optional.empty();

	return ofAlgorithm(algorithmName) //
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

    public static Optional<SigningSignature> forSignature(PrivateKey key, Algorithm algorithm) {
	if (MyObjects.isNull(algorithm))
	    return Optional.empty();
	return forSignature(key, algorithm.name());
    }

    public static Optional<VerifyingSignature> forVerification(PublicKey key, String algorithmName) {
	if (MyObjects.isNull(key))
	    return Optional.empty();
	if (MyStrings.empty(algorithmName))
	    return Optional.empty();
	return ofAlgorithm(algorithmName) //
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

    public static Optional<VerifyingSignature> forVerification(PublicKey key, Algorithm algorithm) {
	if (MyObjects.isNull(algorithm))
	    return Optional.empty();
	return forVerification(key, algorithm.name());
    }

    public static Optional<VerifyingSignature> forVerification(X509Certificate cert, String algorithmName) {
	if (MyObjects.isNull(cert))
	    return Optional.empty();
	if (MyStrings.empty(algorithmName))
	    return Optional.empty();
	return ofAlgorithm(algorithmName) //
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

    public static Optional<VerifyingSignature> forVerification(X509Certificate cert, Algorithm algorithm) {
	if (MyObjects.isNull(algorithm))
	    return Optional.empty();
	return forVerification(cert, algorithm.name());
    }

    public static final class VerifyingSignature {

	private final Signature sig;

	private VerifyingSignature(Signature sig) {
	    this.sig = MyObjects.requireNonNull(sig, "sig");
	}

	public boolean verify(byte[] data, byte[] digest) {
	    try {
		sig.update(data);
		return sig.verify(digest);
	    } catch (SignatureException e) {
		throw new RuntimeException(e);
	    } finally {
		try {
		    sig.update(new byte[0]);
		} catch (SignatureException ignored) {
		}
	    }
	}

	public Signature getSignature() {
	    return sig;
	}
    }

    public static final class SigningSignature {

	private final Signature sig;

	private SigningSignature(Signature sig) {
	    this.sig = MyObjects.requireNonNull(sig, "sig");
	}

	public byte[] sign(byte[] data) {
	    try {
		sig.update(data);
		return sig.sign();
	    } catch (SignatureException e) {
		throw new RuntimeException(e);
	    } finally {
		try {
		    sig.update(new byte[0]);
		} catch (SignatureException ignored) {
		}
	    }
	}

	public Signature getSignature() {
	    return sig;
	}
    }
}
