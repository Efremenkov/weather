package ru.efremenkov.service.rest.cache;

import ru.efremenkov.business.BusinessException;
import ru.efremenkov.business.model.CacheConfigurationRq;
import ru.efremenkov.service.rest.RestServiceBase;
import ru.efremenkov.service.rest.cache.processors.CacheConfigurationServiceProcessor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

/**
 * @author efremenkov
 * @ created 05.03.2017
 * $Author$
 * $Revision$
 */
@Path("/v1/cache")
public class CacheConfigurationServiceImpl extends RestServiceBase implements CacheConfigurationService {

    @Override
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/configure")
    public Response configure(JAXBElement<CacheConfigurationRq> request) {
        CacheConfigurationServiceProcessor processor = new CacheConfigurationServiceProcessor();
        try {
            CacheConfigurationRq cacheConfigurationRq = request.getValue();
            return responseWithOkStatus(processor.process(
                cacheConfigurationRq.getHeapSize(),
                cacheConfigurationRq.getOffheapSize(),
                cacheConfigurationRq.getDiskMemSize(),
                cacheConfigurationRq.getDuration()));
        }
        catch (BusinessException e) {
            return responseWithErrorStatus(e);
        }
    }
}
