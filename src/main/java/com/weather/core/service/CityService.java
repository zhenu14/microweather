package com.weather.core.service;

import com.weather.core.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    public List<String> getCityId(){
        return cityRepository.getCityId();
    }
}
