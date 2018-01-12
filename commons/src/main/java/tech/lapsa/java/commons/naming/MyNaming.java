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

    // Portable JNDI names for EJB PolicyDriverFacadeBean: [
    // java:global/insurance-facade-ear/insurance-facade/PolicyDriverFacadeBean!tech.lapsa.insurance.facade.PolicyDriverFacade$PolicyDriverFacadeLocal
    // java:global/insurance-facade-ear/insurance-facade/PolicyDriverFacadeBean!tech.lapsa.insurance.facade.PolicyDriverFacade$PolicyDriverFacadeRemote
    // ]]]

    public static <T, X extends Exception> T lookupEJB(final BiFunction<String, Exception, X> creator,
	    final String applicationName,
	    final String moduleName,
	    final String beanName,
	    final Class<T> interfaceClazz) throws X {
	return lookupEJB(creator, applicationName, moduleName, beanName, interfaceClazz.getName(), interfaceClazz);
    }

    public static <T> T lookupEJB(final String applicationName,
	    final String moduleName,
	    final String beanName,
	    final Class<T> interfaceClazz) throws NamingException, ClassCastException {
	return lookupEJB(applicationName, moduleName, beanName, interfaceClazz.getName(), interfaceClazz);
    }

    // mains

    public static <T, X extends Exception> T lookupEJB(final BiFunction<String, Exception, X> creator,
	    final String applicationName,
	    final String moduleName,
	    final String beanName,
	    final String qualifier,
	    final Class<T> typeClazz) throws X {
	try {
	    return lookupEJB(applicationName, moduleName, beanName, qualifier, typeClazz);
	} catch (NamingException | ClassCastException e) {
	    throw MyExceptions.format(creator, e, "Exception attemping to get ejb-ref for %1$s", typeClazz.getName());
	}
    }

    public static <T> T lookupEJB(final String applicationName,
	    final String moduleName,
	    final String beanName,
	    final String qualifier,
	    final Class<T> typeClazz) throws NamingException, ClassCastException {
	final String pathPattern = "java:global/%1$s/%2$s/%3$s!%4$s";
	final String path = String.format(pathPattern,
		applicationName, // 1
		moduleName, // 2
		beanName, // 3
		qualifier // 4
	);
	final InitialContext ic = new InitialContext();
	final Object object = ic.lookup(path);
	return typeClazz.cast(object);
    }
}
