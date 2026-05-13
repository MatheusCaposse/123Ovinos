package com.ovinos.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ovinos.entity.Batch;
import com.ovinos.entity.Enum.SheepSex;
import com.ovinos.entity.Female;
import com.ovinos.entity.auxiliarData.*;
import com.ovinos.entity.superClass.Sheep;

import java.time.LocalDate;
import java.util.Date;

public class UpdateSheepDTO {


    private String id;

    private SheepSex sex;

    private Date dataNascimento;

    private Batch batch;

    private Characteristics characteristics;

    private Weight weight;

    private Notes notes;

    private Kinship kinship;

    private Treatment treatment;

    private Pregnancy pregnancy;

    public UpdateSheepDTO(){}

    public UpdateSheepDTO(Sheep obj){
        this.id = obj.getId();
        this.sex = obj.getSex();
        this.dataNascimento = obj.getDataNascimento();
        this.batch = obj.getBatch();
        this.characteristics = obj.getCharacteristics();
        this.weight = obj.getWeight();
        this.notes = obj.getNotes();
        this.kinship = obj.getKinship();
        this.treatment = obj.getTreatment();
        if(obj instanceof Female){
            Female femaleobj = (Female) obj;
            this.pregnancy = femaleobj.getPregnancy();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SheepSex getSex() {
        return sex;
    }

    public void setSex(SheepSex sex) {
        this.sex = sex;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Characteristics characteristics) {
        this.characteristics = characteristics;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Kinship getKinship() {
        return kinship;
    }

    public void setKinship(Kinship kinship) {
        this.kinship = kinship;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Pregnancy getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(Pregnancy pregnancy) {
        this.pregnancy = pregnancy;
    }
}
