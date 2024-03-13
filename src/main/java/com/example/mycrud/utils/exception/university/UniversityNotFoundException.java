package com.example.mycrud.utils.exception.university;

public class UniversityNotFoundException extends RuntimeException {

    public UniversityNotFoundException(Integer id) {
        super(id != null ? String.format("Error al listar universidades")
                : String.format("Error al buscar universidad con id %s", id));
    }
}
