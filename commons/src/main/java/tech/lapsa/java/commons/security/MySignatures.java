package tech.lapsa.java.commons.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.Optional;

import tech.lapsa.java.commons.function.MyExceptions;
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
	    } catch (final NoSuchAlgorithmException e) {
		throw new RuntimeException(e);
	    }
	}

    }

    public static Optional<Signature> ofAlgorithm(final Algorithm algorithm) {
	if (MyObjects.isNull(algorithm))
	    return Optional.empty();
	return MyOptionals.of(algorithm) //
		.map(Algorithm::getInstance);
    }

    public static Optional<Signature> ofAlgorithm(final String algorithmName) {
	if (MyStrings.empty(algorithmName))
	    return Optional.empty();
	return MyOptionals.of(algorithmName) //
		.map(x -> {
		    try {
			return Signature.getInstance(x);
		    } catch (final NoSuchAlgorithmException e) {
			return null;
		    }
		});
    }

    public static Optional<SigningSignature> forSignature(final PrivateKey key, final String algorithmName) {
	if (MyObjects.isNull(key))
	    return Optional.empty();
	if (MyStrings.empty(algorithmName))
	    return Optional.empty();

	return ofAlgorithm(algorithmName) //
		.map(x -> {
		    try {
			x.initSign(key);
			return x;
		    } catch (final InvalidKeyException e) {
			return null;
		    }
		}) //
		.map(SigningSignature::new);
    }

    public static Optional<SigningSignature> forSignature(final PrivateKey key, final Algorithm algorithm) {
	if (MyObjects.isNull(algorithm))
	    return Optional.empty();
	return forSignature(key, algorithm.name());
    }

    public static Optional<VerifyingSignature> forVerification(final PublicKey key, final String algorithmName) {
	if (MyObjects.isNull(key))
	    return Optional.empty();
	if (MyStrings.empty(algorithmName))
	    return Optional.empty();
	return ofAlgorithm(algorithmName) //
		.map(x -> {
		    try {
			x.initVerify(key);
			return x;
		    } catch (final InvalidKeyException e) {
			return null;
		    }
		}) //
		.map(VerifyingSignature::new);
    }

    public static Optional<VerifyingSignature> forVerification(final PublicKey key, final Algorithm algorithm) {
	if (MyObjects.isNull(algorithm))
	    return Optional.empty();
	return forVerification(key, algorithm.name());
    }

    public static Optional<VerifyingSignature> forVerification(final X509Certificate cert, final String algorithmName) {
	if (MyObjects.isNull(cert))
	    return Optional.empty();
	if (MyStrings.empty(algorithmName))
	    return Optional.empty();
	return ofAlgorithm(algorithmName) //
		.map(x -> {
		    try {
			x.initVerify(cert);
			return x;
		    } catch (final InvalidKeyException e) {
			return null;
		    }
		}) //
		.map(VerifyingSignature::new);
    }

    public static Optional<VerifyingSignature> forVerification(final X509Certificate cert, final Algorithm algorithm) {
	if (MyObjects.isNull(algorithm))
	    return Optional.empty();
	return forVerification(cert, algorithm.name());
    }

    public static final class VerifyingSignature {

	private final Signature sig;

	private VerifyingSignature(final Signature sig) throws IllegalArgumentException {
	    this.sig = MyObjects.requireNonNull(sig, "sig");
	}

	public boolean verify(final byte[] data, final byte[] digest) throws IllegalArgumentException {
	    if (data == null || data.length == 0)
		throw MyExceptions.illegalArgumentPar("Zero length array or null", "data");
	    if (digest == null || digest.length == 0)
		throw MyExceptions.illegalArgumentPar("Zero length array or null", "digest");
	    try {
		sig.update(data);
		return sig.verify(digest);
	    } catch (final SignatureException e) {
		throw new RuntimeException(e);
	    } finally {
		try {
		    sig.update(new byte[0]);
		} catch (final SignatureException ignored) {
		}
	    }
	}

	public Signature getSignature() {
	    return sig;
	}
    }

    public static final class SigningSignature {

	private final Signature sig;

	private SigningSignature(final Signature sig) throws IllegalArgumentException {
	    this.sig = MyObjects.requireNonNull(sig, "sig");
	}

	public byte[] sign(final byte[] data) throws IllegalArgumentException {
	    if (data == null || data.length == 0)
		throw MyExceptions.illegalArgumentPar("Zero length array or null", "data");
	    try {
		sig.update(data);
		return sig.sign();
	    } catch (final SignatureException e) {
		throw new RuntimeException(e);
	    } finally {
		try {
		    sig.update(new byte[0]);
		} catch (final SignatureException ignored) {
		}
	    }
	}

	public Signature getSignature() {
	    return sig;
	}
    }
}
