package com.marko.singi.restIspit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class BoatController {
	
	@Autowired
	BoatRepository boatRepository;
	@Autowired
	CaptainRespository captainRepository;
	@Autowired
	Docked_boatRepository docked_boatRepository;
	@Autowired
	DockRepository dockRepository;
	
	@GetMapping("/boats")
	public List<BoatHelp> showAll(){
		List<Boat> arr = boatRepository.findAll();
		List<Captain> arrCap = captainRepository.findAll();
		List<BoatHelp> finalList = new ArrayList<>();
		
		
		for(int i=0;i<arr.size();i++) {
			BoatHelp bh = new BoatHelp(arr.get(i).getId(),arr.get(i).getName(),arrCap.get(i).getName(), arrCap.get(i).getExperience());
			finalList.add(bh);
		}
	
		return finalList;
		
	}
	
	@GetMapping("/captains")
	public List<Captain> show(){
		return captainRepository.findAll();
	}
	
	@GetMapping("/dockedBoats")
	public List<DockedBoatHelp> dockedBoats(){
		List<DockedBoat> dockedBoatList = docked_boatRepository.findAll();
		List<Boat> boatList = new ArrayList<>();
		List<Dock> dockList = new ArrayList<>();
		List<Captain> capList = new ArrayList<>();
		List<DockedBoatHelp> finalList = new ArrayList<>();
		
		for(DockedBoat db : dockedBoatList) {
			
			boatList.add(boatRepository.getOne(db.getBoat_id()));
			dockList.add(dockRepository.getOne(db.getDock_id()));
			capList.add(captainRepository.getOne(boatRepository.getOne(db.getBoat_id()).getCaptain_id()));
		}
		
		for(int i=0;i<boatList.size();i++) {
			DockedBoatHelp dbh = new DockedBoatHelp(boatList.get(i).getName(),dockList.get(i).getName(),dockList.get(i).getCapacity(),dockList.get(i).isFull(), capList.get(i).getName());
			finalList.add(dbh);
		}
		
		return finalList;
		
	}
	
	//get full docks
	@GetMapping("/fullDocks")
	public List<Dock> findFullDocks(){
		List<Dock> helpingList = dockRepository.findAll();
		List<Dock> mainList = new ArrayList<>();
		for(Dock d : helpingList) {
			if(d.isFull()) {
				mainList.add(d);
			}
		}
		return mainList;
	}
	
	//get available docks
	@GetMapping("/availableDocks")
	public List<Dock> freeDocks(){
		List<Dock> helpingList = dockRepository.findAll();
		List<Dock> mainList = new ArrayList<>();
		for(Dock d : helpingList) {
			if(!d.isFull()) {
				mainList.add(d);
			}
		}
		return mainList;
	}
	

}
