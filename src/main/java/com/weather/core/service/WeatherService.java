package com.weather.core.service;

import com.weather.core.entity.Weather;
import com.weather.core.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository;

    public void save(Weather weather){
        weatherRepository.save(weather);
    }

    public void saveAll(List<Weather> weatherList){
        weatherRepository.saveAll(weatherList);
    }
}
