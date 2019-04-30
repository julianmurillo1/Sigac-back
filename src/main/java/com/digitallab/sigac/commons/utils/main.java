package com.digitallab.sigac.commons.utils;

import com.digitallab.sigac.commons.enums.Genre;
import com.digitallab.sigac.commons.model.generic.DisabilityTypeDTO;
import com.digitallab.sigac.commons.model.generic.EthnicGroupDTO;
import com.digitallab.sigac.commons.model.generic.ExceptionalAbilityDTO;
import com.digitallab.sigac.commons.model.generic.MunicipalityDTO;
import com.digitallab.sigac.commons.model.request.InscriptionDTORequest;
import com.digitallab.sigac.commons.model.request.StudentDTORequest;
import com.digitallab.sigac.commons.utils.serializable.JSONUtil;

import java.util.Date;

public class main {

    public static void main(String[] args) {
        StudentDTORequest s = new StudentDTORequest();
        s.setBirthDate(new Date());
        s.setDisabilityType(new DisabilityTypeDTO());
        s.setDocumentNumber(1211L);
        s.setEmail("email");
        s.setEthnicGroup(new EthnicGroupDTO());
        s.setExceptionalAbility(new ExceptionalAbilityDTO());
        s.setFirstLastName("");
        s.setSecondName("");
        s.setFirstName("");
        s.setSecondLastName("");
        s.setGenre(Genre.MALE);
        s.setMunicipality(new MunicipalityDTO());


        System.out.println("JSON: " + JSONUtil.marshal(s));


        InscriptionDTORequest i = new InscriptionDTORequest();
        i.setAcademicSituation("");
        i.setCanceled(true);
        i.setInscriptionDate(new Date());
        i.setComments("");

    }
}
