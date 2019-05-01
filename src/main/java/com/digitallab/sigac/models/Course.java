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

    public Course(){

    }
}
