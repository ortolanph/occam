package org.occam.infra.converter;

public interface ITypeConverter {
    @SuppressWarnings("rawtypes")
    IDataConverter<?> getConverter(Class clazz);

    void setNextTypeConverter(ITypeConverter selector) throws Exception;
}
