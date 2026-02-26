package com.ovinos.entity;

import com.ovinos.DTO.SheepDTO;
import com.ovinos.entity.Enum.BatchType;
import com.ovinos.entity.superClass.Sheep;
import com.ovinos.repository.SheepRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Batch {

    @Id
    private String id;

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

    public List<SheepDTO> getListSheep() {
        List<SheepDTO> obj = listSheep
                .stream()
                .map(SheepDTO::new)
                .toList();
        return obj;
    }


}
