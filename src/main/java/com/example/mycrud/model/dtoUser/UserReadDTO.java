package com.example.mycrud.model.dtoUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReadDTO {

    private Integer id;
    private String fullName;
    private Integer idNumber;
    private String email;
    private String password;
}
