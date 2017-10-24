package tech.lapsa.java.commons.logging;

import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;

public final class MyLogger {

    private final Logger logger;
    private Function<String, String> handler;

    private MyLogger(Logger logger, Function<String, String> handler) {
	this.logger = MyObjects.requireNonNull(logger, "logger");
	this.handler = MyObjects.requireNonNull(handler, "handler");

    }

    public final class MyLevel {
	private final Level level;

	private MyLevel(Level level) {
	    this.level = level;
	}

	public MyLogger log(String message) {
	    logger.log(level, handler.apply(message));
	    return MyLogger.this;
	}

	public MyLogger log(String format, Object... args) {
	    logger.log(level, handler.apply(String.format(format, args)));
	    return MyLogger.this;
	}

	public MyLogger log(String message, Throwable cause) {
	    logger.log(level, handler.apply(message), cause);
	    return MyLogger.this;
	}

	public MyLogger log(Throwable cause) {
	    logger.log(level, handler.apply(cause.getMessage()), cause);
	    return MyLogger.this;
	}

	public MyLogger log(Throwable cause, String format, Object... args) {
	    logger.log(level, handler.apply(String.format(format, args)), cause);
	    return MyLogger.this;
	}
    }

    public final MyLevel CONFIG = new MyLevel(Level.CONFIG);
    public final MyLevel INFO = new MyLevel(Level.INFO);
    public final MyLevel FINE = new MyLevel(Level.FINE);
    public final MyLevel FINER = new MyLevel(Level.FINER);
    public final MyLevel FINEST = new MyLevel(Level.FINEST);
    public final MyLevel SEVERE = new MyLevel(Level.SEVERE);
    public final MyLevel WARNING = new MyLevel(Level.WARNING);

    public Logger logger() {
	return logger;
    }

    public static MyLoggerBuilder newBuilder() {
	return new MyLoggerBuilder();
    }

    public static final class MyLoggerBuilder {

	private String name;

	private Function<String, String> handler = x -> x;

	private MyLoggerBuilder() {
	}

	public MyLoggerBuilder withNameOf(Package pack) {
	    this.name = MyObjects.requireNonNull(pack).getName();
	    return this;
	}

	public MyLoggerBuilder withNameOf(Class<?> clazz) {
	    this.name = MyObjects.requireNonNull(clazz).getName();
	    return this;
	}

	public MyLoggerBuilder withName(String name) {
	    this.name = MyStrings.requireNonEmpty(name, "name");
	    return this;
	}

	public MyLoggerBuilder withPackageNameOf(Class<?> clazz) {
	    this.name = MyObjects.requireNonNull(clazz).getPackage().getName();
	    return this;
	}

	public MyLoggerBuilder withPrefix(String prefix) {
	    MyStrings.requireNonEmpty(prefix);
	    handler = handler.andThen(x -> prefix + " : " + x);
	    return this;
	}

	public MyLoggerBuilder withCAPS() {
	    handler = handler.andThen(String::toUpperCase);
	    return this;
	}

	public MyLoggerBuilder clearHandlers() {
	    handler = x -> x;
	    return this;
	}

	public MyLogger build() {
	    Logger logger = Logger.getLogger(MyStrings.requireNonEmpty(name));
	    return new MyLogger(logger, handler);
	}
    }
}
