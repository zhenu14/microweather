package com.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.vo.city.HeCityResponse;
import com.weather.vo.heweather.HeweatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class HeCityServiceImpl implements HeCityService {
    @Autowired
    private RestTemplate restTemplate;

    private final String CITY_API = "https://search.heweather.com/top";

    private final String KEY = "a326372b9525455d96c6add4ffa0b415";

    private final String GROUP = "cn";

    @Override
    public HeCityResponse getHotCity(int number) {
        String uri = CITY_API + "?group=" + GROUP + "&key=" + KEY + "&number=" + number;
        return this.doGetWeatherData(uri);
    }

    private HeCityResponse doGetWeatherData(String uri){
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        String strBody = null;

        if (response.getStatusCodeValue() == 200) {
            strBody = response.getBody();
        }

        strBody = strBody.replace('H','h');
        ObjectMapper mapper = new ObjectMapper();
        HeCityResponse cityResponse = null;

        try {
            cityResponse = mapper.readValue(strBody, HeCityResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cityResponse;
    }
}
