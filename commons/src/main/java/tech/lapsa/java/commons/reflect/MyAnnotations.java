package tech.lapsa.java.commons.reflect;

import java.lang.annotation.Annotation;
import java.util.Optional;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;

public class MyAnnotations {

    public static <T extends Annotation> Optional<T> optionalOf(final Class<?> clazz, final Class<T> annotationClazz) {
	return MyOptionals.of(of(clazz, annotationClazz));
    }

    public static <T extends Annotation> T of(final Class<?> clazz, final Class<T> annotationClazz) {
	MyObjects.requireNonNull(clazz, "clazz");
	MyObjects.requireNonNull(annotationClazz, "annotationClazz");
	Class<?> nextCurrent = clazz;
	do {
	    final T an = nextCurrent.getAnnotation(annotationClazz);
	    if (an != null)
		return an;
	    nextCurrent = nextCurrent.getSuperclass();
	} while (nextCurrent != null);
	return null;
    }

}
