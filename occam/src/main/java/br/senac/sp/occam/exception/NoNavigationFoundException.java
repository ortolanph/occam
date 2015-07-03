package br.senac.sp.occam.exception;

public class NoNavigationFoundException extends Exception {
	private static final long serialVersionUID = 5332709923037518508L;

	public NoNavigationFoundException(String methodName) {
		super(String.format("No NavigationCases defined for %s", methodName));
	}
}
