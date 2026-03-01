package com.ovinos.entity.superClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ovinos.DTO.BatchDTO;
import com.ovinos.entity.Batch;
import com.ovinos.entity.Enum.ConditionSheep;
import com.ovinos.entity.Enum.RaceSheep;
import com.ovinos.entity.Enum.SheepSex;
import com.ovinos.entity.Enum.SheepStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonPropertyOrder({
        "id",
        "sex",
        "raceSheep",
        "peso",
        "status",
        "conditionSheep",
        "dataNascimento",
        "batch"
})
@DiscriminatorColumn(name = "sexo")
public abstract class Sheep {

    @Id
    private String id;

    private String vid;
    private String eid;

    private Date dateInclusao;

    private Date dataNascimento;
    private Double peso;

    @Enumerated(EnumType.STRING)
    private SheepSex sex;

    @Enumerated(EnumType.STRING)
    private SheepStatus status;

    @Enumerated(EnumType.STRING)
    private ConditionSheep conditionSheep;

    @Enumerated(EnumType.STRING)
    private RaceSheep raceSheep;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    public Sheep(){}

    public Sheep(String id, Date dataNascimento, SheepStatus status, ConditionSheep conditionSheep, RaceSheep raceSheep,Double peso, Batch batch) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.peso = (Double) peso;
        this.batch = batch;
        this.status = status;
        this.conditionSheep = conditionSheep;
        this.raceSheep = raceSheep;

        if (batch != null){
            batch.addSheep(this);
        }
    }

    public SheepStatus getStatus() {
        return status;
    }

    public void setStatus(SheepStatus status) {
        this.status = status;
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

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public ConditionSheep getConditionSheep() {
        return conditionSheep;
    }

    public void setConditionSheep(ConditionSheep conditionSheep) {
        this.conditionSheep = conditionSheep;
    }

    public RaceSheep getRaceSheep() {
        return raceSheep;
    }

    public void setRaceSheep(RaceSheep raceSheep) {
        this.raceSheep = raceSheep;
    }


    @JsonIgnore
    public Batch getBatch() {
        return batch;
    }

    @JsonProperty("batch")
    public BatchDTO getBatchDTO() {
        if (batch==null){
            return null;
        } else {
            return new BatchDTO(batch);
        }

    }
}
