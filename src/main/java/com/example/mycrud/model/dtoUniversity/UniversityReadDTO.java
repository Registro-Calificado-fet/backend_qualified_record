package com.example.mycrud.model.dtoUniversity;

import java.util.Date;

public class UniversityReadDTO {

    private Integer id;

    private String uniName;

    private Integer uniIdentification;

    private String uniCode;

    private String uniAddress;

    private Date uniCreationDate;

    private String uniCreationUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
