package org.occam.infra.converter.implementation;

import org.occam.infra.converter.IDataConverter;
import org.occam.infra.converter.ITypeConverter;

public class FloatConverter implements ITypeConverter {
    private ITypeConverter nextTypeConverter;

    @SuppressWarnings("rawtypes")
    public IDataConverter<?> getConverter(Class clazz) {
        if (clazz == float.class || clazz == Float.class) {
            return new IDataConverter<Float>() {

                public Float convert(String data) {
                    return Float.valueOf(data);
                }

            };
        }

        return nextTypeConverter.getConverter(clazz);
    }

    public void setNextTypeConverter(ITypeConverter nextTypeConverter) {
        this.nextTypeConverter = nextTypeConverter;
    }

}
