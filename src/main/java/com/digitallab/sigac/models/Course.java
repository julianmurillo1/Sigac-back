package com.digitallab.sigac.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "sigac_course")
public class Course extends EntityHeritage{

    private String grade;
    private String gradeNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher idTeacher;

    public Course(){

    }
}
