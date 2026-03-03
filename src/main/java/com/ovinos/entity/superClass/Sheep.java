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
import com.ovinos.entity.auxiliarData.Characteristics;
import com.ovinos.entity.auxiliarData.Treatment;
import com.ovinos.entity.auxiliarData.Weight;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonPropertyOrder({
        "id",
        "characteristics",
        "weight",
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

    @Embedded
    private Weight weight;

    @Embedded
    private Characteristics characteristics;

    @Embedded
    private Treatment treatment;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    public Sheep(){}

    public Sheep(String id, Date dataNascimento){
        this.id = id;
        this.dataNascimento = dataNascimento;
    }

    public Sheep(String id, SheepSex sex, Date dataNascimento, Double peso, Batch batch) {

        this.id = id;
        this.dataNascimento = dataNascimento;
        this.weight = new Weight(peso, 7.0);
        this.batch = batch;

        if (batch != null){
            batch.addSheep(this);
        }
    }

    public Sheep(String id, SheepSex sex, Date dataNascimento, SheepStatus status, ConditionSheep conditionSheep, RaceSheep raceSheep, Double peso, Batch batch) {

        this.id = id;
        this.dataNascimento = dataNascimento;
        this.weight = new Weight(peso, 7.0);
        this.batch = batch;
        this.characteristics = new Characteristics(sex, status, conditionSheep, raceSheep);

        if (batch != null){
            batch.addSheep(this);
        }
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(SheepSex sex, SheepStatus status, ConditionSheep conditionSheep, RaceSheep raceSheep) {
        this.characteristics = new Characteristics(sex,status, conditionSheep, raceSheep);
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
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

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(String desc, String medic, String dosagem) {
        this.treatment = new Treatment(desc, medic, dosagem, new Date());
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
