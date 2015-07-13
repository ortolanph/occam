package org.occam.core.annotations;

import org.occam.core.enums.NavigationStatus;

/**
 * Points to an URL to be redirected and bounds it to a Navigation Status.
 *
 * @author Paulo Henrique Ortolan
 */
public @interface NavigationCase {
    /**
     * The set of possible Navigation Status.
     *
     * @see org.occam.core.enums.NavigationStatus
     * @return a Navigation Status.
     */
    NavigationStatus status();

    /**
     * The URL to be redirected.
     *
     * @return the URL.
     */
    String url();
}
