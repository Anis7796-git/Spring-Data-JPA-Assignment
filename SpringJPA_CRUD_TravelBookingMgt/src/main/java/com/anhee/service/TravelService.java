package com.anhee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anhee.entity.Travel;
import com.anhee.interfac.I_ITravelService;
import com.anhee.interfac.I_TravelRepository;

@Service
public class TravelService implements I_ITravelService {

			@Autowired
			private I_TravelRepository trrepo;
	@Override
	public void addTravel(Travel travel) {
		
		 trrepo.save(travel);

	}

	@Override
	public Iterable<Travel> getAllTravels() {
		
		return trrepo.findAll();
	}

	@Override
	public Optional<Travel> findTravelById(Integer id) {
		
		Optional<Travel> opt= trrepo.findById(id);
		if(opt.isPresent()) {
			opt.get();
		}
			return Optional.empty();
	
		
	}

	@Override
	public void deleteTravelById(Integer id) {
		trrepo.deleteById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		
		return trrepo.existsById(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return trrepo.count();
	}

	@Override
	public void delete(Travel travel) {
		trrepo.delete(travel);

	}

	@Override
	public void deleteAll() {
		trrepo.deleteAll();

	}

}
