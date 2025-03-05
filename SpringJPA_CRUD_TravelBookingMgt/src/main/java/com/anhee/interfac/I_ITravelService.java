package com.anhee.interfac;

import java.util.Optional;

import com.anhee.entity.Travel;

public interface I_ITravelService {
	void addTravel(Travel travel);
	Iterable<Travel> getAllTravels();
	Optional<Travel> findTravelById(Integer id);
	void deleteTravelById(Integer id);
	boolean existsById(Integer id);
	Long count();
	void delete(Travel travel);
	void deleteAll();
}
