package com.example.mycrud.model.dtoUniversity;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

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

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public Integer getUniIdentification() {
        return uniIdentification;
    }

    public void setUniIdentification(Integer uniIdentification) {
        this.uniIdentification = uniIdentification;
    }

    public String getUniCode() {
        return uniCode;
    }

    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    public String getUniAddress() {
        return uniAddress;
    }

    public void setUniAddress(String uniAddress) {
        this.uniAddress = uniAddress;
    }

    public Date getUniCreationDate() {
        return uniCreationDate;
    }

    public void setUniCreationDate(Date uniCreationDate) {
        this.uniCreationDate = uniCreationDate;
    }

    public String getUniCreationUser() {
        return uniCreationUser;
    }

    public void setUniCreationUser(String uniCreationUser) {
        this.uniCreationUser = uniCreationUser;
    }

}
