package com.weather.vo.heweather;

import java.io.Serializable;

public class Update implements Serializable {
    private static final long serialVersionUID = 1L;
    private String loc;
    private String utc;

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }
}
