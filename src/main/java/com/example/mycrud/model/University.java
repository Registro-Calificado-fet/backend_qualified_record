package com.example.mycrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uniName;

    private Integer uniIdentification;

    private String uniCode;

    private String uniAddress;

    private Date uniCreationDate;

    private String uniCreationUser;

    public University() {
    }

    public University(String uniName, Integer uniIdentification) {
        this.uniName = uniName;
        this.uniIdentification = uniIdentification;
    }

    public University(Integer id, String uniName, Integer uniIdentification, String uniCode, String uniAddress,
            Date uniCreationDate, String uniCreationUser) {
        this.id = id;
        this.uniName = uniName;
        this.uniIdentification = uniIdentification;
        this.uniCode = uniCode;
        this.uniAddress = uniAddress;
        this.uniCreationDate = uniCreationDate;
        this.uniCreationUser = uniCreationUser;
    }

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
