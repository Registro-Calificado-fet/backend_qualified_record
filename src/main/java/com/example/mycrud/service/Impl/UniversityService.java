package com.example.mycrud.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.mycrud.model.University;
import com.example.mycrud.model.dtoUniversity.UniversityCreateDTO;
import com.example.mycrud.model.dtoUniversity.UniversityReadDTO;
import com.example.mycrud.model.dtoUniversity.UniversityUpdateDTO;
import com.example.mycrud.repository.UniversityRepository;
import com.example.mycrud.service.IUniversityService;
import com.example.mycrud.utils.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UniversityService implements IUniversityService {

    @Autowired
    private UniversityRepository universityRepository;
    private final ObjectMapper objectMapper;

    public Optional<University> findUniversityById(Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        return universityRepository.findById(id);
    }

    public UniversityService(UniversityRepository universityRepository, ObjectMapper objectMapper) {
        this.universityRepository = universityRepository;
        this.objectMapper = objectMapper;
    }

    private UniversityReadDTO convertToUniversityReadDTO(University university) {
        return objectMapper.convertValue(university, UniversityReadDTO.class);
    }

    @Override
    public ResponseEntity<ApiResponse<UniversityReadDTO>> createUniversity(UniversityCreateDTO universityCreateDTO) {
        try {
            University university = objectMapper.convertValue(universityCreateDTO, University.class);
            if (university.getId() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ApiResponse<>("El ID de la universidad no puede ser nulo", HttpStatus.BAD_REQUEST,
                                null));
            }
            University savedUniversity = universityRepository.save(university);
            UniversityReadDTO universityReadDTO = convertToUniversityReadDTO(savedUniversity);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>("Universidad creada con éxito", HttpStatus.CREATED, universityReadDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>("Error al crear la universidad", HttpStatus.INTERNAL_SERVER_ERROR, null));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> deleteUniversity(Integer id) {
        try {
            if (id == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ApiResponse<>("El ID de la universidad no puede ser nulo", HttpStatus.BAD_REQUEST,
                                null));
            }

            University university = universityRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Universidad no encontrada"));
            universityRepository.delete(university);
            return ResponseEntity.ok(new ApiResponse<>("Universidad eliminada con éxito", HttpStatus.OK, null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>("Error al eliminar la universidad", HttpStatus.INTERNAL_SERVER_ERROR,
                            null));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<List<UniversityReadDTO>>> getUniversity() {
        try {
            List<UniversityReadDTO> universityDTOs = universityRepository.findAll().stream()
                    .map(this::convertToUniversityReadDTO)
                    .collect(Collectors.toList());
            return ResponseEntity
                    .ok(new ApiResponse<>("Universidades obtenidas con éxito", HttpStatus.OK, universityDTOs));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>("Error al obtener las universidades", HttpStatus.INTERNAL_SERVER_ERROR,
                            null));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<UniversityReadDTO>> getUniversityById(Integer id) {
        try {

            if (id == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ApiResponse<>("El ID de la universidad no puede ser nulo", HttpStatus.BAD_REQUEST,
                                null));
            }

            UniversityReadDTO universityDTO = universityRepository.findById(id)
                    .map(this::convertToUniversityReadDTO)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Universidad no encontrada"));
            return ResponseEntity
                    .ok(new ApiResponse<>("Universidad encontrada con éxito", HttpStatus.OK, universityDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>("Error al obtener la universidad por ID", HttpStatus.INTERNAL_SERVER_ERROR,
                            null));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<UniversityReadDTO>> updateUniversity(Integer id,
            UniversityUpdateDTO universityUpdateDTO) {
        try {

            if (id == null) {
                return ResponseEntity.badRequest()
                        .body(new ApiResponse<>("ID no puede ser nulo", HttpStatus.BAD_REQUEST, null));
            }

            University university = universityRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Universidad no encontrada"));

            objectMapper.readerForUpdating(university).readValue(objectMapper.writeValueAsString(universityUpdateDTO));

            University updatedUniversity = universityRepository.save(university);
            UniversityReadDTO universityReadDTO = convertToUniversityReadDTO(updatedUniversity);
            return ResponseEntity
                    .ok(new ApiResponse<>("Universidad actualizada con éxito", HttpStatus.OK, universityReadDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>("Error al actualizar la universidad", HttpStatus.INTERNAL_SERVER_ERROR,
                            null));
        }
    }

}
