package tech.lapsa.java.commons.reflect;

import java.lang.annotation.Annotation;
import java.util.Optional;

import tech.lapsa.java.commons.function.MyOptionals;

public class MyAnnotations {

    public static <T extends Annotation> Optional<T> optionalOf(Class<?> clazz, Class<T> annotationClazz) {
	return MyOptionals.of(clazz.getAnnotation(annotationClazz));
    }

}
