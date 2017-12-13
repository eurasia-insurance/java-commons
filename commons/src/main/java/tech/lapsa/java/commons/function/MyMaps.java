package tech.lapsa.java.commons.function;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

public final class MyMaps {

    private MyMaps() {
    }

    private static final String MAP_IS_EMPTY = "Is empty";
    private static final String MAP_IS_NOT_EMPTY = "Is not empty";

    // MAP

    public static <K, V, M extends Map<K, V>> boolean empty(final M map) {
	return MyObjects.isNull(map) || map.isEmpty();
    }

    public static <K, V, M extends Map<K, V>> M requireEmpty(final M map) throws IllegalArgumentException {
	return requireEmpty(map, null);
    }

    public static <K, V, M extends Map<K, V>> M requireEmpty(final M map, final String par)
	    throws IllegalArgumentException {
	if (empty(map)) //
	    return map;
	throw MyExceptions.illegalArgumentException(MAP_IS_NOT_EMPTY, par);
    }

    //

    public static <K, V, M extends Map<K, V>> boolean nonEmpty(final M map) {
	return !empty(map);
    }

    public static <K, V, M extends Map<K, V>> M requireNonEmpty(final M map) throws IllegalArgumentException {
	return requireNonEmpty(map, null);
    }

    public static <K, V, M extends Map<K, V>> M requireNonEmpty(final M map, final String par)
	    throws IllegalArgumentException {
	if (nonEmpty(map)) //
	    return map;
	throw MyExceptions.illegalArgumentException(MAP_IS_EMPTY, par);
    }

    //

    public static <K, V> Map.Entry<K, V> entry(final K k, final V v) {
	return new Map.Entry<K, V>() {

	    @Override
	    public K getKey() {
		return k;
	    }

	    @Override
	    public V getValue() {
		return v;
	    }

	    @Override
	    public V setValue(final V value) {
		throw new UnsupportedOperationException();
	    }
	};
    }

    @SafeVarargs
    public static <K, V> Map<K, V> ofEntries(final Map.Entry<K, V>... entries) {
	return Stream.of(entries) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of() {
	return Collections.emptyMap();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1) {
	return Stream.of(entry(k1, v1)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1, final K k2, final V v2) {
	return Stream.of(entry(k1, v1), entry(k2, v2)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1, final K k2, final V v2, final K k3, final V v3) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1, final K k2, final V v2, final K k3, final V v3,
	    final K k4, final V v4) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1, final K k2, final V v2, final K k3, final V v3,
	    final K k4, final V v4, final K k5, final V v5) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1, final K k2, final V v2, final K k3, final V v3,
	    final K k4, final V v4, final K k5, final V v5, final K k6, final V v6) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5), entry(k6, v6)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1, final K k2, final V v2, final K k3, final V v3,
	    final K k4, final V v4, final K k5, final V v5, final K k6, final V v6, final K k7,
	    final V v7) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5), entry(k6, v6),
		entry(k7, v7)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1, final K k2, final V v2, final K k3, final V v3,
	    final K k4, final V v4, final K k5, final V v5, final K k6, final V v6, final K k7,
	    final V v7, final K k8, final V v8) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5), entry(k6, v6),
		entry(k7, v7), entry(k8, v8)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1, final K k2, final V v2, final K k3, final V v3,
	    final K k4, final V v4, final K k5, final V v5, final K k6, final V v6, final K k7,
	    final V v7, final K k8, final V v8, final K k9, final V v9) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5), entry(k6, v6),
		entry(k7, v7), entry(k8, v8), entry(k9, v9)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1, final K k2, final V v2, final K k3, final V v3,
	    final K k4, final V v4, final K k5, final V v5, final K k6, final V v6, final K k7,
	    final V v7, final K k8, final V v8, final K k9, final V v9, final K k10, final V v10) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5), entry(k6, v6),
		entry(k7, v7), entry(k8, v8), entry(k9, v9), entry(k10, v10)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
