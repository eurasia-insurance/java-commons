package tech.lapsa.java.commons.function;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final class MyOptionals {

    private MyOptionals() {
    }

    //

    public static <T> Optional<T> of(final T optional) {
	return Optional.ofNullable(optional);
    }

    //

    public static <T, C extends Collection<T>> Optional<Stream<T>> streamOf(final C optionalCollection) {
	return of(optionalCollection) //
		.map(Collection::stream);
    }

    public static <T, C extends Collection<T>> Optional<Stream<T>> streamOfEmpty(final C optionalCollection) {
	return ofEmpty(optionalCollection) //
		.map(Collection::stream);
    }

    //

    public static <T> Optional<Stream<T>> streamOf(final T[] optionalArray) {
	return of(optionalArray) //
		.map(Arrays::stream);
    }

    public static <T> Optional<Stream<T>> streamOfEmpty(final T[] optionalArray) {
	return ofEmpty(optionalArray) //
		.map(Arrays::stream);
    }

    //

    public static Optional<IntStream> streamOf(final int[] optionalArray) {
	return of(optionalArray) //
		.map(Arrays::stream);
    }

    public static Optional<IntStream> streamOfEmpty(final int[] optionalArray) {
	return ofEmpty(optionalArray) //
		.map(Arrays::stream);
    }

    //

    public static Optional<DoubleStream> streamOf(final double[] optionalArray) {
	return of(optionalArray) //
		.map(Arrays::stream);
    }

    public static Optional<DoubleStream> streamOfEmpty(final double[] optionalArray) {
	return ofEmpty(optionalArray) //
		.map(Arrays::stream);
    }

    //

    public static Optional<LongStream> streamOf(final long[] optionalArray) {
	return of(optionalArray) //
		.map(Arrays::stream);
    }

    public static Optional<LongStream> streamOfEmpty(final long[] optionalArray) {
	return ofEmpty(optionalArray) //
		.map(Arrays::stream);
    }

    //

    public static <T, C extends Collection<T>> Optional<C> of(final C optionalCollection) {
	return Optional.ofNullable(optionalCollection) //
		.filter(MyCollections::nonEmpty);
    }

    public static <T, C extends Collection<T>> Optional<C> ofEmpty(final C optionalCollection) {
	return Optional.ofNullable(optionalCollection);
    }

    //

    public static <T> Optional<T[]> of(final T[] optionalArray) {
	return Optional.ofNullable(optionalArray) //
		.filter(MyArrays::nonEmpty);
    }

    public static <T> Optional<T[]> ofEmpty(final T[] optionalArray) {
	return Optional.ofNullable(optionalArray);
    }

    //

    public static Optional<int[]> of(final int[] optionalArray) {
	return Optional.ofNullable(optionalArray) //
		.filter(MyArrays::nonEmpty);
    }

    public static Optional<int[]> ofEmpty(final int[] optionalArray) {
	return Optional.ofNullable(optionalArray);
    }

    //

    public static Optional<double[]> of(final double[] optionalArray) {
	return Optional.ofNullable(optionalArray) //
		.filter(MyArrays::nonEmpty);
    }

    public static Optional<double[]> ofEmpty(final double[] optionalArray) {
	return Optional.ofNullable(optionalArray);
    }

    //

    public static Optional<long[]> of(final long[] optionalArray) {
	return Optional.ofNullable(optionalArray) //
		.filter(MyArrays::nonEmpty);
    }

    public static Optional<long[]> ofEmpty(final long[] optionalArray) {
	return Optional.ofNullable(optionalArray);
    }

    //

    public static <K, V, M extends Map<K, V>> Optional<M> of(final M optionalMap) {
	return Optional.ofNullable(optionalMap) //
		.filter(MyMaps::nonEmpty);
    }

    public static <K, V, M extends Map<K, V>> Optional<M> ofEmpty(final M optionalMap) {
	return Optional.ofNullable(optionalMap);
    }

    //

    public static Optional<String> of(final String string) {
	return Optional.ofNullable(string) //
		.filter(MyStrings::nonEmpty);
    }

    public static Optional<String> ofEmpty(final String string) {
	return Optional.ofNullable(string);
    }

    //

    public static <T extends Number> Optional<T> of(final T optional) {
	return Optional.ofNullable(optional) //
		.filter(MyNumbers::nonZero);
    }

    public static <T extends Number> Optional<T> ofZero(final T optional) {
	return Optional.ofNullable(optional);
    }

    //

    public static Optional<Double> of(final double optional) {
	return of(Double.valueOf(optional));
    }

    public static Optional<Double> ofZero(final double optional) {
	return ofZero(Double.valueOf(optional));
    }

    public static OptionalDouble ofDouble(final double optional) {
	return MyNumbers.nonZero(optional) //
		? OptionalDouble.of(optional) //
		: OptionalDouble.empty();
    }

    public static OptionalDouble ofZeroDouble(final double optional) {
	return OptionalDouble.of(optional);
    }

    public static OptionalDouble ofDouble(final Double optional) {
	return (optional == null) //
		? OptionalDouble.empty() //
		: ofDouble(optional.doubleValue());
    }

    public static OptionalDouble ofZeroDouble(final Double optional) {
	return (optional == null) //
		? OptionalDouble.empty() //
		: ofZeroDouble(optional.doubleValue());
    }

    //

    public static Optional<Integer> of(final int optional) {
	return of(Integer.valueOf(optional));
    }

    public static Optional<Integer> ofZero(final int optional) {
	return ofZero(Integer.valueOf(optional));
    }

    public static OptionalInt ofInt(final int optional) {
	return MyNumbers.nonZero(optional) //
		? OptionalInt.of(optional) //
		: OptionalInt.empty();
    }

    public static OptionalInt ofZeroInt(final int optional) {
	return OptionalInt.of(optional);
    }

    public static OptionalInt ofInt(final Integer optional) {
	return (optional == null) //
		? OptionalInt.empty() //
		: ofInt(optional.intValue());
    }

    public static OptionalInt ofZeroInt(final Integer optional) {
	return (optional == null) //
		? OptionalInt.empty() //
		: ofZeroInt(optional.intValue());
    }

    //

    public static Optional<Long> of(final long optional) {
	return of(Long.valueOf(optional));
    }

    public static Optional<Long> ofZero(final long optional) {
	return ofZero(Long.valueOf(optional));
    }

    public static OptionalLong ofInt(final long optional) {
	return MyNumbers.nonZero(optional) //
		? OptionalLong.of(optional) //
		: OptionalLong.empty();
    }

    public static OptionalLong ofZeroLong(final long optional) {
	return OptionalLong.of(optional);
    }

    public static OptionalLong ofLong(final Long optional) {
	return (optional == null) //
		? OptionalLong.empty() //
		: ofLong(optional.longValue());
    }

    public static OptionalLong ofZeroLong(final Long optional) {
	return (optional == null) //
		? OptionalLong.empty() //
		: ofZeroLong(optional.longValue());
    }

}
