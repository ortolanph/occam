package org.occam.core.exceptions;

public class InvalidOperationException extends Exception {
	private static final long serialVersionUID = 5576556101496124068L;

	public InvalidOperationException(String operation) {
		super(String.format("Invalid Operation: %s", operation));
	}
}
