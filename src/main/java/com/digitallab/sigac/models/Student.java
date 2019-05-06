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
    @Column(nullable = false)
    private String fatherName;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private IdentityType fatherIdType;
    @Column(nullable = false)
    private Integer fatherDocument;
    @Column(nullable = false)
    private String motherName;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private IdentityType motherIdType;
    @Column(nullable = false)
    private Integer motherDocument;
    private Integer brothers;

    public Student(){

    }

}
