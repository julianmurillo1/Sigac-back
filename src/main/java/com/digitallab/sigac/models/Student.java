package com.digitallab.sigac.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "sigac_student")
public class Student extends Person {


    @ManyToOne
    @JoinColumn(name = "idProgram")
    private Program program;

    public Student(){

    }

}
