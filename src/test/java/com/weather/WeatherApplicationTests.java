package com.weather;

import com.weather.service.WeatherDataService;
import com.weather.vo.weather.WeatherResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationTests {

	@Autowired
	private WeatherDataService weatherDataService;

	@Test
	public void getDataByCityId() {
		WeatherResponse result = weatherDataService.getDataByCityId("101280601");
		System.out.println(result.toString());
	}

	@Test
	public void getDataByCityName() {
		weatherDataService.getDataByCityName("惠州");
	}



}
