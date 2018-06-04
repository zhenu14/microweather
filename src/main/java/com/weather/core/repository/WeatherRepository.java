package com.weather.core.repository;

import com.weather.core.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="weather_day")
public interface WeatherRepository extends JpaRepository<Weather, Long >{

    @Query("select t from WeatherEntity t where t.location = :location")
    Weather findByCity(@Param("location")String location);

}
