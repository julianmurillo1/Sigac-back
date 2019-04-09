package com.digitallab.sigac.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
abstract class EntityHeritage {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
}
