package br.senac.sp.occam.converter.implementation;

import br.senac.sp.occam.converter.IDataConverter;
import br.senac.sp.occam.converter.ITypeConverter;

public class ByteConverter implements ITypeConverter {
	private ITypeConverter nextTypeConverter;
	
	@SuppressWarnings("rawtypes")
	public IDataConverter<?> getConverter(Class clazz) {
		if(clazz == byte.class || clazz == Byte.class) {
			return new IDataConverter<Byte>() {
				
				public Byte convert(String data) {
					return Byte.valueOf(data);
				}
				
			};
		}

		return nextTypeConverter.getConverter(clazz);
	}

	public void setNextTypeConverter(ITypeConverter nextTypeConverter) {
		this.nextTypeConverter = nextTypeConverter;
	}

}
