package org.occam.infra.locator;

import org.occam.core.annotations.Operation;
import org.occam.core.enums.InstanceStrategy;
import org.occam.core.exceptions.InvalidOperationException;
import org.occam.infra.parser.IOccamConfiguration;
import org.occam.infra.parser.implementation.ConfigurationProxy;
import org.occam.infra.resolver.AbstractDependencyResolver;
import org.occam.infra.resolver.implementation.DependencyResolver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class OccamServiceLocator {
    private static final OccamServiceLocator INSTANCE = new OccamServiceLocator();
    private AbstractDependencyResolver dependencyResolver;

    private Map<String, Object> cache;

    private OccamServiceLocator() {
        cache = new HashMap<String, Object>();
    }

    public static OccamServiceLocator getInstance() {
        return INSTANCE;
    }

    public void setDependencyResolver(AbstractDependencyResolver dependencyResolver) {
        this.dependencyResolver = dependencyResolver;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public Object getOperationInstance(URL operationFile, String operationName) throws InvalidOperationException {
        IOccamConfiguration config = new ConfigurationProxy(operationFile);

        Object instance = null;

        // configuration parser obt�m a classe
        String className = config.getOperationClass(operationName);

        // obter a estrat�gia de inst�ncia
        try {
            Class operationClass = Class.forName(className);

            // verificar qual a estrat�gia de inst�ncia
            if (operationClass.isAnnotationPresent(Operation.class)) {
                Operation op = (Operation) operationClass.getAnnotation(Operation.class);

                if (op.value() == InstanceStrategy.PROTOTYPE) {
                    // se for PROTOTYPE retornar instancia
                    instance = operationClass.newInstance();
                } else {
                    // se for SINGLETON, procurar no cache
                    instance = cache.get(operationName);

                    if (instance == null) {
                        // se n�o tiver, cria uma nova instancia e cadastra no cache
                        instance = operationClass.newInstance();

                        cache.put(operationName, instance);
                    }
                }
            } else {
                throw new InvalidOperationException(operationName);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        dependencyResolver = new DependencyResolver(instance);
        instance = dependencyResolver.resolve();

        return instance;
    }
}
