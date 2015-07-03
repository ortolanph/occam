package org.occam.infra.converter.implementation;

import org.occam.infra.converter.IDataConverter;
import org.occam.infra.converter.ITypeConverter;

public class BooleanConverter implements ITypeConverter {
    private ITypeConverter nextTypeConverter;

    @SuppressWarnings("rawtypes")
    public IDataConverter<?> getConverter(Class clazz) {
        if (clazz == boolean.class || clazz == Boolean.class) {
            return new IDataConverter<Boolean>() {

                public Boolean convert(String data) {
                    return Boolean.valueOf(data);
                }

            };
        }

        return nextTypeConverter.getConverter(clazz);
    }

    public void setNextTypeConverter(ITypeConverter nextTypeConverter) {
        this.nextTypeConverter = nextTypeConverter;
    }

}
