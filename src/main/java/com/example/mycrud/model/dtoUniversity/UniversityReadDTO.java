package com.example.mycrud.model.dtoUniversity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniversityReadDTO {

    private Integer id;

    private String uniName;

    private Integer uniIdentification;

    private String uniCode;

    private String uniAddress;

    private Date uniCreationDate;

    private String uniCreationUser;
}
