package org.occam.infra.converter.factory;

import org.occam.infra.converter.ITypeConverter;

public class ConverterCreator {
    private ITypeConverter root;
    private ITypeConverter current;

    public ConverterCreator(ITypeConverter converter) {
        this.root = converter;
        this.current = converter;
    }

    public ITypeConverter getConverter() {
        return root;
    }

    public ConverterCreator addNextTypeConverter(ITypeConverter converter) throws Exception {
        current.setNextTypeConverter(converter);
        current = converter;

        return this;
    }

}
