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
    private int id;
    @Column(unique = true, nullable = false)
    private Long documentNumber;
    @Enumerated(EnumType.ORDINAL)
    private IdentityType idType;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date birthDate;
    @Enumerated(EnumType.ORDINAL)
    private Genre genre;
    private String phone;
    @Column(unique = true)
    private String email;
   private Integer stratum;
   private String sisben;


}
