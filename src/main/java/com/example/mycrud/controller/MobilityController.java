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

import com.example.mycrud.model.Mobility;
import com.example.mycrud.repository.MobilitiesRepository;
import com.example.mycrud.service.IMobilityService;

@RestController
@RequestMapping(path = "api/v1/mobility")
public class MobilityController {
	
	private final Logger log = LoggerFactory.getLogger(PracticeController.class);
	private final IMobilityService mobilityService;
	@Autowired
	private final MobilitiesRepository mobilitiesRepository;
	private static final String ENTITY_NAME = "mobility";

	public MobilityController(IMobilityService mobilityService, MobilitiesRepository mobilitiesRepository) {
		this.mobilityService = mobilityService;
		this.mobilitiesRepository = mobilitiesRepository;

	}
	
	@GetMapping("")
	public List<Mobility> getMobilities() {
		return mobilityService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Mobility> getPractice(@PathVariable Long id) {
		return mobilityService.findOne(id);
	}

	@PostMapping("")
	public ResponseEntity<Mobility> createMobility(@RequestBody Mobility mobility) throws BadRequestException {
		log.debug("REST request to save Mobility : {}", mobility);
		if (mobility.getId() != null) {
			throw new BadRequestException(ENTITY_NAME, null);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(mobilityService.save(mobility));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Mobility> updateMobility(@PathVariable(value = "id", required = false) final Long id,
			@RequestBody Mobility mobility) throws BadRequestException {
		log.debug("REST request to update Mobility : {}, {}", id, mobility);
		if (mobility.getId() == null) {
			throw new BadRequestException(ENTITY_NAME, null);
		}
		if (!Objects.equals(id, mobility.getId())) {
			throw new BadRequestException(ENTITY_NAME, null);
		}

		if (!mobilitiesRepository.existsById(id)) {
			throw new BadRequestException(ENTITY_NAME, null);
		}

		return ResponseEntity.ok().body(mobilityService.update(mobility));
	}

	@PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
	public ResponseEntity<Optional<Mobility>> partialUpdateMobility(
			@PathVariable(value = "id", required = false) final Long id, @RequestBody Mobility mobility)
			throws BadRequestException {
		log.debug("REST request to partial update Mobility partially : {}, {}", id, mobility);
		if (mobility.getId() == null) {
			throw new BadRequestException(ENTITY_NAME, null);
		}
		if (!Objects.equals(id, mobility.getId())) {
			throw new BadRequestException(ENTITY_NAME, null);
		}

		if (!mobilitiesRepository.existsById(id)) {
			throw new BadRequestException(ENTITY_NAME, null);
		}

		Optional<Mobility> result = mobilityService.partialUpdate(mobility);

		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMobility(@PathVariable("id") Long id) {
		log.debug("REST request to delete Country : {}", id);
		mobilityService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
