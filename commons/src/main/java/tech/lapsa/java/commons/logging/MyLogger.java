package tech.lapsa.java.commons.logging;

import java.time.Instant;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;

public final class MyLogger {

    private final Logger logger;
    private final UnaryOperator<String> handler;

    private MyLogger(final Logger logger, final UnaryOperator<String> handler) {
	this.logger = MyObjects.requireNonNull(logger, "logger");
	this.handler = MyObjects.requireNonNull(handler, "handler");
    }

    public final class MyLevel {
	private final Level level;

	private MyLevel(final Level level) {
	    this.level = level;
	}

	public MyLogger log(final String message) {
	    logger.log(level, handler.apply(message));
	    return MyLogger.this;
	}

	public MyLogger log(final String format, final Object... args) {
	    logger.log(level, handler.apply(MyStrings.format(format, args)));
	    return MyLogger.this;
	}

	private static final String EXCEPTION_MESSAGE_FORMAT = "Exception has thrown %1$s '%2$s'";

	public MyLogger log(final Throwable thrown) {
	    MyObjects.requireNonNull(thrown, "thrown");
	    logger.log(level,
		    handler.apply(String.format(EXCEPTION_MESSAGE_FORMAT, thrown.getClass(), thrown.getMessage())),
		    thrown);
	    return MyLogger.this;
	}

	public MyLogger log(final Throwable thrown, final String message) {
	    log(thrown);
	    if (MyStrings.nonEmpty(message))
		logger.log(level, handler.apply(message));
	    return MyLogger.this;
	}

	public MyLogger log(final Throwable thrown, final String format, final Object... args) {
	    log(thrown);
	    if (MyStrings.nonEmpty(format))
		logger.log(level, handler.apply(String.format(format, args)));
	    return MyLogger.this;
	}
    }

    public final MyLevel CONFIG = new MyLevel(Level.CONFIG);

    public final MyLevel INFO = new MyLevel(Level.INFO);
    public final MyLevel MESSAGE = INFO;

    public final MyLevel FINE = new MyLevel(Level.FINE);
    public final MyLevel DEBUG = FINE;

    public final MyLevel FINER = new MyLevel(Level.FINER);
    public final MyLevel TRACE = FINER;

    public final MyLevel FINEST = new MyLevel(Level.FINEST);
    public final MyLevel SUPER_TRACE = FINEST;

    public final MyLevel SEVERE = new MyLevel(Level.SEVERE);

    public final MyLevel WARNING = new MyLevel(Level.WARNING);

    public final MyLevel WARN = WARNING;

    public Logger logger() {
	return logger;
    }

    private final static MyLogger DEFAULT = newBuilder().build();

    public static MyLogger getDefault() {
	return DEFAULT;
    }

    public static MyLoggerBuilder newBuilder() {
	return new MyLoggerBuilder();
    }

    public static final class MyLoggerBuilder {

	private String name;

	private Function<String, String> handler;

	private MyLoggerBuilder() {
	}

	public MyLoggerBuilder withNameOf(final Package pack) {
	    name = MyObjects.requireNonNull(pack, "pack").getName();
	    return this;
	}

	public MyLoggerBuilder withNameOf(final Class<?> clazz) {
	    name = MyObjects.requireNonNull(clazz, "clazz").getName();
	    return this;
	}

	public MyLoggerBuilder withName(final String name) {
	    this.name = MyStrings.requireNonEmpty(name, "name");
	    return this;
	}

	public MyLoggerBuilder withPackageNameOf(final Class<?> clazz) {
	    name = MyObjects.requireNonNull(clazz, "clazz").getPackage().getName();
	    return this;
	}

	public MyLoggerBuilder addInstantPrefix() {
	    addAfter(x -> Instant.now().toString() + " " + x);
	    return this;
	}

	public MyLoggerBuilder addPrefix(final String prefix) {
	    MyStrings.requireNonEmpty(prefix);
	    addAfter(x -> prefix + " : " + x);
	    return this;
	}

	public MyLoggerBuilder addHandler(final UnaryOperator<String> handler) {
	    MyObjects.requireNonNull(handler, "handler");
	    addAfter(handler);
	    return this;
	}

	public MyLoggerBuilder addLoggerNameAsPrefix() {
	    return addPrefix(name);
	}

	public MyLoggerBuilder addWithSuffix(final String suffix) {
	    MyStrings.requireNonEmpty(suffix);
	    addAfter(x -> x + " " + suffix);
	    return this;
	}

	public MyLoggerBuilder addWithCAPS() {
	    addAfter(String::toUpperCase);
	    return this;
	}

	public MyLoggerBuilder clearHandler() {
	    handler = null;
	    return this;
	}

	private void addAfter(final Function<String, String> after) {
	    MyObjects.requireNonNull(after, "after");
	    handler = MyObjects.isNull(handler) //
		    ? after //
		    : after.andThen(handler);
	}

	public MyLogger build() {
	    final Logger logger = MyStrings.empty(name) //
		    ? Logger.getAnonymousLogger() //
		    : Logger.getLogger(name);

	    final UnaryOperator<String> hndlr = MyObjects.isNull(handler) //
		    ? x -> x //
		    : handler::apply;

	    return new MyLogger(logger, hndlr);
	}
    }
}
