package com.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.vo.heweather.HeweatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class HeWeatherServiceImpl implements HeWeatherService{
    @Autowired
    private RestTemplate restTemplate;

    private final String WEATHER_API = "https://free-api.heweather.com/s6/weather/forecast";

    private final String KEY = "a326372b9525455d96c6add4ffa0b415";

    private final String USERID = "HE1804161639331017";

    @Override
    public HeweatherResponse getDataByKey(String location) {
        String uri = WEATHER_API + "?location=" + location + "&key=" + KEY;
        return this.doGetWeatherData(uri);
    }

    @Override
    public HeweatherResponse getDataBySignature(String location) {
        return null;
    }

    private HeweatherResponse doGetWeatherData(String uri){
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        String strBody = null;

        if (response.getStatusCodeValue() == 200) {
            strBody = response.getBody();
        }
//        strBody.indexOf('h');
        strBody = strBody.replace('H','h');
        ObjectMapper mapper = new ObjectMapper();
        HeweatherResponse weather = null;

        try {
            weather = mapper.readValue(strBody, HeweatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weather;
    }
}
