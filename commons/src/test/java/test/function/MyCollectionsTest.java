package test.function;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static test.function.MyExceptionsTest.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.lapsa.commons.function.MyCollections;
import com.lapsa.commons.function.MyMaps;

public class MyCollectionsTest {

    @SuppressWarnings("unchecked")
    @Test
    public void test_Map_of() {
	Map<String, String> m0 = MyMaps.of();
	assertThat(m0, not(nullValue()));
	assertThat(m0.entrySet(), empty());

	Map<String, String> m1 = MyMaps.of("a", "a1");
	assertThat(m1, allOf(not(nullValue()), hasEntry("a", "a1")));

	Map<String, String> m2 = MyMaps.of("a", "a1", "b", "b1");
	assertThat(m2, allOf(not(nullValue()), hasEntry("a", "a1"), hasEntry("b", "b1")));

	Map<String, String> m3 = MyMaps.of("a", "a1", "b", "b1", "c", "c1");
	assertThat(m3, allOf(not(nullValue()), hasEntry("a", "a1"), hasEntry("b", "b1"), hasEntry("c", "c1")));

	Map<String, String> m4 = MyMaps.of("a", "a1", "b", "b1", "c", "c1", "d", "d1");
	assertThat(m4, allOf(not(nullValue()), hasEntry("a", "a1"), hasEntry("b", "b1"), hasEntry("c", "c1"),
		hasEntry("d", "d1")));

	Map<String, String> m5 = MyMaps.of("a", "a1", "b", "b1", "c", "c1", "d", "d1", "e", "e1");
	assertThat(m5, allOf(not(nullValue()), hasEntry("a", "a1"), hasEntry("b", "b1"), hasEntry("c", "c1"),
		hasEntry("d", "d1"), hasEntry("e", "e1")));

	Map<String, String> m6 = MyMaps.of("a", "a1", "b", "b1", "c", "c1", "d", "d1", "e", "e1", "f", "f1");
	assertThat(m6, allOf(not(nullValue()), hasEntry("a", "a1"), hasEntry("b", "b1"), hasEntry("c", "c1"),
		hasEntry("d", "d1"), hasEntry("e", "e1"), hasEntry("f", "f1")));

	Map<String, String> m7 = MyMaps.of("a", "a1", "b", "b1", "c", "c1", "d", "d1", "e", "e1", "f", "f1", "g", "g1");
	assertThat(m7, allOf(not(nullValue()), hasEntry("a", "a1"), hasEntry("b", "b1"), hasEntry("c", "c1"),
		hasEntry("d", "d1"), hasEntry("e", "e1"), hasEntry("f", "f1"), hasEntry("g", "g1")));

	Map<String, String> m8 = MyMaps.of("a", "a1", "b", "b1", "c", "c1", "d", "d1", "e", "e1", "f", "f1", "g", "g1",
		"h", "h1");
	assertThat(m8, allOf(not(nullValue()), hasEntry("a", "a1"), hasEntry("b", "b1"), hasEntry("c", "c1"),
		hasEntry("d", "d1"), hasEntry("e", "e1"), hasEntry("f", "f1"), hasEntry("g", "g1"),
		hasEntry("h", "h1")));

	Map<String, String> m9 = MyMaps.of("a", "a1", "b", "b1", "c", "c1", "d", "d1", "e", "e1", "f", "f1", "g", "g1",
		"h", "h1", "i", "i1");
	assertThat(m9, allOf(not(nullValue()), hasEntry("a", "a1"), hasEntry("b", "b1"), hasEntry("c", "c1"),
		hasEntry("d", "d1"), hasEntry("e", "e1"), hasEntry("f", "f1"), hasEntry("g", "g1"),
		hasEntry("h", "h1"), hasEntry("i", "i1")));

	Map<String, String> m10 = MyMaps.of("a", "a1", "b", "b1", "c", "c1", "d", "d1", "e", "e1", "f", "f1", "g", "g1",
		"h", "h1", "i", "i1", "j", "j1");
	assertThat(m10, allOf(not(nullValue()), hasEntry("a", "a1"), hasEntry("b", "b1"), hasEntry("c", "c1"),
		hasEntry("d", "d1"), hasEntry("e", "e1"), hasEntry("f", "f1"), hasEntry("g", "g1"),
		hasEntry("h", "h1"), hasEntry("i", "i1"), hasEntry("j", "j1")));

	Map<String, String> mN = MyMaps.ofEntries(
		MyMaps.entry("a", "a1"),
		MyMaps.entry("b", "b1"),
		MyMaps.entry("c", "c1"),
		MyMaps.entry("d", "d1"),
		MyMaps.entry("e", "e1"),
		MyMaps.entry("f", "f1"),
		MyMaps.entry("g", "g1"),
		MyMaps.entry("h", "h1"),
		MyMaps.entry("i", "i1"),
		MyMaps.entry("j", "j1"),
		MyMaps.entry("z", "z1"));

	assertThat(mN, allOf(not(nullValue()), hasEntry("a", "a1"), hasEntry("b", "b1"), hasEntry("c", "c1"),
		hasEntry("d", "d1"), hasEntry("e", "e1"), hasEntry("f", "f1"), hasEntry("g", "g1"),
		hasEntry("h", "h1"), hasEntry("i", "i1"), hasEntry("j", "j1"), hasEntry("z", "z1")));

    }

    @Test
    public void test_Collection() {

	final List<String> NULL = null;
	final List<String> EMPTY = Arrays.asList();
	final List<String> NON_EMPTY = Arrays.asList("a");

	final List<String> NULL_ELEMENTS = Arrays.asList(null, null, null);
	final List<String> NON_NULL_ELEMENTS = Arrays.asList("a", "b", "c");

	assertTrue(MyCollections.empty(NULL));
	assertTrue(MyCollections.empty(EMPTY));
	assertTrue(MyCollections.nonEmpty(NON_EMPTY));
	assertTrue(MyCollections.nullElements(NULL_ELEMENTS));
	assertTrue(MyCollections.nonNullElements(NON_NULL_ELEMENTS));
	unexpectException(() -> MyCollections.requireEmpty(NULL));
	unexpectException(() -> MyCollections.requireEmpty(NULL, "par"));
	unexpectException(() -> MyCollections.requireEmpty(EMPTY));
	unexpectException(() -> MyCollections.requireEmpty(EMPTY, "par"));
	unexpectException(() -> MyCollections.requireNonEmpty(NON_EMPTY));
	unexpectException(() -> MyCollections.requireNonEmpty(NON_EMPTY, "par"));
	unexpectException(() -> MyCollections.requireNullElements(NULL_ELEMENTS));
	unexpectException(() -> MyCollections.requireNullElements(NULL_ELEMENTS, "par"));
	unexpectException(() -> MyCollections.requireNonNullElements(NON_NULL_ELEMENTS));
	unexpectException(() -> MyCollections.requireNonNullElements(NON_NULL_ELEMENTS, "par"));

	assertFalse(MyCollections.nonEmpty(NULL));
	assertFalse(MyCollections.nonEmpty(EMPTY));
	assertFalse(MyCollections.empty(NON_EMPTY));
	assertFalse(MyCollections.nullElements(NON_NULL_ELEMENTS));
	assertFalse(MyCollections.nonNullElements(NULL_ELEMENTS));
	expectException(() -> MyCollections.requireNonEmpty(NULL), IllegalArgumentException.class);
	expectException(() -> MyCollections.requireNonEmpty(NULL, "par"), IllegalArgumentException.class);
	expectException(() -> MyCollections.requireNonEmpty(EMPTY), IllegalArgumentException.class);
	expectException(() -> MyCollections.requireNonEmpty(EMPTY, "par"), IllegalArgumentException.class);
	expectException(() -> MyCollections.requireEmpty(NON_EMPTY), IllegalArgumentException.class);
	expectException(() -> MyCollections.requireEmpty(NON_EMPTY, "par"), IllegalArgumentException.class);
	expectException(() -> MyCollections.requireNonNullElements(NULL_ELEMENTS), IllegalArgumentException.class);
	expectException(() -> MyCollections.requireNonNullElements(NULL_ELEMENTS, "par"), IllegalArgumentException.class);
	expectException(() -> MyCollections.requireNullElements(NON_NULL_ELEMENTS), IllegalArgumentException.class);
	expectException(() -> MyCollections.requireNullElements(NON_NULL_ELEMENTS, "par"), IllegalArgumentException.class);
    }
}
