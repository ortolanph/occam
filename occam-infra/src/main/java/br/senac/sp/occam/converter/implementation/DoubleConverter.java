package br.senac.sp.occam.converter.implementation;

import br.senac.sp.occam.converter.IDataConverter;
import br.senac.sp.occam.converter.ITypeConverter;

public class DoubleConverter implements ITypeConverter {
	private ITypeConverter nextTypeConverter;
	

	@SuppressWarnings("rawtypes")
	public IDataConverter<?> getConverter(Class clazz) {
		if(clazz == double.class || clazz == Double.class) {
			return new IDataConverter<Double>() {

				public Double convert(String data) {
					return Double.valueOf(data);
				}
				
			};
		}
		
		return nextTypeConverter.getConverter(clazz);
	}

	public void setNextTypeConverter(ITypeConverter nextTypeConverter) {
		this.nextTypeConverter = nextTypeConverter;
	}

}
