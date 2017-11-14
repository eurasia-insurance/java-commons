package tech.lapsa.java.commons.function;

import java.util.function.Consumer;

public final class MyFunctions {

    private MyFunctions() {
    }

    private static final Consumer<?> VOID_CONSUMER = x -> {
    };

    @SuppressWarnings("unchecked")
    public static <T> Consumer<T> voidConsumer() {
	return (Consumer<T>) VOID_CONSUMER;
    }
}
