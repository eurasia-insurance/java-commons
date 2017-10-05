package com.lapsa.commons.function;

import java.util.Collection;

public final class MyCollections {

    private MyCollections() {
    }

    private static final String SOME_ELEMENTS_ARE_NULL = "Has some null elements";
    private static final String SOME_ELEMENTS_ARE_NOT_NULL = "Has some non-null elements";

    private static final String COLLECTION_IS_EMPTY = "Is empty";
    private static final String COLLECTION_IS_NOT_EMPTY = "Is not empty";

    // COLLECTION

    public static <T, C extends Collection<T>> boolean empty(final C collection) {
	return MyObjects.isNull(collection) || collection.isEmpty();
    }

    public static <T, C extends Collection<T>> C requireEmpty(final C collection) {
	return requireEmpty(collection, null);
    }

    public static <T, C extends Collection<T>> C requireEmpty(final C collection, final String par) {
	if (empty(collection)) //
	    return collection;
	throw Exceptions.illegalArgumentException(COLLECTION_IS_NOT_EMPTY, par);
    }

    //

    public static <T, C extends Collection<T>> boolean nonEmpty(final C collection) {
	return !empty(collection);
    }

    public static <T, C extends Collection<T>> C requireNonEmpty(final C collection) {
	return requireNonEmpty(collection, null);
    }

    public static <T, C extends Collection<T>> C requireNonEmpty(final C collection, final String par) {
	if (nonEmpty(collection)) //
	    return collection;
	throw Exceptions.illegalArgumentException(COLLECTION_IS_EMPTY, par);
    }

    //

    public static <T, C extends Collection<T>> boolean nonNullElements(final C collection) {
	return MyObjects.requireNonNull(collection) //
		.stream() //
		.allMatch(MyObjects::nonNull);
    }

    public static <T, C extends Collection<T>> C requireNonNullElements(final C collection) {
	return requireNonNullElements(collection, null);
    }

    public static <T, C extends Collection<T>> C requireNonNullElements(final C collection, final String par) {
	if (nonNullElements(collection)) //
	    return collection;
	throw Exceptions.illegalArgumentException(SOME_ELEMENTS_ARE_NULL, par);
    }

    //

    public static <T, C extends Collection<T>> boolean nullElements(final C collection) {
	return MyObjects.requireNonNull(collection) //
		.stream() //
		.allMatch(MyObjects::isNull);
    }

    public static <T, C extends Collection<T>> C requireNullElements(final C collection) {
	return requireNullElements(collection, null);
    }

    public static <T, C extends Collection<T>> C requireNullElements(final C collection, final String par) {
	if (nullElements(collection)) //
	    return collection;
	throw Exceptions.illegalArgumentException(SOME_ELEMENTS_ARE_NOT_NULL, par);
    }

}
