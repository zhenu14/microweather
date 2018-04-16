package com.weather.vo.heweather;

import java.io.Serializable;
import java.util.List;

public class HeWeather implements Serializable {
    private static final long serialVersionUID = 1L;

    private Basic basic;
    private List<Forecast> daily_forecast;
    private String status;
    private Update update;

    public Basic getBasic() {
        return basic;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }

    public List<Forecast> getDaily_forecast() {
        return daily_forecast;
    }

    public void setDaily_forecast(List<Forecast> daily_forecast) {
        this.daily_forecast = daily_forecast;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }
}
