package com.ovinos.service;

import com.ovinos.entity.auxiliarData.Weight;
import com.ovinos.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightService {

    @Autowired
    private WeightRepository repository;

    public List<Weight> findAll(){
        List<Weight> list = repository.findAll();
        return list;
    }
}
