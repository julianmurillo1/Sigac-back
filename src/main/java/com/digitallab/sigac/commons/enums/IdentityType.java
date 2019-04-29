package com.digitallab.sigac.commons.enums;

import lombok.Getter;

@Getter
public enum IdentityType {

    CC(0, "Cédula de Ciudadanía."),
    TI(1, "Tarjeta de Identitdad."),
    RC(2, "Registro Civil");

    private final Integer code;
    private final String value;

    IdentityType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
