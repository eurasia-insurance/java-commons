package com.lapsa.commons.function;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public final class MyCollections {

    private MyCollections() {
    }

    //

    public static <T, C extends Collection<T>> C requireNonEmpty(final C collection) {
	if (empty(collection))
	    throw new IllegalArgumentException("collection is empty");
	return collection;
    }

    public static <T, C extends Collection<T>> C requireNonEmpty(final C collection, final String message) {
	if (empty(collection))
	    throw new IllegalArgumentException(message);
	return collection;
    }

    public static <T, C extends Collection<T>> C requireEmpty(final C collection) {
	if (nonEmpty(collection))
	    throw new IllegalArgumentException("collection is not empty");
	return collection;
    }

    public static <T, C extends Collection<T>> C requireEmpty(final C collection, final String message) {
	if (nonEmpty(collection))
	    throw new IllegalArgumentException(message);
	return collection;
    }

    //

    public static <T, C extends Collection<T>> boolean empty(final C collection) {
	return Objects.isNull(collection) || collection.isEmpty();
    }

    public static <T, C extends Collection<T>> boolean nonEmpty(final C collection) {
	return !empty(collection);
    }

    //

    public static <K, V, M extends Map<K, V>> boolean empty(final M map) {
	return Objects.isNull(map) || map.isEmpty();
    }

    public static <K, V, M extends Map<K, V>> boolean nonEmpty(final M map) {
	return !empty(map);
    }

    //

    public static <T> boolean empty(final T[] array) {
	return Objects.isNull(array) || array.length == 0;
    }

    public static <T> boolean nonEmpty(final T[] array) {
	return !empty(array);
    }

    //

    public static boolean empty(final int[] array) {
	return Objects.isNull(array) || array.length == 0;
    }

    public static boolean nonEmpty(final int[] array) {
	return !empty(array);
    }

    //

    public static boolean empty(final byte[] array) {
	return Objects.isNull(array) || array.length == 0;
    }

    public static boolean nonEmpty(final byte[] array) {
	return !empty(array);
    }

    //

    public static boolean empty(final short[] array) {
	return Objects.isNull(array) || array.length == 0;
    }

    public static boolean nonEmpty(final short[] array) {
	return !empty(array);
    }

    //

    public static boolean empty(final double[] array) {
	return Objects.isNull(array) || array.length == 0;
    }

    public static boolean nonEmpty(final double[] array) {
	return !empty(array);
    }

    //

    public static boolean empty(final long[] array) {
	return Objects.isNull(array) || array.length == 0;
    }

    public static boolean nonEmpty(final long[] array) {
	return !empty(array);
    }
}
