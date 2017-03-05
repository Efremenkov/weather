package ru.efremenkov.service.facade;

import ru.efremenkov.business.BusinessException;
import ru.efremenkov.business.model.WeatherInfo;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public interface WeatherClient {

    WeatherInfo getWeatherInfo(final String longitude, final String latitude) throws BusinessException;
}
