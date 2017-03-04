package ru.efremenkov.utils;

import javax.ws.rs.core.Response;

public class ResponseUtils {

    public static Response buildEntity(final String entity) {
        return Response.ok().entity(entity).build();
    }
}
