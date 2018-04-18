package com.weather.core.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "weather_day")
public class Weather implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;
    @Column(name="city_id")
    private String city_id;
    @Column(name="location")
    private String location;
    @Column(name="longitude")
    private String longitude;
    @Column(name="latitude")
    private String latitude;
    @Column(name="parent_city")
    private String parent_city;
    @Column(name="admin_area")
    private String admin_area;
    @Column(name="cnty")
    private String cnty;
    @Column(name="tmp_max")
    private String tmp_max;
    @Column(name="tmp_min")
    private String tmp_min;
    @Column(name="cond_txt_day")
    private String cond_txt_day;
    @Column(name="cond_txt_night")
    private String cond_txt_night;
    @Column(name="date")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getParent_city() {
        return parent_city;
    }

    public void setParent_city(String parent_city) {
        this.parent_city = parent_city;
    }

    public String getAdmin_area() {
        return admin_area;
    }

    public void setAdmin_area(String admin_area) {
        this.admin_area = admin_area;
    }

    public String getCnty() {
        return cnty;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public String getTmp_max() {
        return tmp_max;
    }

    public void setTmp_max(String tmp_max) {
        this.tmp_max = tmp_max;
    }

    public String getTmp_min() {
        return tmp_min;
    }

    public void setTmp_min(String tmp_min) {
        this.tmp_min = tmp_min;
    }

    public String getCond_txt_day() {
        return cond_txt_day;
    }

    public void setCond_txt_day(String cond_txt_day) {
        this.cond_txt_day = cond_txt_day;
    }

    public String getCond_txt_night() {
        return cond_txt_night;
    }

    public void setCond_txt_night(String cond_txt_night) {
        this.cond_txt_night = cond_txt_night;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
