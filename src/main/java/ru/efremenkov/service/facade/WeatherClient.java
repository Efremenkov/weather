package ru.efremenkov.service.facade;

import ru.efremenkov.business.BusinessException;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public interface WeatherClient {

    String getLocation(final String longitude, final String latitude) throws BusinessException;

    String getTemperature(final String longitude, final String latitude) throws BusinessException;
}
