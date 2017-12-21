package tech.lapsa.java.commons.util;

import java.util.Optional;
import java.util.UUID;

import tech.lapsa.java.commons.function.MyOptionals;

public final class MyUUIDs {

    private MyUUIDs() {
    }

    public static Optional<UUID> optOf(final String uuid) {
	return MyOptionals.of(uuid) //
		.map(s -> {
		    try {
			return UUID.fromString(uuid);
		    } catch (final Exception e) {
			return null;
		    }
		});
    }
}
