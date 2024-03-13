package com.example.mycrud.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mycrud.model.University;
import com.example.mycrud.model.dtoUniversity.UniversityCreateDTO;
import com.example.mycrud.model.dtoUniversity.UniversityReadDTO;
import com.example.mycrud.model.dtoUniversity.UniversityUpdateDTO;
import com.example.mycrud.repository.UniversityRepository;
import com.example.mycrud.service.IUniversityService;
import com.example.mycrud.utils.exception.university.UniversityNotCreateExeption;
import com.example.mycrud.utils.exception.university.UniversityNotExistsExeption;
import com.example.mycrud.utils.exception.university.UniversityNotFoundException;
import com.example.mycrud.utils.exception.university.UniversityNotUpdateExeption;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UniversityService implements IUniversityService {

    @Autowired
    private UniversityRepository universityRepository;
    private final ObjectMapper objectMapper;

    public UniversityService(UniversityRepository universityRepository, ObjectMapper objectMapper) {
        this.universityRepository = universityRepository;
        this.objectMapper = objectMapper;
    }

    private UniversityReadDTO convertToUniversityReadDTO(University university) {
        return objectMapper.convertValue(university, UniversityReadDTO.class);
    }

    @Override
    public UniversityReadDTO createUniversity(UniversityCreateDTO universityCreateDTO) {

        Optional<University> optionalUniversity = Optional
                .ofNullable(objectMapper.convertValue(universityCreateDTO, University.class));

        if (optionalUniversity.isPresent()) {

            University university = optionalUniversity.get();
            University savedUniversity = universityRepository.save(university);
            UniversityReadDTO universityReadDTO = convertToUniversityReadDTO(savedUniversity);

            return universityReadDTO;

        } else {
            throw new UniversityNotCreateExeption();
        }

    }

    @Override
    public void deleteUniversity(int id) {
        Optional<University> universityOptional = universityRepository.findById(id);
        if (universityOptional.isPresent()) {
            universityRepository.deleteById(id);
        } else {
            throw new UniversityNotExistsExeption(id);
        }
    }

    @Override
    public List<UniversityReadDTO> getUniversity() {
        List<UniversityReadDTO> universityDTOs = universityRepository.findAll().stream()
                .map(this::convertToUniversityReadDTO)
                .collect(Collectors.toList());
        if (universityDTOs.isEmpty()) {
            throw new UniversityNotFoundException(null);
        }
        return universityDTOs;
    }

    @Override
    public UniversityReadDTO getUniversityById(int id) {
        Optional<UniversityReadDTO> OptionalUniversityDTO = universityRepository.findById(id)
                .map(this::convertToUniversityReadDTO);

        if (OptionalUniversityDTO.isEmpty()) {
            throw new UniversityNotFoundException(id);
        }

        UniversityReadDTO universityDTO = OptionalUniversityDTO.get();

        return universityDTO;
    }

    @Override
    public UniversityReadDTO updateUniversity(int id, UniversityUpdateDTO universityUpdateDTO) {
        Optional<University> optionalUniversity = universityRepository.findById(id);

        if (optionalUniversity.isPresent()) {

            University university = optionalUniversity.get();

            university.setUniCode(universityUpdateDTO.getUniCode());
            university.setUniAddress(universityUpdateDTO.getUniAddress());
            university.setUniName(universityUpdateDTO.getUniName());

            University updatedUniversity = universityRepository.save(university);
            UniversityReadDTO universityReadDTO = convertToUniversityReadDTO(updatedUniversity);

            return universityReadDTO;
        } else {
            throw new UniversityNotUpdateExeption(id);
        }
    }
}
