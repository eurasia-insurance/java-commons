package tech.lapsa.java.commons.function;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

    public static <T, C extends Collection<T>> C requireEmpty(final C collection) throws IllegalArgumentException {
	return requireEmpty(collection, null);
    }

    public static <T, C extends Collection<T>> C requireEmpty(final C collection, final String par)
	    throws IllegalArgumentException {
	if (empty(collection)) //
	    return collection;
	throw MyExceptions.illegalArgumentPar(COLLECTION_IS_NOT_EMPTY, par);
    }

    //

    public static <T, C extends Collection<T>> boolean nonEmpty(final C collection) {
	return !empty(collection);
    }

    public static <T, C extends Collection<T>> C requireNonEmpty(final C collection) throws IllegalArgumentException {
	return requireNonEmpty(collection, null);
    }

    public static <T, C extends Collection<T>> C requireNonEmpty(final C collection, final String par)
	    throws IllegalArgumentException {
	if (nonEmpty(collection)) //
	    return collection;
	throw MyExceptions.illegalArgumentPar(COLLECTION_IS_EMPTY, par);
    }

    //

    public static <T, C extends Collection<T>> boolean nonNullElements(final C collection) {
	return MyObjects.requireNonNull(collection) //
		.stream() //
		.allMatch(MyObjects::nonNull);
    }

    public static <T, C extends Collection<T>> C requireNonNullElements(final C collection)
	    throws IllegalArgumentException {
	return requireNonNullElements(collection, null);
    }

    public static <T, C extends Collection<T>> C requireNonNullElements(final C collection, final String par)
	    throws IllegalArgumentException {
	if (nonNullElements(collection)) //
	    return collection;
	throw MyExceptions.illegalArgumentPar(SOME_ELEMENTS_ARE_NULL, par);
    }

    //

    public static <T, C extends Collection<T>> boolean nullElements(final C collection) {
	return MyObjects.requireNonNull(collection) //
		.stream() //
		.allMatch(MyObjects::isNull);
    }

    public static <T, C extends Collection<T>> C requireNullElements(final C collection)
	    throws IllegalArgumentException {
	return requireNullElements(collection, null);
    }

    public static <T, C extends Collection<T>> C requireNullElements(final C collection, final String par)
	    throws IllegalArgumentException {
	if (nullElements(collection)) //
	    return collection;
	throw MyExceptions.illegalArgumentPar(SOME_ELEMENTS_ARE_NOT_NULL, par);
    }

    //

    public static <T> Optional<T> firstElement(final Iterable<T> iterable) {
	return MyOptionals.of(iterable) //
		.map(Iterable::iterator) //
		.filter(Iterator::hasNext) //
		.map(Iterator::next);

    }

    //

    public static <T> List<T> orEmptyList(final List<T> list) {
	if (empty(list))
	    return Collections.emptyList();
	return list;
    }

    public static <T> List<T> unmodifiableOrEmptyList(final List<T> list) {
	return Collections.unmodifiableList(orEmptyList(list));
    }

}
