package com.digitallab.sigac.models;

import com.digitallab.sigac.commons.enums.IdentityType;
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
    private String fatherName;
    @Enumerated(EnumType.ORDINAL)
    private IdentityType fatherIdType;
    private Integer fatherDocument;
    private String motherName;
    @Enumerated(EnumType.ORDINAL)
    private IdentityType motherIdType;
    private Integer motherDocument;
    private Integer brothers;

    public Student(){

    }

}
