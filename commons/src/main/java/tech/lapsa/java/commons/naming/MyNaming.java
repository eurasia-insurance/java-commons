package tech.lapsa.java.commons.naming;

import java.util.Optional;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tech.lapsa.java.commons.function.MyExceptions;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;

public final class MyNaming {

    private MyNaming() {
    }

    public static Object requireResource(final String mappedName) {
	Object res = null;
	try {
	    InitialContext ctx = new InitialContext();
	    res = ctx.lookup(mappedName);
	} catch (NamingException e) {
	}
	if (res == null)
	    throw MyExceptions.illegalArgumentFormat("Argument must point to valid JNDI resource");
	return res;
    }

    public static <T> Optional<T> optionalResource(final String mappedName, Class<T> clazz) {
	try {
	    return MyOptionals.of(requireResource(mappedName, clazz));
	} catch (IllegalArgumentException e) {
	    return Optional.empty();
	}
    }

    public static <T> T requireResource(final String mappedName, Class<T> clazz) {
	MyStrings.requireNonEmpty(mappedName, "mappedName");
	MyObjects.requireNonNull(clazz, "clazz");

	Object res = null;
	try {
	    InitialContext ctx = new InitialContext();
	    res = ctx.lookup(mappedName);
	} catch (NamingException e) {
	}
	if (res == null)
	    throw MyExceptions.illegalArgumentFormat("Argument must point to valid JNDI resource");
	return MyObjects.requireAMsg(res, clazz, "Resource has unexpected type '%1$s'", res.getClass());
    }

}
