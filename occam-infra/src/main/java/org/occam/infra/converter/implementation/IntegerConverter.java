package org.occam.infra.converter.implementation;

import org.occam.infra.converter.IDataConverter;
import org.occam.infra.converter.ITypeConverter;

public class IntegerConverter implements ITypeConverter {
    private ITypeConverter nextTypeConverter;

    @SuppressWarnings("rawtypes")
    public IDataConverter<?> getConverter(Class clazz) {
        if (clazz == int.class || clazz == Integer.class) {
            return new IDataConverter<Integer>() {

                public Integer convert(String data) {
                    return Integer.valueOf(data);
                }

            };
        }

        return nextTypeConverter.getConverter(clazz);
    }

    public void setNextTypeConverter(ITypeConverter nextTypeConverter) {
        this.nextTypeConverter = nextTypeConverter;
    }

}
