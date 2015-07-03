package org.occam.infra;

import org.occam.core.exceptions.InvalidOperationException;
import org.occam.core.exceptions.NoNavigationFoundException;
import org.occam.infra.converter.engine.BeanDependencyEngine;
import org.occam.infra.executor.beans.ResultBean;
import org.occam.infra.executor.engine.ExecutorEngine;
import org.occam.infra.locator.OccamServiceLocator;

import java.net.URL;
import java.util.Map;

public class OccamFacade {
    private OccamServiceLocator locator;

    public OccamFacade() {
        locator = OccamServiceLocator.getInstance();
    }

    public Object getOperation(URL operationFile, String operationName) throws InvalidOperationException {
        return locator.getOperationInstance(operationFile, operationName);
    }

    public Object resolveBeans(Object instance, Map<String, String> values) {
        BeanDependencyEngine beanEngine = new BeanDependencyEngine(instance, values);

        return beanEngine.resolve();
    }

    public ResultBean runMethod(Object instance, String methodName) throws NoNavigationFoundException {
        ExecutorEngine engine = new ExecutorEngine(instance, methodName);

        String urlToGo = engine.execute();
        Object methodReturn = engine.getReturn();

        ResultBean result = new ResultBean(urlToGo, methodReturn);

        return result;
    }
}
