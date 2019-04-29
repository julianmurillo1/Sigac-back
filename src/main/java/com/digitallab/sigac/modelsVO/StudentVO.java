package com.digitallab.sigac.modelsVO;

import com.digitallab.sigac.commons.enums.IdentityType;
import com.digitallab.sigac.models.Program;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
public class StudentVO extends  PersonVO  {

    private Program program;
    private String fatherName;
    private IdentityType fatherIdType;
    private Integer fatherDocument;
    private String motherName;
    private IdentityType motherIdType;
    private Integer motherDocument;
    private Integer brothers;

    public StudentVO(){

    }
}
