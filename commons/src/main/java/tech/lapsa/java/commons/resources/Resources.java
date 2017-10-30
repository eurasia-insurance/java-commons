package tech.lapsa.java.commons.resources;

import java.io.InputStream;
import java.util.Optional;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;

public final class Resources {

    private Resources() {
    }

    public static Optional<InputStream> optionalAsStream(Class<?> thisClazz, String resource) {
	return MyOptionals.of(getAsStream(thisClazz, resource));
    }

    public static InputStream getAsStream(Class<?> thisClazz, String resource) {
	MyStrings.requireNonEmpty(resource, "resource");
	MyObjects.requireNonNull(thisClazz, "thisClazz");

	while (resource.startsWith("/"))
	    resource = resource.substring(1);

	ClassLoader classLoader = Thread.currentThread()
		.getContextClassLoader();

	InputStream result = null;
	if (classLoader == null) {
	    classLoader = thisClazz.getClassLoader();
	    result = classLoader.getResourceAsStream(resource);
	} else {
	    result = classLoader.getResourceAsStream(resource);

	    if (result == null) {
		classLoader = thisClazz.getClassLoader();
		if (classLoader != null)
		    result = classLoader.getResourceAsStream(resource);
	    }
	}
	return result;
    }
}
