package br.senac.sp.occam.converter.implementation;

import br.senac.sp.occam.converter.IDataConverter;
import br.senac.sp.occam.converter.ITypeConverter;

public class IdentityConverter implements ITypeConverter {
	private ITypeConverter nextTypeConverter;

	@SuppressWarnings("rawtypes")
	public IDataConverter<?> getConverter(Class clazz) {
		if(clazz == String.class) {
			return new IDataConverter<String>() {

				public String convert(String data) {
					return data;
				}
				
			};
		}
		
		return nextTypeConverter.getConverter(clazz);
	}

	public void setNextTypeConverter(ITypeConverter nextTypeConverter) throws Exception {
		throw new Exception("No next converter available");
	}

}
