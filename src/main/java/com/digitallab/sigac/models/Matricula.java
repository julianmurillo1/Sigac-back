package com.digitallab.sigac.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sigac_matricula")
public class Matricula {
    @Id
    @GeneratedValue
    private int idMatricula;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student idStudent;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course idCourse;

    public Matricula(){

    }

}
