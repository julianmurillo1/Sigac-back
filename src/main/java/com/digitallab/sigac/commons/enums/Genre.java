package com.digitallab.sigac.commons.enums;

import lombok.Getter;

@Getter
public enum Genre {

    MALE(0, "Masculino"),
    FEMALE(1, "Femenino"),
    OTHER(2, "Otro");

    private final Integer code;
    private final String value;

    Genre(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

}
