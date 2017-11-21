package tech.lapsa.java.commons.function;

import java.util.Collection;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final class MyStreams {

    private MyStreams() {
    }

    //

    public static <T, C extends Collection<T>> Stream<T> orEmptyOf(final C collection) {
	return MyOptionals.streamOfEmpty(collection) //
		.orElseGet(Stream::empty);
    }

    public static <T> Stream<T> orEmptyOf(final T[] array) {
	return MyOptionals.streamOfEmpty(array) //
		.orElseGet(Stream::empty);
    }

    public static IntStream orEmptyOf(final int[] array) {
	return MyOptionals.streamOfEmpty(array) //
		.orElseGet(IntStream::empty);
    }

    public static DoubleStream orEmptyOf(final double[] array) {
	return MyOptionals.streamOfEmpty(array) //
		.orElseGet(DoubleStream::empty);
    }

    public static LongStream orEmptyOf(final long[] array) {
	return MyOptionals.streamOfEmpty(array) //
		.orElseGet(LongStream::empty);
    }

    //
}
