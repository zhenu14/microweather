package com.weather.service;

import com.weather.vo.city.HeCityResponse;

public interface HeCityService {

    HeCityResponse getHotCity(int number);
}
