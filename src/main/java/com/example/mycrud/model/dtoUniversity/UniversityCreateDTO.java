package com.example.mycrud.model.dtoUniversity;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniversityCreateDTO {

    @NotBlank
    @Size(max = 255, min = 5)
    private String uniName;

    @NotNull
    private Integer uniIdentification;

    @NotNull
    private String uniCode;

    @NotBlank
    @Size(max = 255, min = 5)
    private String uniAddress;

    @NotNull
    private Date uniCreationDate;

    @NotBlank
    @Size(max = 255, min = 5)
    private String uniCreationUser;

}
