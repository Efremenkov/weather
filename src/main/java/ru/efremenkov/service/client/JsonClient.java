package ru.efremenkov.service.client;

import com.google.gson.Gson;
import ru.efremenkov.business.BusinessException;
import ru.efremenkov.business.model.GetWeatherRs;
import ru.efremenkov.utils.SettingsUtils;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class JsonClient extends ClientBase{

    private static final String AUTH_KEY = "apitest.foreca.net.auth.key";

    private static final String MSG_UNKNOWN_KEY_RESPONSE = "Unknown key";
    private static final String MSG_LOCATION_RESPONSE_ERROR = "Unknown location with %s longitude and %s latitude";

    public JsonClient() {
        super(SettingsUtils.getProperty(AUTH_KEY));
    }

    @Override
    protected String getFormat() {
        return "json";
    }

    public GetWeatherRs getWeather(final String longitude, final String latitude) throws BusinessException {
        String entity = getResponse(longitude, latitude ).readEntity(String.class);
        validateResponseEntity(entity, longitude, latitude);

        Gson gson = new Gson();
        return gson.fromJson(entity, GetWeatherRs.class);
    }

    private void validateResponseEntity(final String entity, final String longitude, final String latitude) throws BusinessException {
        if (entity.contains("unknown key")) {
            throw new BusinessException(MSG_UNKNOWN_KEY_RESPONSE);
        }
        if(entity.contains("err: location missing")) {
            throw new BusinessException(String.format(MSG_LOCATION_RESPONSE_ERROR, longitude, latitude));
        }
    }
}
