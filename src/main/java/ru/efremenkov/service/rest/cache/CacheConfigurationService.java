package ru.efremenkov.service.rest.cache;

import ru.efremenkov.business.model.CacheConfigurationRq;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

/**
 * @author efremenkov
 * @ created 05.03.2017
 * $Author$
 * $Revision$
 */
public interface CacheConfigurationService {

    Response configure(JAXBElement<CacheConfigurationRq> request);
}
