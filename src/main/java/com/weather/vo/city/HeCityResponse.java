package com.weather.vo.city;

import java.io.Serializable;
import java.util.List;

public class HeCityResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<City> HeWeather6;

    public List<City> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<City> heWeather6) {
        HeWeather6 = heWeather6;
    }
}
