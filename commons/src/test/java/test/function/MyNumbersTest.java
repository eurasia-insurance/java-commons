package test.function;

import static org.junit.Assert.*;
import static test.function.Exceptions.*;

import org.junit.Test;

import tech.lapsa.java.commons.function.MyNumbers;

public class MyNumbersTest {

    @Test
    public void test_int() {

	final int ZERO = 0;
	final int NON_ZERO = 1;

	assertTrue(MyNumbers.zero(ZERO));
	assertTrue(MyNumbers.nonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO, "par"));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO, "par"));

	assertFalse(MyNumbers.nonZero(ZERO));
	assertFalse(MyNumbers.zero(NON_ZERO));
	expectException(() -> MyNumbers.requireNonZero(ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_Integer() {

	final Integer NULL = null;
	final Integer ZERO = Integer.valueOf(0);
	final Integer NON_ZERO = Integer.valueOf(-1);

	assertTrue(MyNumbers.zero(NULL));
	assertTrue(MyNumbers.zero(ZERO));
	assertTrue(MyNumbers.nonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireZero(NULL));
	unexpectException(() -> MyNumbers.requireZero(NULL, "par"));
	unexpectException(() -> MyNumbers.requireZero(ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO, "par"));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO, "par"));

	assertFalse(MyNumbers.nonZero(NULL));
	assertFalse(MyNumbers.nonZero(ZERO));
	assertFalse(MyNumbers.zero(NON_ZERO));
	expectException(() -> MyNumbers.requireNonZero(NULL), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(NULL, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_double() {

	final double ZERO = 0d;
	final double NON_ZERO = .00001d;

	assertTrue(MyNumbers.zero(ZERO));
	assertTrue(MyNumbers.nonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO, "par"));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO, "par"));

	assertFalse(MyNumbers.nonZero(ZERO));
	assertFalse(MyNumbers.zero(NON_ZERO));
	expectException(() -> MyNumbers.requireZero(NON_ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_Double() {

	final Double NULL = null;
	final Double ZERO = Double.valueOf(0d);
	final Double NON_ZERO = Double.valueOf(0.02101d);

	assertTrue(MyNumbers.zero(NULL));
	assertTrue(MyNumbers.zero(ZERO));
	assertTrue(MyNumbers.nonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireZero(NULL));
	unexpectException(() -> MyNumbers.requireZero(NULL, "par"));
	unexpectException(() -> MyNumbers.requireZero(ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO, "par"));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO, "par"));

	assertFalse(MyNumbers.nonZero(NULL));
	assertFalse(MyNumbers.nonZero(ZERO));
	assertFalse(MyNumbers.zero(NON_ZERO));
	expectException(() -> MyNumbers.requireNonZero(NULL), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(NULL, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_long() {

	final long ZERO = 0L;
	final long NON_ZERO = 1L;

	assertTrue(MyNumbers.zero(ZERO));
	assertTrue(MyNumbers.nonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO, "par"));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO, "par"));

	assertFalse(MyNumbers.nonZero(ZERO));
	assertFalse(MyNumbers.zero(NON_ZERO));
	expectException(() -> MyNumbers.requireNonZero(ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_Long() {

	final Long NULL = null;
	final Long ZERO = Long.valueOf(0L);
	final Long NON_ZERO = Long.valueOf(1L);

	assertTrue(MyNumbers.zero(NULL));
	assertTrue(MyNumbers.zero(ZERO));
	assertTrue(MyNumbers.nonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireZero(NULL));
	unexpectException(() -> MyNumbers.requireZero(NULL, "par"));
	unexpectException(() -> MyNumbers.requireZero(ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO, "par"));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO, "par"));

	assertFalse(MyNumbers.nonZero(NULL));
	assertFalse(MyNumbers.nonZero(ZERO));
	assertFalse(MyNumbers.zero(NON_ZERO));
	expectException(() -> MyNumbers.requireNonZero(NULL), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(NULL, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_equals() {
	final Integer i1 = 123;
	final Integer i2 = 123;

	assertTrue(MyNumbers.numbericEquals(i1, i2));

	final Long j1 = null;
	final Long j2 = 456L;

	assertFalse(MyNumbers.numbericEquals(j1, j2));

	final Double k1 = 100d;
	final Byte k2 = 100;

	assertTrue(MyNumbers.numbericEquals(k1, k2));
    }
}
