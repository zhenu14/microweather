package com.weather.vo.city;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Basic> basic;

    private String status;

    public List<Basic> getBasic() {
        return basic;
    }

    public void setBasic(List<Basic> basic) {
        this.basic = basic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
