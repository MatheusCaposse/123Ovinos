package com.ovinos.service;

import com.ovinos.entity.Batch;
import com.ovinos.repository.BatchRepository;
import com.ovinos.service.exception.BatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchService {

    @Autowired
    private BatchRepository repository;

    public List<Batch> findAll(){
        List<Batch> list = repository.findAll();
        return list;
    }

    public Batch findById(String id){
        Batch obj = repository.findById(id).orElseThrow(()-> new BatchException("Batch not found"));
        return obj;
    }

}
