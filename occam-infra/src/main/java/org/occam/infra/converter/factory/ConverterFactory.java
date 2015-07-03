package org.occam.infra.converter.factory;

import org.occam.infra.converter.IDataConverter;
import org.occam.infra.converter.ITypeConverter;
import org.occam.infra.converter.implementation.*;

public class ConverterFactory {
    private static final ConverterFactory INSTANCE = new ConverterFactory();
    private ITypeConverter converter;

    private ConverterFactory() {
        ConverterCreator creator = new ConverterCreator(new ByteConverter());

        try {
            converter = creator.addNextTypeConverter(new ShortConverter())
                    .addNextTypeConverter(new IntegerConverter())
                    .addNextTypeConverter(new LongConverter())
                    .addNextTypeConverter(new FloatConverter())
                    .addNextTypeConverter(new DoubleConverter())
                    .addNextTypeConverter(new BooleanConverter())
                    .addNextTypeConverter(new CharacterConverter())
                    .addNextTypeConverter(new DateConverter())
                    .addNextTypeConverter(new IdentityConverter())
                    .getConverter();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConverterFactory getInstance() {
        return INSTANCE;
    }

    @SuppressWarnings("rawtypes")
    public IDataConverter<?> getConverterFor(Class clazz) {
        return converter.getConverter(clazz);
    }
}
