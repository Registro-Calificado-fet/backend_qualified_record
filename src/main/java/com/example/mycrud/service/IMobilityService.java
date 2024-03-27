/**
 * 
 */
package com.example.mycrud.service;

import java.util.List;
import java.util.Optional;

import com.example.mycrud.model.Mobility;

/**
 * 
 */
public interface IMobilityService {
	
	Mobility save(Mobility mobility);
	
	Mobility update(Mobility mobility);
	
	Optional<Mobility> partialUpdate(Mobility mobility);
	
	List<Mobility> findAll();
	
	Optional<Mobility> findOne(Long id);
	
	void delete(Long id);

}
