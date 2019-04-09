package com.digitallab.sigac.modelsVO;

import lombok.Data;

@Data
abstract class PersonVO {

    private String fullName;
    private String cc;
    private String code;
    private String phone;
    private String email;

}
