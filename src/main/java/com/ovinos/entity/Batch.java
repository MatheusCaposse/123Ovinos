package com.ovinos.entity;

import com.ovinos.entity.Enum.BatchType;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Batch {

    @Id
    private String id;

    private BatchType batchType;
    private int totalAnimal = 0;

    @OneToMany(mappedBy = "batch")
    private List<Sheep> batch = new ArrayList<>();

    public void addSheep(Sheep sheep){
        batch.add(sheep);
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
        return batch.size();
    }

    public void setBatch(List<Sheep> batch) {
        this.batch = batch;
    }

    public List<Sheep> getBatch() {
        return batch;
    }


}
