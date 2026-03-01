package com.ovinos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ovinos.DTO.SheepDTO;
import com.ovinos.entity.Enum.BatchType;
import com.ovinos.entity.Enum.ConditionSheep;
import com.ovinos.entity.Enum.SheepSex;
import com.ovinos.entity.Enum.SheepStatus;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private Date dataNascimento;
    private Double peso;
    @ManyToOne
    private Batch batch;

    @Enumerated(EnumType.STRING)
    private SheepSex sex;

    private SheepStatus lastStatus;

    @Enumerated(EnumType.STRING)
    private SheepStatus status = SheepStatus.MORTO;

    private ConditionSheep lastConditional;

    public Deads(){}

    public Deads(Sheep sheep) {
        this.id = sheep.getId();
        this.dataNascimento = sheep.getDataNascimento();
        this.peso = sheep.getPeso();
        this.sex = sheep.getSex();
        this.lastStatus = sheep.getStatus();
        this.batch = sheep.getBatch();
        this.lastConditional = sheep.getConditionSheep();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public SheepSex getSex() {
        return sex;
    }

    public void setSex(SheepSex sex) {
        this.sex = sex;
    }

    public SheepStatus getStatus() {
        return status;
    }

    public void setStatus(SheepStatus status) {
        this.status = status;
    }

    public ConditionSheep getLastConditional() {
        return lastConditional;
    }

    public void setLastConditional(ConditionSheep lastConditional) {
        this.lastConditional = lastConditional;
    }

    @JsonIgnore
    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public SheepStatus getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(SheepStatus lastStatus) {
        this.lastStatus = lastStatus;
    }
}
