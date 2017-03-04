package ru.efremenkov.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.hk2.utilities.binding.ServiceBindingBuilder;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public abstract class BinderBase extends AbstractBinder {
    protected <T> ServiceBindingBuilder<T> bindSelf(Class<T> serviceType) {
        return bind(serviceType).to(serviceType);
    }
}
