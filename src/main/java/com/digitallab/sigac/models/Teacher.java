package com.digitallab.sigac.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "sigac_teacher")
public class Teacher extends Person  {

   @ManyToOne
   @JoinColumn(name = "idGroup")
   private Group group;

    public Teacher(){

    }

}
