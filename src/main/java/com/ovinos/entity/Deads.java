package com.ovinos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ovinos.entity.Enum.*;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@JsonPropertyOrder({
        "id",
        "sex",
        "peso",
        "status",
        "dataNascimento"
})
public class Deads {

    @Id
    private String id;

    private String nota;

    private SheepSex sex;

    private Date dataNascimento;

    public Deads(){}

    public Deads(Sheep sheep, String nota) {
        this.id = sheep.getId();
        this.sex = sheep.getSex();
        this.dataNascimento = sheep.getDataNascimento();
        this.nota = nota;
    }

    public String getId() {
        return id;
    }

    public String getNota() {
        return nota;
    }

    public SheepSex getSex() {
        return sex;
    }

    public void setSex(SheepSex sex) {
        this.sex = sex;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
