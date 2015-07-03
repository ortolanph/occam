package br.senac.sp.occam.annotation;

import br.senac.sp.occam.enums.NavigationStatus;

public @interface NavigationCase {
	NavigationStatus status();
	String url();
}
