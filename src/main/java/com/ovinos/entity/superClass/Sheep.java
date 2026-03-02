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
import com.ovinos.entity.data.Characteristics;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonPropertyOrder({
        "id",
        "characteristics",
        "peso",
        "dataNascimento",
        "batch"
})
@DiscriminatorColumn(name = "sexo")
public abstract class Sheep {

    @Id
    private String id;

    //private String vid;
    //private String eid;

    //private Date dateInclusao;

    private Date dataNascimento;
    private Double peso;

    @Embedded
    private Characteristics characteristics = new Characteristics();

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    public Sheep(){}

    public Sheep(String id, Date dataNascimento, SheepStatus status, ConditionSheep conditionSheep, RaceSheep raceSheep,Double peso, Batch batch) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.peso = (Double) peso;
        this.batch = batch;
        characteristics.setStatus(status);
        characteristics.setConditionSheep(conditionSheep);
        characteristics.setRaceSheep(raceSheep);

        if (batch != null){
            batch.addSheep(this);
        }
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

    public void setBatch(Batch batch) {
        this.batch = batch;
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
