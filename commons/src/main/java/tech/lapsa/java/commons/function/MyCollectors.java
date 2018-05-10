package tech.lapsa.java.commons.function;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public final class MyCollectors {

    private MyCollectors() {
    }

    public static <T, K, U> Collector<T, ?, Map<K, U>> unmodifiableMap(final Function<? super T, ? extends K> keyMapper,
	    final Function<? super T, ? extends U> valueMapper) {
	return collectingAndThen(toMap(keyMapper, valueMapper), Collections::unmodifiableMap);
    }

    public static <T> Collector<T, ?, List<T>> unmodifiableList() {
	return collectingAndThen(toList(), Collections::unmodifiableList);
    }

    public static <T> Collector<T, ?, Set<T>> unmodifiableSet() {
	return collectingAndThen(toSet(), Collections::unmodifiableSet);
    }

    public static Collector<Map.Entry<?, ?>, ?, Properties> entriesToStringProperties() {

	return new Collector<Map.Entry<?, ?>, Properties, Properties>() {

	    @Override
	    public Supplier<Properties> supplier() {
		return Properties::new;
	    }

	    @Override
	    public BiConsumer<Properties, Entry<?, ?>> accumulator() {
		return (prop, entry) -> prop.setProperty(entry.getKey().toString(), entry.getValue().toString());
	    }

	    @Override
	    public BinaryOperator<Properties> combiner() {
		return (p1, p2) -> {
		    final Properties ret = new Properties();
		    ret.putAll(p1);
		    ret.putAll(p2);
		    return ret;
		};
	    }

	    @Override
	    public Function<Properties, Properties> finisher() {
		return Function.identity();
	    }

	    @Override
	    public Set<Characteristics> characteristics() {
		return MySets.of(Characteristics.UNORDERED, Characteristics.CONCURRENT);
	    }
	};
    }
}
