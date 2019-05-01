package com.digitallab.sigac.modelsVO;

import com.digitallab.sigac.commons.enums.Genre;
import com.digitallab.sigac.commons.enums.IdentityType;
import lombok.Data;


@Data
abstract class PersonVO {


    private Long documentNumber;
    private IdentityType idType;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private Genre genre;
    private String phone;
    private String email;
    private String birthDate;
    private Integer stratum;
    private Integer sisben;

}
