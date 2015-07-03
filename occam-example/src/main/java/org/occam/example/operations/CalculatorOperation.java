package org.occam.example.operations;

import org.occam.core.annotations.Bean;
import org.occam.core.annotations.NavigationCase;
import org.occam.core.annotations.NavigationCases;
import org.occam.core.annotations.Operation;
import org.occam.core.enums.InstanceStrategy;
import org.occam.core.enums.NavigationStatus;
import org.occam.example.beans.Operadores;
import org.occam.example.beans.ResultadoCalculadora;


@Operation(InstanceStrategy.SINGLETON)
public class CalculatorOperation {
	@Bean
	private Operadores operadores;

	@NavigationCases({
			@NavigationCase(status = NavigationStatus.SUCCESS, url = "resultado.jsp"),
			@NavigationCase(status = NavigationStatus.FAIL, url = "contaErrada.jsp") })
	public ResultadoCalculadora somar() {
		return new ResultadoCalculadora(operadores.getOperador1()
				+ operadores.getOperador2());
	}

	@NavigationCases({
			@NavigationCase(status = NavigationStatus.SUCCESS, url = "resultado.jsp"),
			@NavigationCase(status = NavigationStatus.FAIL, url = "contaErrada.jsp") })
	public ResultadoCalculadora subtrair() {
		return new ResultadoCalculadora(operadores.getOperador1()
				- operadores.getOperador2());
	}

	@NavigationCases({
			@NavigationCase(status = NavigationStatus.SUCCESS, url = "resultado.jsp"),
			@NavigationCase(status = NavigationStatus.FAIL, url = "contaErrada.jsp") })
	public ResultadoCalculadora multiplicar() {
		return new ResultadoCalculadora(operadores.getOperador1()
				* operadores.getOperador2());
	}

	@NavigationCases({
			@NavigationCase(status = NavigationStatus.SUCCESS, url = "resultado.jsp"),
			@NavigationCase(status = NavigationStatus.FAIL, url = "contaErrada.jsp") })
	public ResultadoCalculadora dividir() {
		return new ResultadoCalculadora(operadores.getOperador1()
				/ operadores.getOperador2());
	}
}
