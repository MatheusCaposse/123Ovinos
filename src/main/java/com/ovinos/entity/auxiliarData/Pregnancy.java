package com.ovinos.entity.auxiliarData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ovinos.entity.Enum.TypeBirth;
import com.ovinos.entity.Female;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.lang.reflect.Type;

@Entity
public class Pregnancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "pregnancy")
    private Female female;

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

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public Female getFemale() {
        return female;
    }
}
