package com.lapsa.commons.function;

import java.util.function.Function;

public final class MyObjects {

    private MyObjects() {
    }

    public static final boolean isA(Object x, Class<?> clazz) {
	return clazz.isAssignableFrom(x.getClass());
    }

    public static final <T> Function<Object, T> cast(Class<T> clazz) {
	return clazz::cast;
    }

}
