package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

	City findCityByCityName(String cityName);
}
