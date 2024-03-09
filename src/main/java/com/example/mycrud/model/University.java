package com.example.mycrud.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String uniName;

    @Column(name = "identification", nullable = false)
    private Integer uniIdentification;

    @Column(name = "code", nullable = false)
    private String uniCode;

    @Column(name = "address", nullable = false)
    private String uniAddress;

    @Column(name = "creation_date", nullable = false)
    private Date uniCreationDate;

    @Column(name = "creation_user", nullable = false)
    private String uniCreationUser;

}
