package ru.efremenkov.service.client;

import ru.efremenkov.business.BusinessException;
import ru.efremenkov.utils.SettingsUtils;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public abstract class ClientBase {
    private static final String HTTP_SCHEME = "http";
    private final Client client;
    private final URI serviceUri;

    private static final String PATH = "apitest.foreca.net.path";
    private final String authKey;

    private static final String MSG_RESPONSE_NULL = "Empty response for %s longitude and %s latitude";
    private static final String MSG_NO_RESPONSE = "No response for %s longitude and %s latitude";
    private static final String UNKNOWN_KEY_RESPONSE = "Unknown key";

    public ClientBase(String authKey) {
        this.authKey = authKey;
        serviceUri = UriBuilder.fromPath("").scheme(HTTP_SCHEME).path(SettingsUtils.getProperty(PATH)).build();
        client = ClientBuilder.newClient();
    }

    protected WebTarget getTarget() {
        return client.target(serviceUri);
    }

    protected abstract String getFormat();

    protected Response getResponse(final String longitude, final String latitude) throws
                                                                                 BusinessException {
        try {
            Response response = getTarget()
                .queryParam("lon", longitude)
                .queryParam("lat", latitude)
                .queryParam("key", authKey)
                .queryParam("format", getFormat())
                .request().get();
            if ((response == null) || (response.getStatusInfo().getStatusCode() != Response.Status.OK.getStatusCode())) {
                throw new BusinessException(String.format(MSG_RESPONSE_NULL, longitude, latitude));
            }
            if (response.toString().equals("unknown key")) {
                throw new BusinessException(UNKNOWN_KEY_RESPONSE);
            }
            return response;
        }
        catch (ProcessingException e) {
            throw new BusinessException(String.format(MSG_NO_RESPONSE, longitude, latitude));
        }
    }
}
