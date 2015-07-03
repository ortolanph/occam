package br.senac.sp.exemplo.beans;

public class ResultadoCalculadora {
	private int resultado;
	
	public ResultadoCalculadora() {	}
	
	public ResultadoCalculadora(int resultado) {
		this.resultado = resultado;
	}

	public int getResultado() {
		return resultado;
	}
	
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "ResultadoCalculadora [resultado=" + resultado + "]";
	}
}
