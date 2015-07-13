package org.occam.core.annotations;

import org.occam.core.enums.InstanceStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the method as an Occam Operation.
 *
 * @author Paulo Henrique Ortolan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Operation {

    /**
     * Defines an InstanceStrategy for Operation.
     *
     * @see org.occam.core.enums.InstanceStrategy
     * @return an InstanceStrategy.
     */
	InstanceStrategy value();
}
