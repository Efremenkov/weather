package ru.efremenkov.service.rest;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.Status.OK;
import static javax.ws.rs.core.Response.status;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class RestServiceBase {
    protected <T> Response responseWithOkStatus(T response) {
        CacheControl cacheControl = new CacheControl();
        cacheControl.setNoCache(true);
        return status(OK).cacheControl(cacheControl).entity(response).build();
    }

    protected Response responseWithErrorStatus(Exception e) {
        CacheControl cacheControl = new CacheControl();
        cacheControl.setNoCache(true);
        return status(INTERNAL_SERVER_ERROR).cacheControl(cacheControl).build();
    }
}
