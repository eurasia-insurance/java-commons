package tech.lapsa.java.commons.localization;

public interface ListingService<T> {

    T[] getAll();

    T[] getSelectable();

    T[] getNonSelectable();

}
