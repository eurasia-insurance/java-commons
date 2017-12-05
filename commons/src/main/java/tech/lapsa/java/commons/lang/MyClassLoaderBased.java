package tech.lapsa.java.commons.lang;

import java.util.Optional;
import java.util.function.Function;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;

public final class MyClassLoaderBased {

    private MyClassLoaderBased() {
    }

    public static <T> Optional<T> optOf(final Function<ClassLoader, T> classLoaderBasedFunction) {
	return optOf(MyClassLoaderBased.class, classLoaderBasedFunction);
    }

    public static <T> Optional<T> optOf(final Class<?> thisClazz,
	    final Function<ClassLoader, T> classLoaderBasedFunction) {
	MyObjects.requireNonNull(thisClazz, "thisClazz");
	MyObjects.requireNonNull(classLoaderBasedFunction, "classLoaderBasedFunction");

	ClassLoader classLoader = Thread.currentThread()
		.getContextClassLoader();

	Optional<T> result = Optional.empty();
	if (classLoader == null) {
	    classLoader = thisClazz.getClassLoader();
	    result = MyOptionals.of(classLoaderBasedFunction.apply(classLoader));
	} else {
	    result = MyOptionals.of(classLoaderBasedFunction.apply(classLoader));

	    if (!result.isPresent()) {
		classLoader = thisClazz.getClassLoader();
		if (classLoader != null)
		    result = MyOptionals.of(classLoaderBasedFunction.apply(classLoader));
	    }
	}
	return result;
    }
}
