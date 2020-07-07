package com.marko.singi.restIspit2;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

	List<Car> findByName(String name);

	List<Car> findByHp(double hp);

	List<Car> findByTypeContaining(String type);

	List<Car> findByManufacturer(String manu);

}
