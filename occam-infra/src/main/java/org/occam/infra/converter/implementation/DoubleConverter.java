package org.occam.infra.converter.implementation;

import org.occam.infra.converter.IDataConverter;
import org.occam.infra.converter.ITypeConverter;

public class DoubleConverter implements ITypeConverter {
    private ITypeConverter nextTypeConverter;


    @SuppressWarnings("rawtypes")
    public IDataConverter<?> getConverter(Class clazz) {
        if (clazz == double.class || clazz == Double.class) {
            return new IDataConverter<Double>() {

                public Double convert(String data) {
                    return Double.valueOf(data);
                }

            };
        }

        return nextTypeConverter.getConverter(clazz);
    }

    public void setNextTypeConverter(ITypeConverter nextTypeConverter) {
        this.nextTypeConverter = nextTypeConverter;
    }

}
