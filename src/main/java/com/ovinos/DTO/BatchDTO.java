package com.ovinos.DTO;

import com.ovinos.entity.Batch;
import com.ovinos.entity.Enum.BatchType;
import com.ovinos.entity.superClass.Sheep;
import com.ovinos.repository.BatchRepository;

import java.util.ArrayList;
import java.util.List;

public class BatchDTO {
    private String id;

    private BatchType batchType;
    private int totalAnimal = 0;


    public BatchDTO (){}

    public BatchDTO(Batch batch) {
        this.id = batch.getId();
        this.batchType = batch.getBatchType();
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

}
