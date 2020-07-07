package com.marko.singi.restIspit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/captains")
public class CaptainController {
	
	@Autowired
	CaptainRespository captainRespository;
	
	@GetMapping("/captains")
	public List<Captain> showAll(){
		return captainRespository.findAll();
	}

}
