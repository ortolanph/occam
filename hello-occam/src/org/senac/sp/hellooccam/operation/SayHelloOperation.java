package org.senac.sp.hellooccam.operation;

import org.senac.sp.hellooccam.beans.Dude;

import br.senac.sp.occam.annotation.Bean;
import br.senac.sp.occam.annotation.NavigationCase;
import br.senac.sp.occam.annotation.NavigationCases;
import br.senac.sp.occam.annotation.Operation;
import br.senac.sp.occam.enums.InstanceStrategy;
import br.senac.sp.occam.enums.NavigationStatus;

@Operation(InstanceStrategy.PROTOTYPE)
public class SayHelloOperation {
	@Bean
	private Dude dude;
	
	@NavigationCases({
		@NavigationCase(status = NavigationStatus.SUCCESS, url = "nicetomeetyou.jsp"),
		@NavigationCase(status = NavigationStatus.FAIL, url = "sorrydude.jsp") })
	public Dude sayHello() {
		return dude;
	}
}
