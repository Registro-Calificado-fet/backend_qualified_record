package com.example.mycrud.model.dtoUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {

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
}
