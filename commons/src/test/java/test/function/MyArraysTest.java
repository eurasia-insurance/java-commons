package test.function;

import static org.junit.Assert.*;
import static test.function.MyExceptionsTest.*;

import org.junit.Test;

import com.lapsa.commons.function.MyArrays;

public class MyArraysTest {

    @Test
    public void test_array_Object() {

	final String[] NULL = null;
	final String[] EMPTY = new String[0];
	final String[] NON_EMPTY = new String[1];

	final String[] NULL_ELEMENTS = new String[] { null, null, null };
	final String[] NON_NULL_ELEMENTS = new String[] { "a", "b", "c" };

	assertTrue(MyArrays.empty(NULL));
	assertTrue(MyArrays.empty(EMPTY));
	assertTrue(MyArrays.nonEmpty(NON_EMPTY));
	assertTrue(MyArrays.nullElements(NULL_ELEMENTS));
	assertTrue(MyArrays.nonNullElements(NON_NULL_ELEMENTS));
	unexpectException(() -> MyArrays.requireEmpty(NULL));
	unexpectException(() -> MyArrays.requireEmpty(NULL, "par"));
	unexpectException(() -> MyArrays.requireEmpty(EMPTY));
	unexpectException(() -> MyArrays.requireEmpty(EMPTY, "par"));
	unexpectException(() -> MyArrays.requireNonEmpty(NON_EMPTY));
	unexpectException(() -> MyArrays.requireNonEmpty(NON_EMPTY, "par"));
	unexpectException(() -> MyArrays.requireNullElements(NULL_ELEMENTS));
	unexpectException(() -> MyArrays.requireNullElements(NULL_ELEMENTS, "par"));
	unexpectException(() -> MyArrays.requireNonNullElements(NON_NULL_ELEMENTS));
	unexpectException(() -> MyArrays.requireNonNullElements(NON_NULL_ELEMENTS, "par"));

	assertFalse(MyArrays.nonEmpty(NULL));
	assertFalse(MyArrays.nonEmpty(EMPTY));
	assertFalse(MyArrays.empty(NON_EMPTY));
	assertFalse(MyArrays.nullElements(NON_NULL_ELEMENTS));
	assertFalse(MyArrays.nonNullElements(NULL_ELEMENTS));
	expectException(() -> MyArrays.requireNonEmpty(NULL), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonEmpty(NULL, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonEmpty(EMPTY), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonEmpty(EMPTY, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireEmpty(NON_EMPTY), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireEmpty(NON_EMPTY, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonNullElements(NULL_ELEMENTS), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonNullElements(NULL_ELEMENTS, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNullElements(NON_NULL_ELEMENTS), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNullElements(NON_NULL_ELEMENTS, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_array_int() {

	final int[] NULL = null;
	final int[] EMPTY = new int[0];
	final int[] NON_EMPTY = new int[1];

	final int[] ZERO_ELEMENTS = new int[] { 0, 0, 0 };
	final int[] NON_ZERO_ELEMENTS = new int[] { 1, 2, 3 };

	assertTrue(MyArrays.empty(NULL));
	assertTrue(MyArrays.empty(EMPTY));
	assertTrue(MyArrays.nonEmpty(NON_EMPTY));
	assertTrue(MyArrays.zeroElements(ZERO_ELEMENTS));
	assertTrue(MyArrays.nonZeroElements(NON_ZERO_ELEMENTS));
	unexpectException(() -> MyArrays.requireEmpty(NULL));
	unexpectException(() -> MyArrays.requireEmpty(NULL, "par"));
	unexpectException(() -> MyArrays.requireEmpty(EMPTY));
	unexpectException(() -> MyArrays.requireEmpty(EMPTY, "par"));
	unexpectException(() -> MyArrays.requireNonEmpty(NON_EMPTY));
	unexpectException(() -> MyArrays.requireNonEmpty(NON_EMPTY, "par"));
	unexpectException(() -> MyArrays.requireZeroElements(ZERO_ELEMENTS));
	unexpectException(() -> MyArrays.requireZeroElements(ZERO_ELEMENTS, "par"));
	unexpectException(() -> MyArrays.requireNonZeroElements(NON_ZERO_ELEMENTS));
	unexpectException(() -> MyArrays.requireNonZeroElements(NON_ZERO_ELEMENTS, "par"));

	assertFalse(MyArrays.nonEmpty(NULL));
	assertFalse(MyArrays.nonEmpty(EMPTY));
	assertFalse(MyArrays.empty(NON_EMPTY));
	assertFalse(MyArrays.zeroElements(NON_ZERO_ELEMENTS));
	assertFalse(MyArrays.nonZeroElements(ZERO_ELEMENTS));
	expectException(() -> MyArrays.requireNonEmpty(NULL), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonEmpty(NULL, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonEmpty(EMPTY), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonEmpty(EMPTY, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireEmpty(NON_EMPTY), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireEmpty(NON_EMPTY, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonZeroElements(ZERO_ELEMENTS), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonZeroElements(ZERO_ELEMENTS, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireZeroElements(NON_ZERO_ELEMENTS), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireZeroElements(NON_ZERO_ELEMENTS, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_array_double() {

	final double[] NULL = null;
	final double[] EMPTY = new double[0];
	final double[] NON_EMPTY = new double[1];

	final double[] ZERO_ELEMENTS = new double[] { 0, 0, 0 };
	final double[] NON_ZERO_ELEMENTS = new double[] { 1, 2, 3 };

	assertTrue(MyArrays.empty(NULL));
	assertTrue(MyArrays.empty(EMPTY));
	assertTrue(MyArrays.nonEmpty(NON_EMPTY));
	assertTrue(MyArrays.zeroElements(ZERO_ELEMENTS));
	assertTrue(MyArrays.nonZeroElements(NON_ZERO_ELEMENTS));
	unexpectException(() -> MyArrays.requireEmpty(NULL));
	unexpectException(() -> MyArrays.requireEmpty(NULL, "par"));
	unexpectException(() -> MyArrays.requireEmpty(EMPTY));
	unexpectException(() -> MyArrays.requireEmpty(EMPTY, "par"));
	unexpectException(() -> MyArrays.requireNonEmpty(NON_EMPTY));
	unexpectException(() -> MyArrays.requireNonEmpty(NON_EMPTY, "par"));
	unexpectException(() -> MyArrays.requireZeroElements(ZERO_ELEMENTS));
	unexpectException(() -> MyArrays.requireZeroElements(ZERO_ELEMENTS, "par"));
	unexpectException(() -> MyArrays.requireNonZeroElements(NON_ZERO_ELEMENTS));
	unexpectException(() -> MyArrays.requireNonZeroElements(NON_ZERO_ELEMENTS, "par"));

	assertFalse(MyArrays.nonEmpty(NULL));
	assertFalse(MyArrays.nonEmpty(EMPTY));
	assertFalse(MyArrays.empty(NON_EMPTY));
	assertFalse(MyArrays.zeroElements(NON_ZERO_ELEMENTS));
	assertFalse(MyArrays.nonZeroElements(ZERO_ELEMENTS));
	expectException(() -> MyArrays.requireEmpty(NON_EMPTY), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireEmpty(NON_EMPTY, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonEmpty(EMPTY), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonEmpty(EMPTY, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonZeroElements(ZERO_ELEMENTS), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonZeroElements(ZERO_ELEMENTS, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireZeroElements(NON_ZERO_ELEMENTS), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireZeroElements(NON_ZERO_ELEMENTS, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_array_long() {

	final long[] NULL = null;
	final long[] EMPTY = new long[0];
	final long[] NON_EMPTY = new long[1];

	final long[] ZERO_ELEMENTS = new long[] { 0, 0, 0 };
	final long[] NON_ZERO_ELEMENTS = new long[] { 1, 2, 3 };

	assertTrue(MyArrays.empty(NULL));
	assertTrue(MyArrays.empty(EMPTY));
	assertTrue(MyArrays.nonEmpty(NON_EMPTY));
	assertTrue(MyArrays.zeroElements(ZERO_ELEMENTS));
	assertTrue(MyArrays.nonZeroElements(NON_ZERO_ELEMENTS));
	unexpectException(() -> MyArrays.requireEmpty(NULL));
	unexpectException(() -> MyArrays.requireEmpty(NULL, "par"));
	unexpectException(() -> MyArrays.requireEmpty(EMPTY));
	unexpectException(() -> MyArrays.requireEmpty(EMPTY, "par"));
	unexpectException(() -> MyArrays.requireNonEmpty(NON_EMPTY));
	unexpectException(() -> MyArrays.requireNonEmpty(NON_EMPTY, "par"));
	unexpectException(() -> MyArrays.requireZeroElements(ZERO_ELEMENTS));
	unexpectException(() -> MyArrays.requireZeroElements(ZERO_ELEMENTS, "par"));
	unexpectException(() -> MyArrays.requireNonZeroElements(NON_ZERO_ELEMENTS));
	unexpectException(() -> MyArrays.requireNonZeroElements(NON_ZERO_ELEMENTS, "par"));

	assertFalse(MyArrays.nonEmpty(NULL));
	assertFalse(MyArrays.nonEmpty(EMPTY));
	assertFalse(MyArrays.empty(NON_EMPTY));
	assertFalse(MyArrays.zeroElements(NON_ZERO_ELEMENTS));
	assertFalse(MyArrays.nonZeroElements(ZERO_ELEMENTS));
	expectException(() -> MyArrays.requireNonEmpty(NULL), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonEmpty(NULL, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonEmpty(EMPTY), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonEmpty(EMPTY, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireEmpty(NON_EMPTY), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireEmpty(NON_EMPTY, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonZeroElements(ZERO_ELEMENTS), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireNonZeroElements(ZERO_ELEMENTS, "par"), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireZeroElements(NON_ZERO_ELEMENTS), IllegalArgumentException.class);
	expectException(() -> MyArrays.requireZeroElements(NON_ZERO_ELEMENTS, "par"), IllegalArgumentException.class);
    }
}
