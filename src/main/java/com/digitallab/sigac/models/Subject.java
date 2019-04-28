package com.digitallab.sigac.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name ="sigac_subject")
public class Subject  extends EntityHeritage {

    public Subject(){

    }
}
