package test.logging;

import org.junit.Test;

import tech.lapsa.java.commons.logging.MyLogger;

public class MyLoggingTest {

    @Test
    public void basicTest() {
	MyLogger l = MyLogger.newBuilder() //
		.withPackageNameOf(this.getClass()) //
		.withPrefix("QAZKOM") //
		.build();

	l.WARNING.log("TEST");
	l.SEVERE.log("Paramter id = '%1$s'", 123);
    }

}
