package tech.lapsa.java.commons.io;

import java.io.InputStream;
import java.util.Optional;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.lang.MyClassLoaderBased;

public final class MyResources {

    private MyResources() {
    }

    public static Optional<InputStream> optAsStream(final Class<?> thisClazz, final String resource) {
	MyObjects.requireNonNull(thisClazz, "thisClazz");
	MyStrings.requireNonEmpty(resource, "resource");

	final String res = resource.startsWith("/") ? resource.substring(1) : resource;

	return MyClassLoaderBased.optOf(thisClazz, cl -> cl.getResourceAsStream(res));
    }

    public static InputStream getAsStream(final Class<?> thisClazz, final String resource) {
	return optAsStream(thisClazz, resource).orElse(null);
    }
}
