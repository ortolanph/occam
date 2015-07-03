package org.occam.infra.converter.implementation;

import org.occam.infra.converter.IDataConverter;
import org.occam.infra.converter.ITypeConverter;

public class CharacterConverter implements ITypeConverter {
    private ITypeConverter nextTypeConverter;

    @SuppressWarnings("rawtypes")
    public IDataConverter<?> getConverter(Class clazz) {
        if (clazz == char.class || clazz == Character.class) {
            return new IDataConverter<Character>() {

                public Character convert(String data) {
                    return Character.valueOf(data.charAt(0));
                }

            };
        }

        return nextTypeConverter.getConverter(clazz);
    }

    public void setNextTypeConverter(ITypeConverter nextTypeConverter) {
        this.nextTypeConverter = nextTypeConverter;
    }

}
