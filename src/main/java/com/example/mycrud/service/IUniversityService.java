package com.example.mycrud.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.mycrud.model.dtoUniversity.UniversityCreateDTO;
import com.example.mycrud.model.dtoUniversity.UniversityReadDTO;
import com.example.mycrud.model.dtoUniversity.UniversityUpdateDTO;
import com.example.mycrud.utils.ApiResponse;

public interface IUniversityService {

    ResponseEntity<ApiResponse<List<UniversityReadDTO>>> getUniversity();

    ResponseEntity<ApiResponse<UniversityReadDTO>> getUniversityById(Integer id);

    ResponseEntity<ApiResponse<UniversityReadDTO>> createUniversity(UniversityCreateDTO universityCreateDTO);

    ResponseEntity<ApiResponse<UniversityReadDTO>> updateUniversity(Integer id,
            UniversityUpdateDTO universityUpdateDTO);

    ResponseEntity<ApiResponse<Void>> deleteUniversity(Integer id);
}
