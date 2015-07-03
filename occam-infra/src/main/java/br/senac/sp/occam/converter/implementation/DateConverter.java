package br.senac.sp.occam.converter.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.senac.sp.occam.converter.IDataConverter;
import br.senac.sp.occam.converter.ITypeConverter;

public class DateConverter implements ITypeConverter {
	private ITypeConverter nextTypeConverter;

	@SuppressWarnings("rawtypes")
	public IDataConverter<?> getConverter(Class clazz) {
		if(clazz == Date.class) {
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
