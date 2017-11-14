package tech.lapsa.java.commons.function;

import java.util.Set;
import java.util.stream.Stream;

public final class MySets {

    private MySets() {
    }

    @SafeVarargs
    public static <E> Set<E> of(final E... elements) {
	return Stream.of(elements) //
		.collect(MyCollectors.unmodifiableSet());
    }

}
