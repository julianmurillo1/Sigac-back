package com.digitallab.sigac.models;

import com.digitallab.sigac.commons.enums.Genre;
import com.digitallab.sigac.commons.enums.IdentityType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name ="sigac_person")
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
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String phone;
    @Column(unique = true)
    private String email;

}
