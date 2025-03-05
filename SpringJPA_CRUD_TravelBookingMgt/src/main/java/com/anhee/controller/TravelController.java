package com.anhee.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.anhee.entity.Travel;
import com.anhee.interfac.I_ITravelService;

@Controller
public class TravelController {
	
	@Autowired
	private I_ITravelService service;
	
	public String addTravel(Travel travel)
	{	
		service.addTravel(travel);
		return "Travel added";
		
	}
	public Iterable<Travel> retrieveAllTravels() {
	    Iterable<Travel> allTravels = service.getAllTravels();

	    if (!allTravels.iterator().hasNext()) {
	        System.out.println("No Travel available");
	    }
	    
	    return allTravels;  
	}

	public Optional<Travel> findTravelById(Integer id)
	{
		
		return service.findTravelById(id);
		
	}
	public String deleteTravelById(Integer id){
		service.deleteTravelById(id);
		return "travel deleted ";
		}
	public boolean checkIfTravelExists(Integer id){
		
		return service.existsById(id);}
	public Long countTravels(){return service.count();}
	public String deleteTravelObject(Travel travel){service.delete(travel);
	return "travel deleted by object";}
	public String deleteAllTravels(){
		service.deleteAll();
		return " All travell deleted ";}

}
