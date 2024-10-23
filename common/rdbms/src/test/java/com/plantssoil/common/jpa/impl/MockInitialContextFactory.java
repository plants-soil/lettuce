package com.plantssoil.common.jpa.impl;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

public class MockInitialContextFactory implements InitialContextFactory {

	private static final ThreadLocal<Context> currentContext = new ThreadLocal<Context>();

	public static void setCurrentContext(Context context) {
		currentContext.set(context);
	}

	public static void clearCurrentContext() {
		currentContext.remove();
	}

	@Override
	public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
		return currentContext.get();
	}

}
