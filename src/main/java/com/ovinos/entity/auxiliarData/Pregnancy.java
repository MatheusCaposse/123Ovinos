package com.ovinos.entity.auxiliarData;

import com.ovinos.entity.Enum.TypeBirth;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.lang.reflect.Type;

@Embeddable
public class Pregnancy {

    @Enumerated(EnumType.STRING)
    private TypeBirth typeBirth;

    private String idPai;

    public Pregnancy(TypeBirth typeBirth, String idPai) {
        this.typeBirth = typeBirth;
        this.idPai = idPai;
    }

    public Pregnancy(){}

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
