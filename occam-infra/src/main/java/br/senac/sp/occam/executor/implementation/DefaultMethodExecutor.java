package br.senac.sp.occam.executor.implementation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.senac.sp.occam.executor.IExecutionStrategy;

public class DefaultMethodExecutor implements IExecutionStrategy {

	public void executeMethod(Method m, Object instance) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		m.invoke(instance);
	}

	public Object getReturn() {
		return null;
	}
	
}
