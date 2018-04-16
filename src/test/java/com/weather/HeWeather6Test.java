package com.weather;

import com.weather.service.HeWeatherService;
import com.weather.vo.heweather.HeweatherResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeWeather6Test {
    @Autowired
    private HeWeatherService heWeatherService;

    @Test
    public void getDataByCityId() {
        HeweatherResponse result = heWeatherService.getDataByKey("北京");
    }

}
