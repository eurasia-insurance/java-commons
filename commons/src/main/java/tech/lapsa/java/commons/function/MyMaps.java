package tech.lapsa.java.commons.function;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public final class MyMaps {

    private MyMaps() {
    }

    private static final String MAP_IS_EMPTY = "Is empty";
    private static final String MAP_IS_NOT_EMPTY = "Is not empty";

    public static final <K, V> MapBuilder<K, V> builder() {
	return new MapBuilder<>();
    }

    public static final class MapBuilder<K, V> {

	private final Supplier<Map<K, V>> DEFAULT_CREATOR = HashMap::new;
	private final UnaryOperator<Map<K, V>> DEFAULT_FINISHER = Collections::unmodifiableMap;

	private final Map<K, V> cache = new HashMap<>();

	public MapBuilder<K, V> add(K k, V v) {
	    cache.put(k, v);
	    return this;
	}

	public Map<K, V> build(final Supplier<Map<K, V>> creator,
		final UnaryOperator<Map<K, V>> finisher) {
	    MyObjects.requireNonNull(creator, "creator");
	    MyObjects.requireNonNull(finisher, "finisher");
	    final Map<K, V> res = creator.get();
	    res.putAll(cache);
	    return finisher.apply(res);
	}

	public Map<K, V> build(final Supplier<Map<K, V>> creator) {
	    return build(creator, DEFAULT_FINISHER);
	}

	public Map<K, V> build(final UnaryOperator<Map<K, V>> finisher) {
	    return build(DEFAULT_CREATOR, finisher);
	}

	public Map<K, V> build() {
	    return build(DEFAULT_CREATOR, DEFAULT_FINISHER);
	}
    }

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
	throw MyExceptions.illegalArgumentPar(MAP_IS_NOT_EMPTY, par);
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
	throw MyExceptions.illegalArgumentPar(MAP_IS_EMPTY, par);
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

    public static <K, V> Map.Entry<K, V> e(final K k, final V v) {
	return entry(k, v);
    }

    @SafeVarargs
    public static <K, V> Map.Entry<K, List<V>> el(final K k, final V... vv) {
	return entry(k, Stream.of(vv).collect(MyCollectors.unmodifiableList()));
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
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2) {
	return MyMaps.<K, V> builder()
		.add(k2, v2)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3,
	    final K k4, final V v4) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.add(k4, v4)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3,
	    final K k4, final V v4,
	    final K k5, final V v5) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.add(k4, v4)
		.add(k5, v5)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3,
	    final K k4, final V v4,
	    final K k5, final V v5,
	    final K k6, final V v6) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.add(k4, v4)
		.add(k5, v5)
		.add(k6, v6)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3,
	    final K k4, final V v4,
	    final K k5, final V v5,
	    final K k6, final V v6,
	    final K k7, final V v7) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.add(k4, v4)
		.add(k5, v5)
		.add(k6, v6)
		.add(k7, v7)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3,
	    final K k4, final V v4,
	    final K k5, final V v5,
	    final K k6, final V v6,
	    final K k7, final V v7,
	    final K k8, final V v8) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.add(k4, v4)
		.add(k5, v5)
		.add(k6, v6)
		.add(k7, v7)
		.add(k8, v8)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3,
	    final K k4, final V v4,
	    final K k5, final V v5,
	    final K k6, final V v6,
	    final K k7, final V v7,
	    final K k8, final V v8,
	    final K k9, final V v9) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.add(k4, v4)
		.add(k5, v5)
		.add(k6, v6)
		.add(k7, v7)
		.add(k8, v8)
		.add(k9, v9)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3,
	    final K k4, final V v4,
	    final K k5, final V v5,
	    final K k6, final V v6,
	    final K k7, final V v7,
	    final K k8, final V v8,
	    final K k9, final V v9,
	    final K k10, final V v10) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.add(k4, v4)
		.add(k5, v5)
		.add(k6, v6)
		.add(k7, v7)
		.add(k8, v8)
		.add(k9, v9)
		.add(k10, v10)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3,
	    final K k4, final V v4,
	    final K k5, final V v5,
	    final K k6, final V v6,
	    final K k7, final V v7,
	    final K k8, final V v8,
	    final K k9, final V v9,
	    final K k10, final V v10,
	    final K k11, final V v11) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.add(k4, v4)
		.add(k5, v5)
		.add(k6, v6)
		.add(k7, v7)
		.add(k8, v8)
		.add(k9, v9)
		.add(k10, v10)
		.add(k11, v11)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3,
	    final K k4, final V v4,
	    final K k5, final V v5,
	    final K k6, final V v6,
	    final K k7, final V v7,
	    final K k8, final V v8,
	    final K k9, final V v9,
	    final K k10, final V v10,
	    final K k11, final V v11,
	    final K k12, final V v12) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.add(k4, v4)
		.add(k5, v5)
		.add(k6, v6)
		.add(k7, v7)
		.add(k8, v8)
		.add(k9, v9)
		.add(k10, v10)
		.add(k11, v11)
		.add(k12, v12)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3,
	    final K k4, final V v4,
	    final K k5, final V v5,
	    final K k6, final V v6,
	    final K k7, final V v7,
	    final K k8, final V v8,
	    final K k9, final V v9,
	    final K k10, final V v10,
	    final K k11, final V v11,
	    final K k12, final V v12,
	    final K k13, final V v13) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.add(k4, v4)
		.add(k5, v5)
		.add(k6, v6)
		.add(k7, v7)
		.add(k8, v8)
		.add(k9, v9)
		.add(k10, v10)
		.add(k11, v11)
		.add(k12, v12)
		.add(k13, v13)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3,
	    final K k4, final V v4,
	    final K k5, final V v5,
	    final K k6, final V v6,
	    final K k7, final V v7,
	    final K k8, final V v8,
	    final K k9, final V v9,
	    final K k10, final V v10,
	    final K k11, final V v11,
	    final K k12, final V v12,
	    final K k13, final V v13,
	    final K k14, final V v14) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.add(k4, v4)
		.add(k5, v5)
		.add(k6, v6)
		.add(k7, v7)
		.add(k8, v8)
		.add(k9, v9)
		.add(k10, v10)
		.add(k11, v11)
		.add(k12, v12)
		.add(k13, v13)
		.add(k14, v14)
		.build();
    }

    public static <K, V> Map<K, V> of(final K k1, final V v1,
	    final K k2, final V v2,
	    final K k3, final V v3,
	    final K k4, final V v4,
	    final K k5, final V v5,
	    final K k6, final V v6,
	    final K k7, final V v7,
	    final K k8, final V v8,
	    final K k9, final V v9,
	    final K k10, final V v10,
	    final K k11, final V v11,
	    final K k12, final V v12,
	    final K k13, final V v13,
	    final K k14, final V v14,
	    final K k15, final V v15) {
	return MyMaps.<K, V> builder()
		.add(k1, v1)
		.add(k2, v2)
		.add(k3, v3)
		.add(k4, v4)
		.add(k5, v5)
		.add(k6, v6)
		.add(k7, v7)
		.add(k8, v8)
		.add(k9, v9)
		.add(k10, v10)
		.add(k11, v11)
		.add(k12, v12)
		.add(k13, v13)
		.add(k14, v14)
		.add(k15, v15)
		.build();
    }

    //

    public static Properties toProperties(Map<?, ?> map) {
	return MyOptionals.of(map)
		.map(Map::entrySet)
		.orElse(Collections.emptySet())
		.stream()
		.collect(MyCollectors.entriesToProperties());
    }
}
