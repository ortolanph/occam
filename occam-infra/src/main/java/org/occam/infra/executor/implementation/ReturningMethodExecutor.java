package org.occam.infra.executor.implementation;

import org.occam.infra.executor.IExecutionStrategy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReturningMethodExecutor implements IExecutionStrategy {
    private Object methodReturn;

    public void executeMethod(Method m, Object instance) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        methodReturn = m.invoke(instance);
    }

    public Object getReturn() {
        return methodReturn;
    }

}
