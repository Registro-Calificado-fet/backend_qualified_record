package com.example.mycrud.utils.exception.university;

public class UniversityNotCreateExeption extends RuntimeException {

    public UniversityNotCreateExeption() {
        super(String.format("Error al crear universidad"));
    }
}
