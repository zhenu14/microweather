package com.weather.controller;

import com.weather.service.HeCityService;
import com.weather.service.HeWeatherService;
import com.weather.service.WeatherDataService;
import com.weather.vo.city.HeCityResponse;
import com.weather.vo.heweather.HeweatherResponse;
import com.weather.vo.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherDataService weatherDataService;

    @Autowired
    private HeWeatherService heWeatherService;

    @Autowired
    private HeCityService heCityService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getReportByCityId(@PathVariable("cityId") String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getReportByCityName(@PathVariable("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }

    @GetMapping("/key/{cityName}")
    public HeweatherResponse get(@PathVariable("cityName") String cityName) {
        return heWeatherService.getDataByKey(cityName);
    }

    @GetMapping("/city/{number}")
    public HeCityResponse getHotCity(@PathVariable("number") int number) {
        return heCityService.getHotCity(number);
    }

}
