package com.digitallab.sigac.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name ="sigac_program")
public class Program extends EntityHeritage  {

    @OneToMany(mappedBy="program", cascade = CascadeType.ALL)
    private Set<Student> students;

    public Program(){

    }
}
