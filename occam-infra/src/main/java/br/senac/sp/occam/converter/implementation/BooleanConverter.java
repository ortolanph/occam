package br.senac.sp.occam.converter.implementation;

import br.senac.sp.occam.converter.IDataConverter;
import br.senac.sp.occam.converter.ITypeConverter;

public class BooleanConverter implements ITypeConverter {
	private ITypeConverter nextTypeConverter;

	@SuppressWarnings("rawtypes")
	public IDataConverter<?> getConverter(Class clazz) {
		if(clazz == boolean.class || clazz == Boolean.class) {
			return new IDataConverter<Boolean>() {

				public Boolean convert(String data) {
					return Boolean.valueOf(data);
				}
				
			};
		}
		
		return nextTypeConverter.getConverter(clazz);
	}

	public void setNextTypeConverter(ITypeConverter nextTypeConverter) {
		this.nextTypeConverter = nextTypeConverter;
	}

}
