package com.digitallab.sigac.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
 abstract class Person  {

    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    private String cc;
    private String code;
    private String phone;
    private String email;

}
