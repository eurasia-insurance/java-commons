package tech.lapsa.java.commons.naming;

import java.util.Optional;
import java.util.function.BiFunction;

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
	    final InitialContext ctx = new InitialContext();
	    res = ctx.lookup(mappedName);
	} catch (final NamingException e) {
	}
	if (res == null)
	    throw MyExceptions.illegalArgumentFormat("Argument must point to valid JNDI resource");
	return res;
    }

    public static <T> Optional<T> optionalResource(final String mappedName, final Class<T> clazz) {
	try {
	    return MyOptionals.of(requireResource(mappedName, clazz));
	} catch (final IllegalArgumentException e) {
	    return Optional.empty();
	}
    }

    public static <T> T requireResource(final String mappedName, final Class<T> clazz) {
	MyStrings.requireNonEmpty(mappedName, "mappedName");
	MyObjects.requireNonNull(clazz, "clazz");

	Object res = null;
	try {
	    final InitialContext ctx = new InitialContext();
	    res = ctx.lookup(mappedName);
	} catch (final NamingException e) {
	}
	if (res == null)
	    throw MyExceptions.illegalArgumentFormat("Argument must point to valid JNDI resource");
	return MyObjects.requireAMsg(res, clazz, "Resource has unexpected type '%1$s'", res.getClass());
    }

    private static final String DEFAULT_BEAN_SUFFIX = "Bean";

    public static <T> T lookupEJB(final String applicationName, final String module, final String beanName,
	    final Class<? extends T> interfaceClazz, final Class<T> typeClazz)
	    throws NamingException, ClassCastException {
	return lookupEJB(applicationName, module, beanName, interfaceClazz.getName(), typeClazz);
    }

    public static <T> T lookupEJB(final String applicationName, final String module,
	    final Class<? extends T> interfaceClazz, final Class<T> typeClazz)
	    throws NamingException, ClassCastException {
	final String beanName = typeClazz.getSimpleName() + DEFAULT_BEAN_SUFFIX;
	return lookupEJB(applicationName, module, beanName, interfaceClazz.getName(), typeClazz);
    }

    public static <T, X extends Throwable> T lookupEJB(final BiFunction<String, Throwable, X> creator,
	    final String applicationName, final String module,
	    final Class<? extends T> interfaceClazz, final Class<T> typeClazz)
	    throws X {
	final String beanName = typeClazz.getSimpleName() + DEFAULT_BEAN_SUFFIX;
	try {
	    return lookupEJB(applicationName, module, beanName, interfaceClazz.getName(), typeClazz);
	} catch (ClassCastException | NamingException e) {
	    throw MyExceptions.format(creator, e, "Can't instantiate ejb for %1$s because of %2$s", typeClazz.getSimpleName(), e.getMessage());
	}
    }

    public static <T> T lookupEJB(final String applicationName, final String module, final String beanName,
	    final String interfaceName, final Class<T> typeClazz) throws NamingException, ClassCastException {
	final String pathPattern = "java:global/%1$s/%2$s/%3$s!%4$s";
	final String path = String.format(pathPattern,
		applicationName, // 1
		module, // 2
		beanName, // 3
		interfaceName // 4
	);
	final InitialContext ic = new InitialContext();
	final Object object = ic.lookup(path);
	return typeClazz.cast(object);
    }
}
