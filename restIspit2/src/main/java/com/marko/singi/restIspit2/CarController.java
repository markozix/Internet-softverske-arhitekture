package com.marko.singi.restIspit2;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*")
@RestController
public class CarController {
	
	@Autowired
	CarRepository carRepository;
	
	@Autowired
	OrderRepository orderRespository;
	
	//get all cars
	@GetMapping("/cars")
	public List<Car> root(){
		return carRepository.findAll();
	}
	
	//get by type
	@GetMapping("/carType/{type}")
	public List<Car> find(@PathVariable String type){
		return carRepository.findByTypeContaining(type);
	}
	
	//get cars by name
	@GetMapping("/carName/{name}")
	public List<Car> search(@PathVariable String name) {
		return carRepository.findByName(name);
	}
	
	//get by manufacturer
	@GetMapping("/carManufacturer/{manu}")
	public List<Car> findManu(@PathVariable String manu){
		return carRepository.findByManufacturer(manu);
	}
	
	//get car by hp
	@GetMapping("/carHp/{hp}")
	public List<Car> show(@PathVariable double hp) {
		return carRepository.findByHp(hp);
	}
	
	//add new car
	@PostMapping("/addCar")
	public Car create(@RequestBody Map<String, String> body) {
		System.err.println(body);
		String name = body.get("name");
		String manufacturer = body.get("manufacturer");
		double hp = Double.parseDouble(body.get("hp"));
		String type = body.get("type");
		return carRepository.save(new Car(name,manufacturer,hp,type));
	}
	
	//update the car info
	@PutMapping("/carUpdate/{id}")
	public Car update(@PathVariable String id, @RequestBody Map<String, String> body) {
		int carid = Integer.parseInt(id);
		Car car = carRepository.getOne(carid);
		car.setName(body.get("name"));
		double hp = Double.parseDouble(body.get("hp"));
		car.setHp(hp);
		car.setManufacturer(body.get("manufacturer"));
		car.setType(body.get("type"));
		return carRepository.save(car);
	}
	
	//delete car
	@DeleteMapping("/deleteCar/{id}")
	public boolean delete(@PathVariable String id) {
		int carid = Integer.parseInt(id);
		carRepository.deleteById(carid);
		return true;
	}
	
	//get orders
	@GetMapping("/showOrders")
	public List<Testorder> root2(){
		return orderRespository.findAll();
	}
	
	@PutMapping("/putInProgress/{id}")
	public Testorder updateOrder(@PathVariable String id) {
		int idT = Integer.parseInt(id);
		Testorder t = orderRespository.getOne(idT);
		t.setStatus("inProgress");
		return orderRespository.save(t);
	}

}
