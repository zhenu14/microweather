package com.weather.service;

import com.weather.vo.heweather.HeweatherResponse;

public interface HeWeatherService {
    /**
     * 根据城市ID查询天气数据
     * @param location,key
     * @return
     */
    HeweatherResponse getDataByKey(String location);

    /**
     * 根据城市名称查询天气数据
     * @param location,signature
     * @return
     */
    HeweatherResponse getDataBySignature(String location);

}
