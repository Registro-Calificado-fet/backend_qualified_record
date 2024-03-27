/**
 * 
 */
package com.example.mycrud.service.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mycrud.model.Mobility;
import com.example.mycrud.repository.MobilitiesRepository;
import com.example.mycrud.service.IMobilityService;

/**
 * 
 */
@Service
@Transactional
public class MobilityServiceImpl implements IMobilityService{
	
	private final Logger log = LoggerFactory.getLogger(MobilityServiceImpl.class);
	private final MobilitiesRepository mobilitiesRepository;
	
	public MobilityServiceImpl(MobilitiesRepository mobilityRepository) {
		this.mobilitiesRepository = mobilityRepository;
	}
	
	@Override
	public Mobility save(Mobility mobility) {
		log.debug("Request to save mobility : {}", mobility);
		return mobilitiesRepository.save(mobility);
	}
	
	@Override
	public Mobility update(Mobility mobility) {
		log.debug("Request to update mobility : {}", mobility);
		return mobilitiesRepository.save(mobility);
	}
	
	@Override
    public Optional<Mobility> partialUpdate(Mobility mobility) {
        log.debug("Request to partially update mobility : {}", mobility);
        return mobilitiesRepository
                .findById(mobility.getId())
                .map(existingMobility -> {
                    if (mobility.getYear() != null) {
                    	existingMobility.setYear(mobility.getYear());
                    }
                    if (mobility.getTypeOfMobility() != null) {
                    	existingMobility.setTypeOfMobility(mobility.getTypeOfMobility());
                    }
                    if (mobility.getCampus() != null) {
                    	existingMobility.setCampus(mobility.getCampus());
                    }
                    if (mobility.getMobilityLevel() != null) {
                    	existingMobility.setMobilityLevel(mobility.getMobilityLevel());
                    }
                    if (mobility.getMobilityGoal() != null) {
                    	existingMobility.setMobilityGoal(mobility.getMobilityGoal());
                    }
                    if (mobility.getNumberParticipants() != null) {
                    	existingMobility.setNumberParticipants(mobility.getNumberParticipants());
                    }
                    if (mobility.getDescription() != null) {
                    	existingMobility.setDescription(mobility.getDescription());
                    }
                    if (mobility.getRol() != null) {
                    	existingMobility.setRol(mobility.getRol());
                    }
                    if (mobility.getState() != null) {
                    	existingMobility.setState(mobility.getState());
                    }
                    return existingMobility;
                })
                .map(mobilitiesRepository::save);
    }

	@Override
	@Transactional(readOnly = true)
	public List<Mobility> findAll() {
		// TODO Auto-generated method stub
		return mobilitiesRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Mobility> findOne(Long id){
		return mobilitiesRepository.findById(id);
	}
	
	public void delete(Long id) {
		mobilitiesRepository.deleteById(id);
	}

}
