package com.example.mycrud.service;

import java.util.List;

import com.example.mycrud.model.dtoUniversity.UniversityCreateDTO;
import com.example.mycrud.model.dtoUniversity.UniversityReadDTO;
import com.example.mycrud.model.dtoUniversity.UniversityUpdateDTO;

public interface IUniversityService {

    List<UniversityReadDTO> getUniversity();

    UniversityReadDTO getUniversityById(int id);

    UniversityReadDTO createUniversity(UniversityCreateDTO universityCreateDTO);

    UniversityReadDTO updateUniversity(int id, UniversityUpdateDTO universityUpdateDTO);

    void deleteUniversity(int id);
}
