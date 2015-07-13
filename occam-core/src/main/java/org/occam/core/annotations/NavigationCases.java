package org.occam.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines a list of Navigation Cases to be redirected.
 * @author Paulo Henrique Ortolan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NavigationCases {

    /**
     * The List of NavigationCase.
     * @return the set of Navigation Cases.
     */
	NavigationCase[] value();
}