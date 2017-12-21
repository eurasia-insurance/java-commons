package test.logging;

import org.junit.Test;

import tech.lapsa.java.commons.logging.MyLogger;

public class MyLoggerTest {

    @Test
    public void basicTest() {
	final MyLogger l = MyLogger.newBuilder() //
		.withPackageNameOf(this.getClass()) //
		.addPrefix("QAZKOM") //
		.addWithCAPS() //
		.clearHandler() //
		.addPrefix("ZXC")
		.build();

	l.WARNING.log("TEST");
	l.SEVERE.log("Paramter id = '%1$s'", 123);
    }

}
