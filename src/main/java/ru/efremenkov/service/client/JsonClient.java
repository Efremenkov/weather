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

    public JsonClient() {
        super(SettingsUtils.getProperty(AUTH_KEY));
    }

    @Override
    protected String getFormat() {
        return "json";
    }

    public GetWeatherRs getWeather(final String longitude, final String latitude) throws
                                                                                 BusinessException {
        String entity = getResponse(longitude, latitude ).readEntity(String.class);

        Gson gson = new Gson();
        return gson.fromJson(entity, GetWeatherRs.class);
    }
}
