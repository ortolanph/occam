package org.occam.infra.converter.implementation;

import org.occam.infra.converter.IDataConverter;
import org.occam.infra.converter.ITypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements ITypeConverter {
    private ITypeConverter nextTypeConverter;

    @SuppressWarnings("rawtypes")
    public IDataConverter<?> getConverter(Class clazz) {
        if (clazz == Date.class) {
            new IDataConverter<Date>() {
                private final SimpleDateFormat defaultDateFormat = new SimpleDateFormat("dd/MM/yyyy");

                public Date convert(String data) {
                    Date myDate = new Date();

                    try {
                        myDate = defaultDateFormat.parse(data);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    return myDate;
                }

            };
        }

        return nextTypeConverter.getConverter(clazz);
    }

    public void setNextTypeConverter(ITypeConverter nextTypeConverter) {
        this.nextTypeConverter = nextTypeConverter;
    }

}
