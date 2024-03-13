package com.example.mycrud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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
        List<UniversityReadDTO> universityReadDTO = universityService.getUniversity();
        return ResponseEntity
                .ok(new ApiResponse<>("Universidades obtenidas con éxito", HttpStatus.OK, universityReadDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UniversityReadDTO>> getUniversityById(@PathVariable Integer id) {
        UniversityReadDTO universityReadDTO = universityService.getUniversityById(id);
        return ResponseEntity.ok(new ApiResponse<>("Universidad obtenida con éxito", HttpStatus.OK, universityReadDTO));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UniversityReadDTO>> createUniversity(
            @RequestBody @Valid UniversityCreateDTO universityCreateDTO) {
        UniversityReadDTO universityReadDTO = universityService.createUniversity(universityCreateDTO);
        return ResponseEntity.ok(new ApiResponse<>("Universidad creada con éxito", HttpStatus.OK, universityReadDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UniversityReadDTO>> updateUniversity(@PathVariable Integer id,
            @RequestBody UniversityUpdateDTO universityUpdateDTO) {
        UniversityReadDTO universityReadDTO = universityService.updateUniversity(id, universityUpdateDTO);
        return ResponseEntity
                .ok(new ApiResponse<>("Universidad actualizada con éxito", HttpStatus.OK, universityReadDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUniversity(@PathVariable Integer id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.ok(new ApiResponse<>("Universidad eliminada con éxito", HttpStatus.OK, null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<List<String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ValidationExceptionHandler.handleValidationExceptions(ex);
    }

}
