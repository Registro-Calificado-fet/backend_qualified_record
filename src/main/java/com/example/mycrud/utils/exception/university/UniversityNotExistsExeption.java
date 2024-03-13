package com.example.mycrud.utils.exception.university;

public class UniversityNotExistsExeption extends RuntimeException {

    public UniversityNotExistsExeption(int id) {
        super(String.format("Error al eliminar universidad con id %s", id));
    }
}
