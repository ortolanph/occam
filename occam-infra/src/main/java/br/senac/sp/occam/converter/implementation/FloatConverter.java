package br.senac.sp.occam.converter.implementation;

import br.senac.sp.occam.converter.IDataConverter;
import br.senac.sp.occam.converter.ITypeConverter;

public class FloatConverter implements ITypeConverter {
	private ITypeConverter nextTypeConverter;

	@SuppressWarnings("rawtypes")
	public IDataConverter<?> getConverter(Class clazz) {
		if(clazz == float.class || clazz == Float.class) {
			return new IDataConverter<Float>() {

				public Float convert(String data) {
					return Float.valueOf(data);
				}
				
			};
		}
		
		return nextTypeConverter.getConverter(clazz);
	}

	public void setNextTypeConverter(ITypeConverter nextTypeConverter) {
		this.nextTypeConverter = nextTypeConverter;
	}

}
