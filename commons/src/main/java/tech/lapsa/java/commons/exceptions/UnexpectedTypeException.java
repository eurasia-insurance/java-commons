package tech.lapsa.java.commons.exceptions;

public class UnexpectedTypeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnexpectedTypeException(final Class<?> expectedClazz, final Class<?> actualClazz) {
	super(String.format("Expected type is %1$s but the actual type was %2$s", expectedClazz, actualClazz));
    }

    public UnexpectedTypeException(final String message) {
	super(message);
    }
}
