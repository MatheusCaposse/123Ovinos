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

    private Date dataNascimento;
    private Double peso;
    @ManyToOne
    private Batch batch;

    @Enumerated(EnumType.STRING)
    private SheepSex sex;

    private SheepStatus lastStatus;

    @Enumerated(EnumType.STRING)
    private SheepStatus status = SheepStatus.MORTO;

    public Deads(){}

    public Deads(Sheep sheep) {
        this.id = sheep.getId();
        this.dataNascimento = sheep.getDataNascimento();
        this.peso = sheep.getWeight().getCurrentWeight();
        this.batch = sheep.getBatch();

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
