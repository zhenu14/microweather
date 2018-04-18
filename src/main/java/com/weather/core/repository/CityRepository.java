package com.weather.core.repository;

import com.weather.core.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name="weather_city")
public interface CityRepository extends JpaRepository<City, Long >{

    @Query("select t.city_id from City t ")
    public List<String> getCityId();
}
