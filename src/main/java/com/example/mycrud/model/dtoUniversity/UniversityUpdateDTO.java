package com.example.mycrud.model.dtoUniversity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniversityUpdateDTO {

    @NotBlank
    @Size(max = 255, min = 5)
    private String uniName;

    @NotNull
    private String uniCode;

    @NotBlank
    @Size(max = 255, min = 5)
    private String uniAddress;

}
