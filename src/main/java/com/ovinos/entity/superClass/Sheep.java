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
import com.ovinos.entity.auxiliarData.*;
import com.ovinos.service.exception.SheepException;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonPropertyOrder({
        "id",
        "sex",
        "dataNascimento",
        "characteristics",
        "batch",
        "weight",
        "notes"

})
@DiscriminatorColumn(name = "sexo")
public abstract class Sheep {

    @Id
    private String id;

    //private String vid;
    //private String eid;

    //private Date dateInclusao;

    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private SheepSex sex;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weight_id")
    private Weight weight;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "characteristics_id")
    private Characteristics characteristics;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notes_id")
    private Notes notes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    public Sheep(){}

    public Sheep(String id, Date dataNascimento){
        this.id = id;
        this.dataNascimento = dataNascimento;
    }

    public Sheep(String id,Date dataNascimento, Batch batch) {

        this.id = id;
        this.dataNascimento = dataNascimento;
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
        this.characteristics = new Characteristics(status, conditionSheep, raceSheep);

        if (batch != null){
            batch.addSheep(this);
        }
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics( Characteristics characteristics) {
        if (!characteristics.getConditionSheep().canBe(sex)) {
            throw new SheepException("Condição inválida para o sexo informado");
        }

        this.characteristics = new Characteristics(characteristics.getStatus(), characteristics.getConditionSheep(), characteristics.getRaceSheep());
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

    public void setTreatmentCompleted(Treatment treatment) {
        this.treatment = null;
    }

    public SheepSex getSex() {
        return sex;
    }

    public void setSex(SheepSex sex) {
        this.sex = sex;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @JsonIgnore
    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
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
