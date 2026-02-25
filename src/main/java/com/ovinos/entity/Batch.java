package com.ovinos.entity;

import com.ovinos.entity.Enum.BatchType;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Batch {

    @Id
    private String id;

    private BatchType batchType;
    private int totalAnimal;

    @OneToMany(mappedBy = "batch")
    private List<Sheep> batch;

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
        return totalAnimal;
    }

    public List<Sheep> getBatch() {
        return batch;
    }


}
