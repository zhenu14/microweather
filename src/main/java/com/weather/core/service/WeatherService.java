package com.weather.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.controller.LogController;
import com.weather.core.entity.Weather;
import com.weather.core.repository.WeatherRepository;
import com.weather.vo.heweather.HeweatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String WEATHER_API = "https://free-api.heweather.com/s6/weather/forecast";

    private final String KEY1 = "a326372b9525455d96c6add4ffa0b415";
    private final String KEY2 = "eaad8aac14cf40e08494082201f9c46e";
    private final String KEY3 = "fcacbe7ba7424fff88c91fe1bb47dee3";
    private final String KEY4 = "1e5f31808f0142b5976f3b3102455714";
    private final List<String> KEYS =new ArrayList<>(Arrays.asList(KEY1,KEY2,KEY3,KEY4));
    public static int step = 0;

    public void save(Weather weather) {
        weatherRepository.save(weather);
    }

    public void saveAll(List<Weather> weatherList) {
        weatherRepository.saveAll(weatherList);
    }

    public Weather findByCity(String location) {
        return weatherRepository.findByCity(location);
    }

    public HeweatherResponse getDataByKey(String location) throws Exception{

        String uri = WEATHER_API + "?location=" + location + "&key=" + KEYS.get(step);

        LogController.info("WeatherManager", "Get Data From " + uri );

        HeweatherResponse heweatherResponse = this.doGetWeatherData(uri);
        String status = heweatherResponse.getHeWeather6().get(0).getStatus();
        if(status == "no more requests" || status.equals("no more requests")){
            LogController.info("WeatherManager", "status no more requests! step++" );
            if(step < 3){
                step++;
                uri = WEATHER_API + "?location=" + location + "&key=" + KEYS.get(step);
                heweatherResponse = this.doGetWeatherData(uri);
            }else{
                LogController.info("WeatherManager", "status no more requests!@ step over :" + step );
                return null;
            }
        }
        if(status == "too fast" || status.equals("too fast")){
            LogController.info("WeatherManager", "request too fast" );
            Thread.sleep(10000);
            this.getDataByKey(location);
        }
        return heweatherResponse;
    }

    private HeweatherResponse doGetWeatherData(String uri){
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        String strBody = null;

        if (response.getStatusCodeValue() == 200) {
            strBody = response.getBody();
        }
        strBody = strBody.replace('H','h');
        ObjectMapper mapper = new ObjectMapper();
        HeweatherResponse weather = null;

        try {
            weather = mapper.readValue(strBody, HeweatherResponse.class);
        } catch (IOException e) {
            LogController.error("json parse error",e.toString());
            return weather;
        }

        return weather;
    }
}
