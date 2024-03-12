package com.example.mycrud.service;

import java.util.List;
import java.util.Optional;

import com.example.mycrud.model.Practice;

public interface IPracticeService {
	
	Practice save(Practice practice);
	
	Practice update(Practice practice);
	
	Optional<Practice> partialUpdate(Practice practice);
	
	List<Practice> findAll();
	
	Optional<Practice> findOne(Long id);
	
	void delete(Long id);

}
