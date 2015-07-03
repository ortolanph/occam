package org.occam.infra.resolver.implementation;

import org.occam.infra.resolver.AbstractDependencyResolver;

import javax.inject.Inject;
import java.lang.reflect.Field;

public class DependencyResolver extends AbstractDependencyResolver {
    private AbstractDependencyResolver resolver;

    public DependencyResolver(Object instance) {
        super(instance);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object resolve() {
        System.out.println(String.format("Resolvendo depend�ncias"));
        Field[] fields = getInstance().getClass().getDeclaredFields();
        Object newInstance = getInstance();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                System.out.println(String.format("Loop principal"));
                Class newInstanceClass = field.getType();
                Object fieldInstance = null;

                try {
                    System.out.println(String.format("Atribuindo instancia ao campo"));
                    fieldInstance = newInstanceClass.newInstance();

                    field.setAccessible(true);
                    field.set(getInstance(), fieldInstance);
                    field.setAccessible(false);

                    resolver = new DependencyResolver(fieldInstance);
                    fieldInstance = resolver.resolve();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(String.format("Depend�ncias resolvidas"));
        return newInstance;
    }

}
