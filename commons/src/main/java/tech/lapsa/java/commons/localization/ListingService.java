package tech.lapsa.java.commons.elements;

public interface ListingService<T> {

    T[] getAll();

    T[] getSelectable();

    T[] getNonSelectable();

}
