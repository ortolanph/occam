package br.senac.sp.occam.converter.implementation;

import br.senac.sp.occam.converter.IDataConverter;
import br.senac.sp.occam.converter.ITypeConverter;

public class ShortConverter implements ITypeConverter {
	private ITypeConverter nextTypeConverter;
	
	@SuppressWarnings("rawtypes")
	public IDataConverter<?> getConverter(Class clazz) {
		if(clazz == short.class || clazz == Short.class) {
			return new IDataConverter<Short>() {

				public Short convert(String data) {
					return Short.valueOf(data);
				}
				
			};
		}
		
		return nextTypeConverter.getConverter(clazz);
	}

	public void setNextTypeConverter(ITypeConverter nextTypeConverter) {
		this.nextTypeConverter = nextTypeConverter;
	}
}
