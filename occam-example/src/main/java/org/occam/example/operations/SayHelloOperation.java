package org.occam.example.operations;


import org.occam.core.annotations.Bean;
import org.occam.core.annotations.NavigationCase;
import org.occam.core.annotations.NavigationCases;
import org.occam.core.annotations.Operation;
import org.occam.core.enums.InstanceStrategy;
import org.occam.core.enums.NavigationStatus;
import org.occam.example.beans.Dude;

@Operation(InstanceStrategy.PROTOTYPE)
public class SayHelloOperation {
    @Bean
    private Dude dude;

    @NavigationCases({
            @NavigationCase(status = NavigationStatus.SUCCESS, url = "nicetomeetyou.jsp"),
            @NavigationCase(status = NavigationStatus.FAIL, url = "sorrydude.jsp")})
    public Dude sayHello() {
        return dude;
    }
}
