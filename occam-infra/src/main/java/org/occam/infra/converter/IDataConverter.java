package org.occam.infra.converter;

public interface IDataConverter<T> {
    T convert(String data);
}
