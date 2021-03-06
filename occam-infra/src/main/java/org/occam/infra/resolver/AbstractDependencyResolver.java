package org.occam.infra.resolver;

public abstract class AbstractDependencyResolver {
    private Object instance;

    public AbstractDependencyResolver(Object instance) {
        this.instance = instance;
    }

    public Object getInstance() {
        return this.instance;
    }

    public abstract Object resolve();
}
