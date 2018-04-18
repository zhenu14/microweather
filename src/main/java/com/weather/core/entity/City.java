package com.weather.core.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "weather_city")
public class City implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;
    @Column(name="city_id")
    private String city_id;
    @Column(name="city_engname")
    private String city_engname;
    @Column(name="city_chiname")
    private String city_chiname;
    @Column(name="country_code")
    private String country_code;
    @Column(name="country_engname")
    private String country_engname;
    @Column(name="country_chiname")
    private String country_chiname;
    @Column(name="province_engname")
    private String province_engname;
    @Column(name="province_chiname")
    private String province_chiname;
    @Column(name="parent_city_engname")
    private String parent_city_engname;
    @Column(name="parent_city_chiname")
    private String parent_city_chiname;
    @Column(name="longitude")
    private String longitude;
    @Column(name="latitude")
    private String latitude;
    @Column(name="adcode")
    private String adcode;

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

    public String getCity_engname() {
        return city_engname;
    }

    public void setCity_engname(String city_engname) {
        this.city_engname = city_engname;
    }

    public String getCity_chiname() {
        return city_chiname;
    }

    public void setCity_chiname(String city_chiname) {
        this.city_chiname = city_chiname;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_engname() {
        return country_engname;
    }

    public void setCountry_engname(String country_engname) {
        this.country_engname = country_engname;
    }

    public String getCountry_chiname() {
        return country_chiname;
    }

    public void setCountry_chiname(String country_chiname) {
        this.country_chiname = country_chiname;
    }

    public String getProvince_engname() {
        return province_engname;
    }

    public void setProvince_engname(String province_engname) {
        this.province_engname = province_engname;
    }

    public String getProvince_chiname() {
        return province_chiname;
    }

    public void setProvince_chiname(String province_chiname) {
        this.province_chiname = province_chiname;
    }

    public String getParent_city_engname() {
        return parent_city_engname;
    }

    public void setParent_city_engname(String parent_city_engname) {
        this.parent_city_engname = parent_city_engname;
    }

    public String getParent_city_chiname() {
        return parent_city_chiname;
    }

    public void setParent_city_chiname(String parent_city_chiname) {
        this.parent_city_chiname = parent_city_chiname;
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

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }
}
