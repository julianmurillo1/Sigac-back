package com.digitallab.sigac.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name ="sigac_group")
public class Group {

    @Id
    @GeneratedValue
    private int id;
    public Group(){

    }

}
