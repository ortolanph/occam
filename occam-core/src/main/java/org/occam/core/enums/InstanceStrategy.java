package org.occam.core.enums;

/**
 * The Instance Strategy for Occam Container.
 *
 * @author Paulo Henrique Ortolan
 */
public enum InstanceStrategy {
    /**
     * Strategy to create only one class on container.
     */
	SINGLETON,
    /**
     * Strategy to create the instance every time when called.
     */
    PROTOTYPE;
}
