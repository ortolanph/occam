package org.occam.infra.executor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface IExecutionStrategy {
    void executeMethod(Method m, Object instance) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException;

    Object getReturn();
}
