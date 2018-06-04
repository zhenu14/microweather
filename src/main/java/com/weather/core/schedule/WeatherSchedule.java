package com.weather.core.schedule;

import com.weather.controller.LogController;
import com.weather.core.entity.Weather;
import com.weather.core.service.CityService;
import com.weather.core.service.WeatherService;
import com.weather.vo.heweather.Basic;
import com.weather.vo.heweather.Forecast;
import com.weather.vo.heweather.HeweatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
@EnableScheduling
public class WeatherSchedule {
    @Autowired
    private CityService cityService;

    @Autowired
    private WeatherService weatherService;

    public final static long ONE_DAY =  60 * 1000 * 60 * 24;  //24小时

    //    @Scheduled(fixedRate = ONE_DAY)
    @Scheduled(cron = "0 0 2 * * ?" )  //每天早上两点触发
    private void weatherSchedule2() throws Exception{
        LogController.info("weatherSchedule", "get All City Data Job Is Running");
        WeatherService.step = 0;
        LogController.info("weatherSchedule", "init Keys step");
        try{
            List<String> list = cityService.getCityId();
            int count = 0;
            for(String city_id:list){
                if(count == 150){
                    Thread.sleep(60000);
                    count = 0;
                }
                HeweatherResponse heweatherResponse = weatherService.getDataByKey(city_id);

                if(heweatherResponse == null){
                    LogController.info("HeweatherResponse", " null " );
                    return;
                }

                String status = heweatherResponse.getHeWeather6().get(0).getStatus();
                if(status != "ok" && !status.equals("ok")){
                    continue;
                }

                Basic basic = heweatherResponse.getHeWeather6().get(0).getBasic();
                Forecast forecast = heweatherResponse.getHeWeather6().get(0).getDaily_forecast().get(0);

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

                weatherService.save(weather);
                count++;
                LogController.info("weatherService", "save success" + count );
            }
        }catch (Exception e){
            LogController.info("weatherService", "save fail  : " + e.toString() );
        }
    }
}
