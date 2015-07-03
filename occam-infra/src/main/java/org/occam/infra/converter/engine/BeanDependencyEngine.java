package org.occam.infra.converter.engine;

import org.occam.core.annotations.Bean;
import org.occam.infra.converter.IDataConverter;
import org.occam.infra.converter.factory.ConverterFactory;

import java.lang.reflect.Field;
import java.util.Map;

public class BeanDependencyEngine {
    private Object instance;
    private Map<String, String> values;

    public BeanDependencyEngine(Object instance, Map<String, String> values) {
        this.instance = instance;
        this.values = values;
    }

    @SuppressWarnings("rawtypes")
    public Object resolve() {
        Field[] fields = instance.getClass().getDeclaredFields();
        Object fieldInstance = null;

        for (Field field : fields) {
            if (field.isAnnotationPresent(Bean.class)) {
                Class newInstanceClass = field.getType();

                try {
                    fieldInstance = newInstanceClass.newInstance();

                    field.setAccessible(true);
                    setFieldValues(fieldInstance);
                    field.set(instance, fieldInstance);
                    field.setAccessible(false);

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return fieldInstance;
    }

    @SuppressWarnings("rawtypes")
    private void setFieldValues(Object bean) {
        Field[] fields = bean.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            String value = values.get(field.getName());
            Class clazz = field.getType();

            ConverterFactory factory = ConverterFactory.getInstance();

            IDataConverter converter = factory.getConverterFor(clazz);

            try {
                field.set(bean, converter.convert(value));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            field.setAccessible(false);
        }
    }

}
