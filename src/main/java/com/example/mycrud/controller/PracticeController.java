/**
 * 
 */
package com.example.mycrud.controller;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mycrud.model.Practice;
import com.example.mycrud.repository.PracticesRepository;
import com.example.mycrud.service.IPracticeService;

/**
 * 
 */

@RestController
@RequestMapping(path = "api/v1/practice")
public class PracticeController {

	private final Logger log = LoggerFactory.getLogger(PracticeController.class);
	private final IPracticeService practiceService;
	@Autowired
	private final PracticesRepository practicesrepository;
	private static final String ENTITY_NAME = "practices";

	public PracticeController(IPracticeService practiceService, PracticesRepository practicesrepository) {
		this.practiceService = practiceService;
		this.practicesrepository = practicesrepository;

	}

	@GetMapping("")
	public List<Practice> getPractices() {
		return practiceService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Practice> getPractice(@PathVariable Long id) {
		return practiceService.findOne(id);
	}

	@PostMapping("")
	public ResponseEntity<Practice> createPractice(@RequestBody Practice practice) throws BadRequestException {
		log.debug("REST request to save Country : {}", practice);
		if (practice.getId() != null) {
			throw new BadRequestException(ENTITY_NAME, null);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(practiceService.save(practice));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Practice> updatePractice(@PathVariable(value = "id", required = false) final Long id,
			@RequestBody Practice practice) throws BadRequestException {
		log.debug("REST request to update Practice : {}, {}", id, practice);
		if (practice.getId() == null) {
			throw new BadRequestException(ENTITY_NAME, null);
		}
		if (!Objects.equals(id, practice.getId())) {
			throw new BadRequestException(ENTITY_NAME, null);
		}

		if (!practicesrepository.existsById(id)) {
			throw new BadRequestException(ENTITY_NAME, null);
		}

		return ResponseEntity.ok().body(practiceService.update(practice));
	}

	@PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
	public ResponseEntity<Optional<Practice>> partialUpdatePractice(
			@PathVariable(value = "id", required = false) final Long id, @RequestBody Practice practice)
			throws BadRequestException {
		log.debug("REST request to partial update Country partially : {}, {}", id, practice);
		if (practice.getId() == null) {
			throw new BadRequestException(ENTITY_NAME, null);
		}
		if (!Objects.equals(id, practice.getId())) {
			throw new BadRequestException(ENTITY_NAME, null);
		}

		if (!practicesrepository.existsById(id)) {
			throw new BadRequestException(ENTITY_NAME, null);
		}

		Optional<Practice> result = practiceService.partialUpdate(practice);

		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCountry(@PathVariable("id") Long id) {
		log.debug("REST request to delete Country : {}", id);
		practiceService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
