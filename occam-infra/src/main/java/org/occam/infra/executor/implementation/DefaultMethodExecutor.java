package org.occam.infra.executor.implementation;

import org.occam.infra.executor.IExecutionStrategy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DefaultMethodExecutor implements IExecutionStrategy {

    public void executeMethod(Method m, Object instance) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        m.invoke(instance);
    }

    public Object getReturn() {
        return null;
    }

}
