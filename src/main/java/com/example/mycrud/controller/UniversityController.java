package com.example.mycrud.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mycrud.model.dtoUniversity.UniversityCreateDTO;
import com.example.mycrud.model.dtoUniversity.UniversityReadDTO;
import com.example.mycrud.model.dtoUniversity.UniversityUpdateDTO;
import com.example.mycrud.service.IUniversityService;
import com.example.mycrud.utils.ApiResponse;
import com.example.mycrud.utils.ValidationExceptionHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/university")
public class UniversityController {

    private final IUniversityService universityService;

    public UniversityController(IUniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UniversityReadDTO>>> getUniversity() {
        return universityService.getUniversity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UniversityReadDTO>> getUniversityById(@PathVariable Integer id) {
        return universityService.getUniversityById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UniversityReadDTO>> createUniversity(
            @RequestBody @Valid UniversityCreateDTO universityCreateDTO) {
        return universityService.createUniversity(universityCreateDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UniversityReadDTO>> updateUniversity(@PathVariable Integer id,
            @RequestBody UniversityUpdateDTO universityUpdateDTO) {
        return universityService.updateUniversity(id, universityUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUniversity(@PathVariable Integer id) {
        return universityService.deleteUniversity(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<List<String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ValidationExceptionHandler.handleValidationExceptions(ex);
    }

}
