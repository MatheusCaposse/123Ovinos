package com.ovinos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ovinos.DTO.SheepDTO;
import com.ovinos.entity.Enum.BatchType;
import com.ovinos.entity.Enum.SheepSex;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Batch {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private BatchType batchType;

    @OneToMany(mappedBy = "batch", fetch = FetchType.EAGER)
    private List<Sheep> listSheep = new ArrayList<>();

    public void addSheep(Sheep sheep){
        listSheep.add(sheep);
        sheep.setBatch(this);
    }

    public Batch (){}

    public Batch(String id, BatchType batchType) {
        this.id = id;
        this.batchType = batchType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BatchType getBatchType() {
        return batchType;
    }

    public void setBatchType(BatchType batchType) {
        this.batchType = batchType;
    }

    public int getTotalAnimal() {
        return listSheep != null ? listSheep.size() : 0;
    }

    public void setListSheep(List<Sheep> batch) {
        this.listSheep = batch;
    }

    public int getTotalMale(){
        List<Sheep> list = this.getListSheepSex();
        int numberOfMale=0;
        for(Sheep sheep : list){
            if(sheep.getSex()== SheepSex.MACHO){
                numberOfMale+=1;
            }
        }
        return numberOfMale;
    }

    public int getTotalFemale(){
        List<Sheep> list = this.getListSheepSex();
        int numberOfFemale =0;
        for(Sheep sheep : list){
            if(sheep.getSex()== SheepSex.FEMEA){
                numberOfFemale +=1;
            }
        }
        return numberOfFemale;
    }

    @JsonIgnore
    public List<Sheep> getListSheepSex() {
        List<Sheep> obj = listSheep
                .stream()
                .toList();
        return obj;
    }

    @JsonIgnore
    public List<SheepDTO> getListSheep() {
        List<SheepDTO> obj = listSheep
                .stream()
                .map(SheepDTO::new)
                .toList();
        return obj;
    }


}
