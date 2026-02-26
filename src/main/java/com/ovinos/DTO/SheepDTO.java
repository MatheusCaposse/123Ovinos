package com.ovinos.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ovinos.entity.Batch;
import com.ovinos.entity.Enum.SheepSex;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;
@JsonPropertyOrder({
        "id",
        "sex",
        "peso",
        "dataNascimento"
})
public class SheepDTO {

    private String id;

    private Date dataNascimento;
    private Double peso;
    private SheepSex sex;

    public SheepDTO(){}

    public SheepDTO(Sheep sheep) {
        this.id = sheep.getId();
        this.dataNascimento = sheep.getDataNascimento();
        this.peso = sheep.getPeso();
        this.sex = sheep.getSex();
    }

    public SheepSex getSex() {
        return sex;
    }

    public void setSex(SheepSex sex) {
        this.sex = sex;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
