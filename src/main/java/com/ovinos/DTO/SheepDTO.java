package com.ovinos.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ovinos.entity.Batch;
import com.ovinos.entity.Enum.SheepSex;
import com.ovinos.entity.Enum.SheepStatus;
import com.ovinos.entity.data.Characteristics;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.util.Date;
@JsonPropertyOrder({
        "id",
        "sex",
        "raceSheep",
        "peso",
        "status",
        "conditionSheep",
        "dataNascimento"
})
public class SheepDTO {

    private String id;

    private Date dataNascimento;
    private Double peso;

    private Characteristics characteristics;

    public SheepDTO(){}

    public SheepDTO(Sheep sheep) {
        this.id = sheep.getId();
        this.dataNascimento = sheep.getDataNascimento();
        this.peso = sheep.getPeso();
        this.characteristics = sheep.getCharacteristics();
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Characteristics characteristics) {
        this.characteristics = characteristics;
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
