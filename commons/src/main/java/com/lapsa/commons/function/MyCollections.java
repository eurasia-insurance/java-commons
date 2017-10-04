package com.lapsa.commons.function;

import java.util.Collection;

public final class MyCollections {

    private MyCollections() {
    }

    private static final String SOME_ELEMENTS_ARE_NULL = "Some elements are null";
    private static final String SOME_ELEMENTS_ARE_NOT_NULL = "Some elements are not null";

    private static final String COLLECTION_IS_EMPTY = "Collection is empty";
    private static final String COLLECTION_IS_NOT_EMPTY = "Colletion is not empty";

    // COLLECTION

    public static <T, C extends Collection<T>> boolean empty(final C collection) {
	return MyObjects.isNull(collection) || collection.isEmpty();
    }

    public static <T, C extends Collection<T>> C requireEmpty(final C collection) {
	return requireEmpty(collection, COLLECTION_IS_NOT_EMPTY);
    }

    public static <T, C extends Collection<T>> C requireEmpty(final C collection, final String message) {
	if (empty(collection)) //
	    return collection;
	throw new IllegalArgumentException(message);
    }

    //

    public static <T, C extends Collection<T>> boolean nonEmpty(final C collection) {
	return !empty(collection);
    }

    public static <T, C extends Collection<T>> C requireNonEmpty(final C collection) {
	return requireNonEmpty(collection, COLLECTION_IS_EMPTY);
    }

    public static <T, C extends Collection<T>> C requireNonEmpty(final C collection, final String message) {
	if (nonEmpty(collection)) //
	    return collection;
	throw new IllegalArgumentException(message);
    }

    //

    public static <T, C extends Collection<T>> boolean nonNullElements(final C collection) {
	return MyObjects.requireNonNull(collection) //
		.stream() //
		.allMatch(MyObjects::nonNull);
    }

    public static <T, C extends Collection<T>> C requireNonNullElements(final C collection) {
	return requireNonNullElements(collection, SOME_ELEMENTS_ARE_NULL);
    }

    public static <T, C extends Collection<T>> C requireNonNullElements(final C collection, final String message) {
	if (nonNullElements(collection)) //
	    return collection;
	throw new IllegalArgumentException(message);
    }

    //

    public static <T, C extends Collection<T>> boolean nullElements(final C collection) {
	return MyObjects.requireNonNull(collection) //
		.stream() //
		.allMatch(MyObjects::isNull);
    }

    public static <T, C extends Collection<T>> C requireNullElements(final C collection) {
	return requireNullElements(collection, SOME_ELEMENTS_ARE_NOT_NULL);
    }

    public static <T, C extends Collection<T>> C requireNullElements(final C collection, final String message) {
	if (nullElements(collection)) //
	    return collection;
	throw new IllegalArgumentException(message);
    }

}
