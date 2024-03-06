package com.example.mycrud.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.mycrud.model.University;
import com.example.mycrud.model.dtoUniversity.UniversityCreateDTO;
import com.example.mycrud.model.dtoUniversity.UniversityReadDTO;
import com.example.mycrud.model.dtoUniversity.UniversityUpdateDTO;
import com.example.mycrud.repository.UniversityRepository;
import com.example.mycrud.repository.UserRepository;
import com.example.mycrud.service.IUniversityService;
import com.example.mycrud.utils.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UniversityService implements IUniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    public Optional<University> findUniversityById(Integer id) {
        return universityRepository.findById(id);
    }

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public UniversityService(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<ApiResponse<UniversityReadDTO>> createUniversity(UniversityCreateDTO universityCreateDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> deleteUniversity(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<List<UniversityReadDTO>>> getUniversity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<UniversityReadDTO>> getUniversityById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<UniversityReadDTO>> updateUniversity(Integer id,
            UniversityUpdateDTO universityUpdateDTO) {
        // TODO Auto-generated method stub
        return null;
    }

}
