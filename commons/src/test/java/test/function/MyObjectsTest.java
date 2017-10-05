package test.function;

import static org.junit.Assert.*;
import static test.function.Expeptions.*;

import org.junit.Test;

import com.lapsa.commons.function.MyObjects;

public class MyObjectsTest {

    @Test
    public void test_null() {

	final Object NULL = null;
	final Object NON_NULL = new Object();

	assertTrue(MyObjects.isNull(NULL));
	assertTrue(MyObjects.nonNull(NON_NULL));
	unexpectException(() -> MyObjects.requireNull(NULL));
	unexpectException(() -> MyObjects.requireNull(NULL, "par"));
	unexpectException(() -> MyObjects.requireNonNull(NON_NULL));
	unexpectException(() -> MyObjects.requireNonNull(NON_NULL, "par"));

	assertFalse(MyObjects.nonNull(NULL));
	assertFalse(MyObjects.isNull(NON_NULL));
	expectException(() -> MyObjects.requireNonNull(NULL), IllegalArgumentException.class);
	expectException(() -> MyObjects.requireNonNull(NULL, "par"), IllegalArgumentException.class);
	expectException(() -> MyObjects.requireNull(NON_NULL), IllegalArgumentException.class);
	expectException(() -> MyObjects.requireNull(NON_NULL, "par"), IllegalArgumentException.class);
    }

    @Test
    public void test_isA() {

	final Class<?> CLAZZ = CharSequence.class;

	final String IS_A = "par";
	final Integer IS_NOT_A = new Integer(1);
	final String NULL = null;

	assertTrue(MyObjects.isA(IS_A, CLAZZ));
	assertTrue(MyObjects.isNotA(IS_NOT_A, CLAZZ));
	assertTrue(MyObjects.isNotA(NULL, CLAZZ));
	unexpectException(() -> MyObjects.requireA(IS_A, CLAZZ));
	unexpectException(() -> MyObjects.requireA(IS_A, CLAZZ, "par"));
	unexpectException(() -> MyObjects.requireNotA(IS_NOT_A, CLAZZ));
	unexpectException(() -> MyObjects.requireNotA(IS_NOT_A, CLAZZ, "par"));
	unexpectException(() -> MyObjects.requireNotA(NULL, CLAZZ));
	unexpectException(() -> MyObjects.requireNotA(NULL, CLAZZ, "par"));

	assertFalse(MyObjects.isNotA(IS_A, CLAZZ));
	assertFalse(MyObjects.isA(IS_NOT_A, CLAZZ));
	assertFalse(MyObjects.isA(NULL, CLAZZ));
	expectException(() -> MyObjects.requireNotA(IS_A, CLAZZ), IllegalArgumentException.class);
	expectException(() -> MyObjects.requireNotA(IS_A, CLAZZ, "par"), IllegalArgumentException.class);
	expectException(() -> MyObjects.requireA(IS_NOT_A, CLAZZ), IllegalArgumentException.class);
	expectException(() -> MyObjects.requireA(IS_NOT_A, CLAZZ, "par"), IllegalArgumentException.class);
	expectException(() -> MyObjects.requireA(NULL, CLAZZ), IllegalArgumentException.class);
	expectException(() -> MyObjects.requireA(NULL, CLAZZ, "par"), IllegalArgumentException.class);
    }
}
