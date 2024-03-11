package com.example.mycrud.model.dto;

import jakarta.validation.constraints.*;

public class UserCreateDTO {
    @NotBlank
    @Size(max = 255, min = 5)
    private String fullName;
    @NotNull
    private Integer idNumber;
    @Email
    private String email;

    @NotBlank
    @Size(max = 255, min = 5)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }
}
