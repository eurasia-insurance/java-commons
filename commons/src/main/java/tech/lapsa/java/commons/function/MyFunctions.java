package tech.lapsa.java.commons.function;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public final class MyFunctions {

    private MyFunctions() {
    }

    private static final Consumer<?> VOID_CONSUMER = x -> {
    };

    @SuppressWarnings("unchecked")
    public static <T> Consumer<T> voidConsumer() {
	return (Consumer<T>) VOID_CONSUMER;
    }

    @FunctionalInterface
    public interface TriFunction<T, U, V, R> {

	R apply(T t, U u, V v);

	default <N> TriFunction<T, U, V, N> andThen(Function<? super R, ? extends N> after) {
	    Objects.requireNonNull(after);
	    return (T t, U u, V v) -> after.apply(apply(t, u, v));
	}
    }

}
