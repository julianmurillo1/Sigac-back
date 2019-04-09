package com.digitallab.sigac.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "sigac_teacher")
public class Teacher extends Person  {



    public Teacher(){

    }

}
