package test.logging;

import org.junit.Test;

import tech.lapsa.java.commons.logging.MyLogger;

public class MyLoggerTest {

    @Test
    public void basicTest() {
	MyLogger l = MyLogger.newBuilder() //
		.withPackageNameOf(this.getClass()) //
		.withPrefix("QAZKOM") //
		.withCAPS() //
		.clearHandlers() //
		.withPrefix("ZXC")
		.build();

	l.WARNING.log("TEST");
	l.SEVERE.log("Paramter id = '%1$s'", 123);
    }

}
