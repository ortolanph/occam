package br.senac.sp.exemplo.operations;

import br.senac.sp.exemplo.beans.Operadores;
import br.senac.sp.exemplo.beans.ResultadoCalculadora;
import br.senac.sp.occam.annotation.Bean;
import br.senac.sp.occam.annotation.NavigationCase;
import br.senac.sp.occam.annotation.NavigationCases;
import br.senac.sp.occam.annotation.Operation;
import br.senac.sp.occam.enums.InstanceStrategy;
import br.senac.sp.occam.enums.NavigationStatus;

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
