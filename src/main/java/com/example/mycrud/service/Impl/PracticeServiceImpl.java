package com.example.mycrud.service.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mycrud.model.Practice;
import com.example.mycrud.repository.PracticesRepository;
import com.example.mycrud.service.IPracticeService;


@Service
@Transactional
public class PracticeServiceImpl implements IPracticeService{
	
	private final Logger log = LoggerFactory.getLogger(PracticeServiceImpl.class);
	private final PracticesRepository practicesRepository;
	
	public PracticeServiceImpl(PracticesRepository practicesRepository) {
		this.practicesRepository = practicesRepository;
	}
	
	@Override
	public Practice save(Practice practice) {
		log.debug("Request to save Practice : {}", practice);
		return practicesRepository.save(practice);
	}
	
	@Override
	public Practice update(Practice practice) {
		log.debug("Request to update practice : {}", practice);
		return practicesRepository.save(practice);
	}
	
	@Override
    public Optional<Practice> partialUpdate(Practice practice) {
        log.debug("Request to partially update Practice : {}", practice);
        return practicesRepository
                .findById(practice.getId())
                .map(existingPractice -> {
                    if (practice.getLaboratorio() != null) {
                        existingPractice.setLaboratorio(practice.getLaboratorio());
                    }
                    if (practice.getHoraPlaneada() != null) {
                        existingPractice.setHoraPlaneada(practice.getHoraPlaneada());
                    }
                    if (practice.getHoraEjecutada() != null) {
                        existingPractice.setHoraEjecutada(practice.getHoraEjecutada());
                    }
                    if (practice.getAno() != null) {
                        existingPractice.setAno(practice.getAno());
                    }
                    if (practice.getEstado() != null) {
                        existingPractice.setEstado(practice.getEstado());
                    }

                    return existingPractice;
                })
                .map(practicesRepository::save);
    }

	@Override
	@Transactional(readOnly = true)
	public List<Practice> findAll() {
		// TODO Auto-generated method stub
		return practicesRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Practice> findOne(Long id){
		return practicesRepository.findById(id);
	}
	
	public void delete(Long id) {
		practicesRepository.deleteById(id);
	}

}
