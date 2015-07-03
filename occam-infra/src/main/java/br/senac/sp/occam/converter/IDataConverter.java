package br.senac.sp.occam.converter;

public interface IDataConverter<T> {
	T convert(String data);
}
