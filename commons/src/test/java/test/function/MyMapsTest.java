package test.function;

import static org.junit.Assert.*;
import static test.function.Exceptions.*;

import java.util.Map;

import org.junit.Test;

import tech.lapsa.java.commons.function.MyMaps;

public class MyMapsTest {

    @Test
    public void test_Map() {

	final Map<String, String> NULL = null;
	final Map<String, String> EMPTY = MyMaps.of();
	final Map<String, String> NON_EMPTY = MyMaps.of("a", "a", "b", "b");

	assertTrue(MyMaps.empty(NULL));
	assertTrue(MyMaps.empty(EMPTY));
	assertTrue(MyMaps.nonEmpty(NON_EMPTY));
	unexpectException(() -> MyMaps.requireEmpty(NULL));
	unexpectException(() -> MyMaps.requireEmpty(NULL, "par"));
	unexpectException(() -> MyMaps.requireEmpty(EMPTY));
	unexpectException(() -> MyMaps.requireEmpty(EMPTY, "par"));
	unexpectException(() -> MyMaps.requireNonEmpty(NON_EMPTY));
	unexpectException(() -> MyMaps.requireNonEmpty(NON_EMPTY, "par"));

	assertFalse(MyMaps.nonEmpty(NULL));
	assertFalse(MyMaps.nonEmpty(EMPTY));
	assertFalse(MyMaps.empty(NON_EMPTY));
	expectException(() -> MyMaps.requireNonEmpty(NULL), IllegalArgumentException.class);
	expectException(() -> MyMaps.requireNonEmpty(NULL, "par"), IllegalArgumentException.class);
	expectException(() -> MyMaps.requireNonEmpty(EMPTY), IllegalArgumentException.class);
	expectException(() -> MyMaps.requireNonEmpty(EMPTY, "par"), IllegalArgumentException.class);
	expectException(() -> MyMaps.requireEmpty(NON_EMPTY), IllegalArgumentException.class);
	expectException(() -> MyMaps.requireEmpty(NON_EMPTY, "par"), IllegalArgumentException.class);
    }
}
