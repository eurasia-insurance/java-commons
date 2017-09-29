package com.lapsa.commons.function;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public final class MyMaps {

    private MyMaps() {
    }

    public static boolean empty(final Map<?, ?> map) {
	return Objects.isNull(map) || map.isEmpty();
    }

    public static boolean nonEmpty(final Map<?, ?> map) {
	return !empty(map);
    }

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
	    public V setValue(V value) {
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

    public static <K, V> Map<K, V> of(K k1, V v1) {
	return Stream.of(entry(k1, v1)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
	return Stream.of(entry(k1, v1), entry(k2, v2)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5), entry(k6, v6)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7,
	    V v7) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5), entry(k6, v6),
		entry(k7, v7)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7,
	    V v7, K k8, V v8) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5), entry(k6, v6),
		entry(k7, v7), entry(k8, v8)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7,
	    V v7, K k8, V v8, K k9, V v9) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5), entry(k6, v6),
		entry(k7, v7), entry(k8, v8), entry(k9, v9)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7,
	    V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
	return Stream.of(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5), entry(k6, v6),
		entry(k7, v7), entry(k8, v8), entry(k9, v9), entry(k10, v10)) //
		.collect(MyCollectors.unmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
