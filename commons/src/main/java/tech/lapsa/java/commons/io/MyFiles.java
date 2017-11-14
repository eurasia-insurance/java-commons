package tech.lapsa.java.commons.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Optional;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;

public final class MyFiles {

    private MyFiles() {
    }

    public static Optional<InputStream> optionalAsStream(final String file) {
	return MyOptionals.of(getAsStream(file));
    }

    public static InputStream getAsStream(final String file) {
	MyStrings.requireNonEmpty(file, "file");
	try {
	    return new FileInputStream(file);
	} catch (final FileNotFoundException e) {
	    return null;
	}
    }
}
