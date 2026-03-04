package com.ovinos.DTO;

import com.ovinos.entity.Enum.TypeBirth;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class PregnancyDTO {
    @Enumerated(EnumType.STRING)
    private TypeBirth typeBirth;

    private String idPai;

    public PregnancyDTO(TypeBirth typeBirth, String idPai) {
        this.typeBirth = typeBirth;
        this.idPai = idPai;
    }

    public PregnancyDTO(){}

    public TypeBirth getTypeBirth() {
        return typeBirth;
    }

    public void setTypeBirth(TypeBirth typeBirth) {
        this.typeBirth = typeBirth;
    }

    public String getIdPai() {
        return idPai;
    }

    public void setIdPai(String idPai) {
        this.idPai = idPai;
    }
}
