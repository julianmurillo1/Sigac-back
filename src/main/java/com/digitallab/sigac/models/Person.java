package com.digitallab.sigac.models;

import com.digitallab.sigac.commons.enums.Genre;
import com.digitallab.sigac.commons.enums.IdentityType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@MappedSuperclass
 abstract class Person   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private Long documentNumber;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private IdentityType idType;
    @Column(nullable = false)
    private String firstName;
    private String secondName;
   @Column(nullable = false)
    private String firstLastName;
    private String secondLastName;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column(nullable = false)
    private Date birthDate;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Genre genre;
    private String phone;
    @Column(unique = true, nullable = false)
    private String email;
    private Integer stratum;
    private Integer sisben;


}
