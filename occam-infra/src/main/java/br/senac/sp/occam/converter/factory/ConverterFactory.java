package br.senac.sp.occam.converter.factory;

import br.senac.sp.occam.converter.IDataConverter;
import br.senac.sp.occam.converter.ITypeConverter;
import br.senac.sp.occam.converter.implementation.BooleanConverter;
import br.senac.sp.occam.converter.implementation.ByteConverter;
import br.senac.sp.occam.converter.implementation.CharacterConverter;
import br.senac.sp.occam.converter.implementation.DateConverter;
import br.senac.sp.occam.converter.implementation.DoubleConverter;
import br.senac.sp.occam.converter.implementation.FloatConverter;
import br.senac.sp.occam.converter.implementation.IdentityConverter;
import br.senac.sp.occam.converter.implementation.IntegerConverter;
import br.senac.sp.occam.converter.implementation.LongConverter;
import br.senac.sp.occam.converter.implementation.ShortConverter;

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
