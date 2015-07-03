package org.occam.core.annotations;

import org.occam.core.enums.NavigationStatus;

public @interface NavigationCase {
    NavigationStatus status();

    String url();
}
