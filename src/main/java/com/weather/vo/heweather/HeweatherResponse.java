package com.weather.vo.heweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class HeweatherResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<HeWeather> heWeather6;

    public List<HeWeather> getHeWeather6() {
        return heWeather6;
    }

    public void setHeWeather6(List<HeWeather> heWeather6) {
        this.heWeather6 = heWeather6;
    }
}
