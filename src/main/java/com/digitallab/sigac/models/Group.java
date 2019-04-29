package com.digitallab.sigac.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name ="sigac_group")
public class Group {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;

}
