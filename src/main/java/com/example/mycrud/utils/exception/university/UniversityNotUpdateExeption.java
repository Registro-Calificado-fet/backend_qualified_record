package com.example.mycrud.utils.exception.university;

public class UniversityNotUpdateExeption extends RuntimeException {

    public UniversityNotUpdateExeption(int id) {
        super(String.format("Error al actualizar universidad con id %s", id));
    }

}
