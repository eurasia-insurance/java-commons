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
	final int POSITIVE = 1;
	final int NON_POSITIVE = -POSITIVE;

	assertTrue(MyNumbers.zero(ZERO));
	assertTrue(MyNumbers.nonZero(NON_ZERO));
	assertTrue(MyNumbers.positive(POSITIVE));
	unexpectException(() -> MyNumbers.requireZero(ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO, "par"));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO, "par"));
	unexpectException(() -> MyNumbers.requirePositive(POSITIVE));
	unexpectException(() -> MyNumbers.requirePositive(POSITIVE, "par"));

	assertFalse(MyNumbers.nonZero(ZERO));
	assertFalse(MyNumbers.zero(NON_ZERO));
	assertFalse(MyNumbers.positive(NON_POSITIVE));
	expectException(() -> MyNumbers.requireNonZero(ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requirePositive(NON_POSITIVE), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requirePositive(NON_POSITIVE, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_double() {

	final double ZERO = 0d;
	final double NON_ZERO = .00001d;
	final double POSITIVE = .001d;
	final double NON_POSITIVE = -POSITIVE;

	assertTrue(MyNumbers.zero(ZERO));
	assertTrue(MyNumbers.nonZero(NON_ZERO));
	assertTrue(MyNumbers.positive(POSITIVE));
	unexpectException(() -> MyNumbers.requireZero(ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO, "par"));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO, "par"));
	unexpectException(() -> MyNumbers.requirePositive(POSITIVE));
	unexpectException(() -> MyNumbers.requirePositive(POSITIVE, "par"));

	assertFalse(MyNumbers.nonZero(ZERO));
	assertFalse(MyNumbers.zero(NON_ZERO));
	assertFalse(MyNumbers.positive(NON_POSITIVE));
	expectException(() -> MyNumbers.requireZero(NON_ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requirePositive(NON_POSITIVE), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requirePositive(NON_POSITIVE, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_long() {

	final long ZERO = 0L;
	final long NON_ZERO = 1L;
	final long POSITIVE = 1L;
	final long NON_POSITIVE = -POSITIVE;

	assertTrue(MyNumbers.zero(ZERO));
	assertTrue(MyNumbers.nonZero(NON_ZERO));
	assertTrue(MyNumbers.positive(POSITIVE));
	unexpectException(() -> MyNumbers.requireZero(ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO, "par"));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO, "par"));
	unexpectException(() -> MyNumbers.requirePositive(POSITIVE));
	unexpectException(() -> MyNumbers.requirePositive(POSITIVE, "par"));

	assertFalse(MyNumbers.nonZero(ZERO));
	assertFalse(MyNumbers.zero(NON_ZERO));
	assertFalse(MyNumbers.positive(NON_POSITIVE));
	expectException(() -> MyNumbers.requireNonZero(ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requirePositive(NON_POSITIVE), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requirePositive(NON_POSITIVE, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_Number() {

	final Number NULL = null;
	final Number ZERO = Long.valueOf(0L);
	final Number NON_ZERO = Long.valueOf(1L);
	final Number POSITIVE = Double.valueOf(123123d);
	final Number NON_POSITIVE = -POSITIVE.intValue();

	assertTrue(MyNumbers.zero(NULL));
	assertTrue(MyNumbers.zero(ZERO));
	assertTrue(MyNumbers.nonZero(NON_ZERO));
	assertTrue(MyNumbers.positive(POSITIVE));
	unexpectException(() -> MyNumbers.requireZero(NULL));
	unexpectException(() -> MyNumbers.requireZero(NULL, "par"));
	unexpectException(() -> MyNumbers.requireZero(ZERO));
	unexpectException(() -> MyNumbers.requireZero(ZERO, "par"));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO));
	unexpectException(() -> MyNumbers.requireNonZero(NON_ZERO, "par"));
	unexpectException(() -> MyNumbers.requirePositive(POSITIVE));
	unexpectException(() -> MyNumbers.requirePositive(POSITIVE, "par"));

	assertFalse(MyNumbers.nonZero(NULL));
	assertFalse(MyNumbers.nonZero(ZERO));
	assertFalse(MyNumbers.zero(NON_ZERO));
	assertFalse(MyNumbers.positive(NON_POSITIVE));
	expectException(() -> MyNumbers.requireNonZero(NULL), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(NULL, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireNonZero(ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requireZero(NON_ZERO, "par"), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requirePositive(NON_POSITIVE), IllegalArgumentException.class);
	expectException(() -> MyNumbers.requirePositive(NON_POSITIVE, "par"), IllegalArgumentException.class);
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
