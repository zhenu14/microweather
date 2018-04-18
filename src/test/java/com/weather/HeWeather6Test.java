package com.weather;

import com.weather.core.entity.Weather;
import com.weather.core.service.CityService;
import com.weather.core.service.WeatherService;
import com.weather.service.HeCityService;
import com.weather.service.HeWeatherService;
import com.weather.vo.city.HeCityResponse;
import com.weather.vo.heweather.Basic;
import com.weather.vo.heweather.Forecast;
import com.weather.vo.heweather.HeweatherResponse;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeWeather6Test {
    @Autowired
    private HeWeatherService heWeatherService;

    @Autowired
    private HeCityService heCityService;

    @Autowired
    private CityService cityService;

    @Autowired
    private WeatherService weatherService;

    @Test
    public void getDataByCityId() {
        HeweatherResponse result = heWeatherService.getDataByKey("北京");
    }

    @Test
    public void getHotCity(){
        HeCityResponse result = heCityService.getHotCity(50);
        System.out.println(result);
    }

    @Test
    public void testttt() throws Exception{
        List<String> list = cityService.getCityId();
        List<HeweatherResponse> heweatherResponseList = new ArrayList<>();
//        for(int i = 0;i < 10;i++){
//            HeweatherResponse heweatherResponse = heWeatherService.getDataByKey(list.get(i));
//            heweatherResponseList.add(heweatherResponse);
//        }
        for(String city_id:list){
            HeweatherResponse heweatherResponse = heWeatherService.getDataByKey(city_id);
            heweatherResponseList.add(heweatherResponse);
        }
        System.out.println(heweatherResponseList.size());

        List<Weather> weatherList = new ArrayList<>();
        for(HeweatherResponse entity : heweatherResponseList){

            Basic basic = entity.getHeWeather6().get(0).getBasic();
            Forecast forecast = entity.getHeWeather6().get(0).getDaily_forecast().get(0);

            Weather weather = new Weather();
            weather.setCity_id(basic.getCid());
            weather.setLocation(basic.getLocation());
            weather.setAdmin_area(basic.getAdmin_area());
            weather.setParent_city(basic.getParent_city());
            weather.setCnty(basic.getCnty());
            weather.setLongitude(basic.getLon());
            weather.setLatitude(basic.getLat());
            weather.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(forecast.getDate()));
            weather.setTmp_max(forecast.getTmp_max());
            weather.setTmp_min(forecast.getTmp_min());
            weather.setCond_txt_day(forecast.getCond_txt_d());
            weather.setCond_txt_night(forecast.getCond_txt_n());

            weatherList.add(weather);
        }
        weatherService.saveAll(weatherList);
    }

    @Test
    public void testtt(){
        Weather weather = new Weather();
        weather.setAdmin_area("1");
        weather.setDate(new Date());
        weatherService.save(weather);
    }

}
