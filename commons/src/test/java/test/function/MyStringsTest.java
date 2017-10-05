package test.function;

import static org.junit.Assert.*;
import static test.function.Exceptions.*;

import org.junit.Test;

import com.lapsa.commons.function.MyStrings;

public class MyStringsTest {

    @Test
    public void test_empty() {

	final String NULL = null;
	final String EMPTY = "";
	final String NON_EMPTY = "asd";

	assertTrue(MyStrings.empty(NULL));
	assertTrue(MyStrings.empty(EMPTY));
	assertTrue(MyStrings.nonEmpty(NON_EMPTY));
	unexpectException(() -> MyStrings.requireEmpty(NULL));
	unexpectException(() -> MyStrings.requireEmpty(NULL, "par"));
	unexpectException(() -> MyStrings.requireEmpty(EMPTY));
	unexpectException(() -> MyStrings.requireEmpty(EMPTY, "par"));
	unexpectException(() -> MyStrings.requireNonEmpty(NON_EMPTY));
	unexpectException(() -> MyStrings.requireNonEmpty(NON_EMPTY, "par"));

	assertFalse(MyStrings.nonEmpty(NULL));
	assertFalse(MyStrings.nonEmpty(EMPTY));
	assertFalse(MyStrings.empty(NON_EMPTY));
	expectException(() -> MyStrings.requireNonEmpty(NULL), IllegalArgumentException.class);
	expectException(() -> MyStrings.requireNonEmpty(NULL, "par"), IllegalArgumentException.class);
	expectException(() -> MyStrings.requireNonEmpty(EMPTY), IllegalArgumentException.class);
	expectException(() -> MyStrings.requireNonEmpty(EMPTY, "par"), IllegalArgumentException.class);
	expectException(() -> MyStrings.requireEmpty(NON_EMPTY), IllegalArgumentException.class);
	expectException(() -> MyStrings.requireEmpty(NON_EMPTY, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_validURL() {

	final String VALID_URL = "https://stackoverflow.com/";
	final String NON_VALID_URL1 = "httpASDs://stackoverflow.com/";
	final String NON_VALID_URL2 = null;
	final String NON_VALID_URL3 = "par";

	assertTrue(MyStrings.validURL(VALID_URL));
	unexpectException(() -> MyStrings.requireValidURL(VALID_URL));
	unexpectException(() -> MyStrings.requireValidURL(VALID_URL, "par"));

	assertFalse(MyStrings.validURL(NON_VALID_URL1));
	assertFalse(MyStrings.validURL(NON_VALID_URL2));
	assertFalse(MyStrings.validURL(NON_VALID_URL3));
	expectException(() -> MyStrings.requireValidURL(NON_VALID_URL1), IllegalArgumentException.class);
	expectException(() -> MyStrings.requireValidURL(NON_VALID_URL2), IllegalArgumentException.class);
	expectException(() -> MyStrings.requireValidURL(NON_VALID_URL3), IllegalArgumentException.class);
	expectException(() -> MyStrings.requireValidURL(NON_VALID_URL1, "par"), IllegalArgumentException.class);
	expectException(() -> MyStrings.requireValidURL(NON_VALID_URL2, "par"), IllegalArgumentException.class);
	expectException(() -> MyStrings.requireValidURL(NON_VALID_URL3, "par"), IllegalArgumentException.class);
    }
}
